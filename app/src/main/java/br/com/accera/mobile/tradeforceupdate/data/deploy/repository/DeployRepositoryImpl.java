package br.com.accera.mobile.tradeforceupdate.data.deploy.repository;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.deploy.datasource.DeployDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import io.reactivex.Completable;

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
}
