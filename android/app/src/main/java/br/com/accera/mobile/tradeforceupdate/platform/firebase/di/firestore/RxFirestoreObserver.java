package br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
public class RxFirestoreObserver<VALUE> {
    private ListenerRegistration mRegistrationCallback = null;
    private Class<VALUE> mObservedEntityClass;

    public RxFirestoreObserver( Class<VALUE> observedEntityClass ) {
        mObservedEntityClass = observedEntityClass;
    }

    public Observable<VALUE> observeDocument( DocumentReference reference ) {
        return Observable.defer( () -> Observable.<VALUE>create( emitter -> {
            mRegistrationCallback = reference.addSnapshotListener( ( documentSnapshot, e ) -> {
                if( emitter == null || emitter.isDisposed() ) return;
                if( e != null ) emitter.onError( e );

                if( documentSnapshot == null ) {
                    emitter.onComplete();
                    return;
                }
                if( !documentSnapshot.exists() ) {
                    emitter.onComplete();
                    return;
                }

                emitter.onNext( documentSnapshot.toObject( mObservedEntityClass ) );
            } );
        } ).doOnDispose( () -> {
            if( mRegistrationCallback != null ) {
                AppLogger.d( "Dismiss observeUser callback" );
                mRegistrationCallback.remove();
            }
        } ) );
    }

    public Observable<List<VALUE>> observeCollection( Query query ) {
        return Observable.defer( () -> Observable.<List<VALUE>>create( emitter -> {
            mRegistrationCallback = query.addSnapshotListener( ( documentSnapshot, e ) -> {
                if( emitter == null || emitter.isDisposed() ) return;
                if( e != null ) emitter.onError( e );

                if( documentSnapshot == null ) {
                    emitter.onComplete();
                    return;
                }

                List<VALUE> values = new ArrayList<>();
                for ( QueryDocumentSnapshot document : documentSnapshot ) {
                    if( !document.exists() ) {
                        continue;
                    }
                    values.add( document.toObject( mObservedEntityClass ) );
                }

                emitter.onNext( values );
            } );
        } ).doOnDispose( () -> {
            if( mRegistrationCallback != null ) {
                AppLogger.d( "Dismiss observeUser callback" );
                mRegistrationCallback.remove();
            }
        } ) );
    }

    public static <T> RxFirestoreObserver<T> create( Class<T> className ) {
        return new RxFirestoreObserver<>( className );
    }
}
