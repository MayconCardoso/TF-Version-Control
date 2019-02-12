package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 10/02/2019.
 */
public class GetScheduleByVersionCase extends EntityObserverCase<AppVersion, ScheduleDeploy> {

    private DeployRepository mDeployRepository;

    @Inject
    public GetScheduleByVersionCase( DeployRepository deployRepository ) {
        mDeployRepository = deployRepository;
    }

    @Override
    protected Observable<ScheduleDeploy> getObservable( AppVersion version ) {
        return mDeployRepository.getScheduleByVersionName( version.getVersionName() );
    }

}
