package br.com.accera.mobile.tradeforceupdate.data.appversion.datasource;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreObserver;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class AppVersionDatasourceImpl implements AppVersionDatasource {
    private CollectionReference mCollection;

    @Inject
    public AppVersionDatasourceImpl( FirebaseFirestore firestore ) {
        mCollection = firestore.collection( "app_version" );
    }

    @Override
    public Completable register( AppVersion version ) {
        return Completable.create( emitter -> mCollection.document( version.getVersionName() )
                .set( version )
                .addOnSuccessListener( documentReference -> emitter.onComplete() )
                .addOnFailureListener( emitter::onError )
        );
    }

    @Override
    public Observable<List<AppVersion>> getAllVersions() {
        return RxFirestoreObserver.create( AppVersion.class ).observeCollection(
                mCollection.orderBy( "versionCode", Query.Direction.DESCENDING )
        );
    }
}
