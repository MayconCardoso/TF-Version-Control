package br.com.accera.mobile.tradeforceupdate.data.deploy.datasource;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreObserver;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.internal.operators.completable.CompletableDefer;

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

    @Override
    public Observable<ScheduleDeploy> getScheduleByVersionName( String versionName ) {
        return RxFirestoreObserver.create( ScheduleDeploy.class ).observeDocument(
                mCollection.document( versionName )
        );
    }

    @Override
    public CompletableSource doDeploy( Deploy deploy ) {
        return Completable.complete();
    }
}
