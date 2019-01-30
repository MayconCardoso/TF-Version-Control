package br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.ListenerRegistration;

import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
public class RxFirestoreDocumentObserver<VALUE> {
    private ListenerRegistration mRegistrationCallback = null;
    private Class<VALUE> mObservedEntityClass;

    public RxFirestoreDocumentObserver( Class<VALUE> observedEntityClass ) {
        mObservedEntityClass = observedEntityClass;
    }

    public Observable<VALUE> observe( DocumentReference reference ) {
        return Observable.defer( () -> Observable.<VALUE>create( emitter -> mRegistrationCallback =
                        reference.addSnapshotListener( ( documentSnapshot, e ) -> {
                            if( emitter == null || emitter.isDisposed() ) return;
                            if( documentSnapshot == null ) {
                                emitter.onComplete();
                                return;
                            }
                            if( !documentSnapshot.exists() ) {
                                emitter.onComplete();
                                return;
                            }

                            emitter.onNext( documentSnapshot.toObject( mObservedEntityClass ) );
                        } ) ).doOnDispose( () -> {
                    if( mRegistrationCallback != null ) {
                        AppLogger.d( "Dismiss observeUser callback" );
                        mRegistrationCallback.remove();
                    }
                } )
        );
    }

    public static <T> RxFirestoreDocumentObserver<T> create( Class<T> className ) {
        return new RxFirestoreDocumentObserver<>( className );
    }
}
