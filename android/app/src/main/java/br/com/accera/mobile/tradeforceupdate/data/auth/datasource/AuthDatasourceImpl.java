package br.com.accera.mobile.tradeforceupdate.data.auth.datasource;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.auth.exception.LoggedUserEmpty;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class AuthDatasourceImpl implements AuthDatasource {

    private FirebaseAuth mAuth;
    private UserRepository mUserRepository;
    private User mCachedUser;

    @Inject
    public AuthDatasourceImpl( FirebaseAuth auth, UserRepository userRepository ) {
        mAuth = auth;
        mUserRepository = userRepository;
    }

    @Override
    public synchronized Single<User> getUser() {
        return Single.defer( () -> {
            if( mAuth.getCurrentUser() == null ) return Single.error( new LoggedUserEmpty() );

            return mUserRepository.getUserByEmail( mAuth.getCurrentUser().getEmail() )
                    .doOnSuccess( user -> mCachedUser = user ).toSingle()
                    .onErrorResumeNext( throwable -> Single.error( new LoggedUserEmpty() ) );
        } );
    }

    @Override
    public Single<User> tryLogin( String email, String password ) {
        return Single.defer( () -> Single.<String>create( emmiter ->
                mAuth.signInWithEmailAndPassword( email, password ).addOnCompleteListener( task -> {
                    if( task.isSuccessful() ) {
                        emitteUserAfterAuth( emmiter );
                        return;
                    }

                    emmiteUserFailed( emmiter, task );
                } ) ).flatMap( userEmail -> getUser() )
        );
    }

    @Override
    public synchronized Completable logout() {
        return Completable.fromAction( () -> {
            mCachedUser = null;
            mAuth.signOut();
        } );
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // PRIVATES
    //==============================================================================================

    private void emmiteUserFailed( SingleEmitter<String> emmiter, Task<AuthResult> task ) {
        if( emmiter == null || emmiter.isDisposed() ) return;

        emmiter.onError( task.getException() );
    }

    private void emitteUserAfterAuth( SingleEmitter<String> emmiter) {
        if( emmiter == null || emmiter.isDisposed() ) return;

        emmiter.onSuccess( "" );
    }

    //==============================================================================================

}
