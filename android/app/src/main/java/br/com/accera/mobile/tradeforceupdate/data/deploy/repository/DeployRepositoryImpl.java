package br.com.accera.mobile.tradeforceupdate.data.deploy.repository;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.deploy.datasource.DeployDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class DeployRepositoryImpl implements DeployRepository {
    private DeployDatasource mDatasource;

    @Inject
    public DeployRepositoryImpl( DeployDatasource datasource ) {
        mDatasource = datasource;
    }

    @Override
    public Completable scheduleDeploy( ScheduleDeploy scheduleDeploy ) {
        return mDatasource.scheduleDeploy( scheduleDeploy );
    }

    @Override
    public Observable<ScheduleDeploy> getScheduleByVersionName( String versionName ) {
        return mDatasource.getScheduleByVersionName( versionName );
    }

    @Override
    public CompletableSource doDeploy( Deploy deploy ) {
        return mDatasource.doDeploy( deploy );
    }
}
