package br.com.accera.mobile.tradeforceupdate.data.base;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreObserver;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public class BaseFirestoreDatasource<ENTITY> {
    protected CollectionReference mCollection;

    public BaseFirestoreDatasource( CollectionReference collection ) {
        mCollection = collection;
    }

    public Completable register( ENTITY entity, String key ) {
        return Completable.defer( () -> Completable.create( emitter -> mCollection.document( key )
                .set( entity )
                .addOnSuccessListener( new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess( Void aVoid ) {
                        emitter.onComplete();
                    }
                } )
                .addOnFailureListener( emitter::onError )
        ) );
    }

    public Observable<List<ENTITY>> getAll(Class<ENTITY> entityClass, String order) {
        return RxFirestoreObserver.create( entityClass ).observeCollection(
                mCollection.orderBy( order, Query.Direction.DESCENDING )
        );
    }

    public Observable<List<ENTITY>> getAll(Class<ENTITY> entityClass, Query query) {
        return RxFirestoreObserver.create( entityClass ).observeCollection( query );
    }

    public Observable<List<ENTITY>> getFirstList(Class<ENTITY> entityClass, Query query) {
        return RxFirestoreObserver.create( entityClass ).getCollectionValue( query );
    }




}
