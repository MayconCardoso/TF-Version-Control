package br.com.accera.mobile.tradeforceupdate.data.user.datasource;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreObserver;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class UserDatasourceImpl implements UserDatasource {

    private CollectionReference mUserCollection;
    private FirebaseAuth mAuth;

    @Inject
    public UserDatasourceImpl( FirebaseFirestore firestore, FirebaseAuth auth ) {
        mUserCollection = firestore.collection( "users" );
        mAuth = auth;
    }

    @Override
    public Single<User> tryRegister( User user, String password ) {
        return Single.defer( () -> Single.create( emmiter ->
                mAuth.createUserWithEmailAndPassword( user.getEmail(), password ).addOnCompleteListener( task -> {
                    if( task.isSuccessful() ) {
                        onUserCreated( user, emmiter );
                        return;
                    }

                    emmiteUserFailed( emmiter, task );
                } )
        ) );
    }

    @Override
    public Maybe<User> getUserByEmail( String email ) {
        return Maybe.defer( () -> Maybe.create( emitter -> {
            mUserCollection.document( email ).get().addOnSuccessListener( documentSnapshot -> {
                if( emitter == null || emitter.isDisposed() ) return;
                emitter.onSuccess( documentSnapshot.toObject( User.class ) );
            } ).addOnFailureListener( e -> {
                if( emitter == null || emitter.isDisposed() ) return;
                emitter.onError( e );
            } );
        } ) );
    }

    @Override
    public Observable<User> observeUser( String email ) {
        return RxFirestoreObserver.create( User.class ).observeDocument(
                mUserCollection.document( email )
        );
    }

    private void emmiteUserFailed( SingleEmitter<User> emmiter, Task<AuthResult> task ) {
        if( emmiter == null || emmiter.isDisposed() ) {
            return;
        }

        emmiter.onError( task.getException() );
    }

    private void onUserCreated( User user, SingleEmitter<User> emmiter ) {
        mUserCollection.document( user.getEmail() )
                .set( user )
                .addOnSuccessListener( documentReference -> emmiter.onSuccess( user ) )
                .addOnFailureListener( emmiter::onError );
    }
}
