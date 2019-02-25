package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.DateUtil;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import br.com.accera.mobile.tradeforceupdate.domain.instance.cases.FilterInstanceByGroupCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.InstanceOwner;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.HasPermissionCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.PermissionChecker;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 04/02/2019.
 */
public class ScheduleDeployByGroupCase extends CompletableUseCase<AppVersion> implements PermissionChecker {
    private final InstanceRepository mRepository;
    private final DeployRepository mDeployRepository;
    private final CreateDeployCase mCreateDeployCase;
    private final FilterInstanceByGroupCase mFilterInstanceByGroupCase;
    private HasPermissionCase mHasPermissionCase;
    private final int mCountOfDays = 3;

    @Inject
    public ScheduleDeployByGroupCase(InstanceRepository userRepository, DeployRepository deployRepository, CreateDeployCase createDeployCase, FilterInstanceByGroupCase filterInstanceByGroupCase,
                                     HasPermissionCase hasPermissionCase) {
        mRepository = userRepository;
        mDeployRepository = deployRepository;
        mCreateDeployCase = createDeployCase;
        mFilterInstanceByGroupCase = filterInstanceByGroupCase;
        mHasPermissionCase = hasPermissionCase;
    }

    @Override
    public Completable run( AppVersion value ) {
        return Completable.defer( () -> {
            // Get days necessary to next deploy.
            int daysNecessary = new GetNecessaryDaysToDeployCase().run();

            // Get days that will have deploy.
            List<String> daysToDeploy = new GetDaysToDeployCase().run( daysNecessary, mCountOfDays, 7 );

            // Verify user's permission
            return mHasPermissionCase.run(getPermission())
                    // Get all technology's instances.
                    .flatMapObservable(hasPermission -> mRepository.getAllInstancesByOwner( InstanceOwner.TECH.getOwner() ))
                    // Get first element to not perform infinity cycle.
                    .firstElement()
                    // Map it to an schedule deploy
                    .map( instances -> createDeploys( instances, daysToDeploy, value ) )
                    // Save schedule.
                    .flatMapCompletable( mDeployRepository::scheduleDeploy );
        } );
    }

    private ScheduleDeploy createDeploys( List<Instance> instances, List<String> daysToDeploy, AppVersion version ) {
        List<Deploy> deploys = new ArrayList<>();

        // Create deploy by day
        for ( int day = 0; day < mCountOfDays; day++ ) {
            // Get the group.
            int group = day + 1;

            // Add deploy.
            deploys.add( mCreateDeployCase.run(
                    daysToDeploy.get( day ),
                    mFilterInstanceByGroupCase.run( instances, group ),
                    version
            ) );
        }

        // Create schedule
        ScheduleDeploy schedule = new ScheduleDeploy();
        schedule.setCreatedDate( DateUtil.getCurrentDate() );
        schedule.setVersion( version );
        schedule.setDeploys( deploys );
        return schedule;
    }

    @Override
    public PermissionAvailable getPermission() {
        return PermissionAvailable.SCHEDULE_DEPLOY;
    }
}
