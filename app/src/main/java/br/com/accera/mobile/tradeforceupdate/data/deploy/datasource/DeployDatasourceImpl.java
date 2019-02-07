package br.com.accera.mobile.tradeforceupdate.data.deploy.datasource;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class DeployDatasourceImpl extends BaseFirestoreDatasource<ScheduleDeploy> implements DeployDatasource {

    @Inject
    public DeployDatasourceImpl( FirebaseFirestore firestore ) {
        super( firestore.collection( "schedule_deploy" ) );
    }

    @Override
    public Completable scheduleDeploy( ScheduleDeploy scheduleDeploy ) {
        return register( scheduleDeploy, scheduleDeploy.getDeploys().get( 0 ).getVersion().getVersionName() );
    }
}
