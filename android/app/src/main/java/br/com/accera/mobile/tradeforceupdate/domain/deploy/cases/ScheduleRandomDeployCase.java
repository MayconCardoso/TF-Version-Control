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
import br.com.accera.mobile.tradeforceupdate.domain.instance.cases.FilterInstanceRandomlyCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.InstanceOwner;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 04/02/2019.
 */
public class ScheduleRandomDeployCase extends CompletableUseCase<ScheduleRandomDeployCase.Request> {
    private InstanceRepository mRepository;
    private DeployRepository mDeployRepository;
    private CreateDeployCase mCreateDeployCase;
    private FilterInstanceRandomlyCase mFilterInstanceRandomlyCase;


    @Inject
    public ScheduleRandomDeployCase( InstanceRepository userRepository, DeployRepository deployRepository, CreateDeployCase createDeployCase, FilterInstanceRandomlyCase filterInstanceRandomlyCase ) {
        mRepository = userRepository;
        mDeployRepository = deployRepository;
        mCreateDeployCase = createDeployCase;
        mFilterInstanceRandomlyCase = filterInstanceRandomlyCase;
    }

    @Override
    public Completable run( Request value ) {
        return Completable.defer( () -> {
            // Get days necessary to next deploy.
            int daysNecessary = new GetNecessaryDaysToDeployCase().run();

            // Get days that will have deploy.
            List<String> daysToDeploy = new GetDaysToDeployCase().run( daysNecessary, value.countDeploy, value.countNecessaryDays );

            // Get all technology's instances.
            return mRepository.getAllInstancesByOwner( InstanceOwner.TECH.getOwner() )
                    // Get first element to not perform infinity cycle.
                    .firstElement()
                    // Map it to an schedule deploy
                    .map( instances -> createDeploys( instances, daysToDeploy, value.version, value.initialPercent ) )
                    // Save schedule.
                    .flatMapCompletable( mDeployRepository::scheduleDeploy );
        } );
    }

    private ScheduleDeploy createDeploys( List<Instance> instances, List<String> daysToDeploy, AppVersion version, int initialPercent ) {
        List<Deploy> deploys = new ArrayList<>();

        // All clients we have.
        int totalInstances = instances.size();

        // Count of clients that will be on the fist deploy.
        int countOfInitialClients = Math.round( (initialPercent * totalInstances) / 100 );

        // Count of another clients that won't be on the first deploy.
        int restOfClients = totalInstances - countOfInitialClients;

        // Add first deploy.
        deploys.add( mCreateDeployCase.run(
                daysToDeploy.get( 0 ),
                mFilterInstanceRandomlyCase.run( countOfInitialClients, instances ),
                version
        ) );

        // Get count of clients of each deploy
        int countDrawnClientsOnEachDeploy = Math.round( restOfClients / daysToDeploy.size() - 1 );

        // Add other deploys, except the last one.
        for ( int daysIndex = 1; daysIndex < daysToDeploy.size() - 1; daysIndex++ ) {
            deploys.add( mCreateDeployCase.run(
                    daysToDeploy.get( daysIndex ),
                    mFilterInstanceRandomlyCase.run( countDrawnClientsOnEachDeploy, instances ),
                    version
            ) );

            // Decrement drawn clients.
            restOfClients -= countDrawnClientsOnEachDeploy;
        }

        // Add last deploy.
        deploys.add( mCreateDeployCase.run( daysToDeploy.get( daysToDeploy.size() - 1 ), mFilterInstanceRandomlyCase.run( restOfClients, instances ), version ) );

        // Create schedule
        ScheduleDeploy schedule = new ScheduleDeploy();
        schedule.setCreatedDate( DateUtil.getCurrentDate() );
        schedule.setVersion( version );
        schedule.setDeploys( deploys );
        return schedule;
    }

    public static class Request {
        private int countDeploy;
        private int countNecessaryDays;
        private int initialPercent;
        private AppVersion version;

        public Request( int countDeploy, int countNecessaryDays, int initialPercent, AppVersion version ) {
            this.countDeploy = countDeploy;
            this.countNecessaryDays = countNecessaryDays;
            this.initialPercent = initialPercent;
            this.version = version;
        }

        public int getCountDeploy() {
            return countDeploy;
        }

        public int getCountNecessaryDays() {
            return countNecessaryDays;
        }

        public int getInitialPercent() {
            return initialPercent;
        }

        public AppVersion getVersion() {
            return version;
        }
    }
}
