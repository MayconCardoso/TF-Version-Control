package br.com.accera.mobile.tradeforceupdate.platform.auth;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.auth.repository.AuthRepository;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class AuthSessionImpl implements AuthSession {

    private AuthRepository mAuthRepository;

    @Inject
    public AuthSessionImpl( AuthRepository authRepository ) {
        mAuthRepository = authRepository;
    }

    @Override
    public Single<Boolean> isUserLogged() {
        return mAuthRepository.getLoggedUser().map( user -> true );
    }

    @Override
    public Single<User> getLoggedUser() {
        return mAuthRepository.getLoggedUser();
    }

    @Override
    public Single<User> tryConnect( String email, String password ) {
        return mAuthRepository.tryLogin( email, password );
    }

    @Override
    public Completable disconnect() {
        return mAuthRepository.logout();
    }

    @Override
    public Single<Boolean> tryRecoverPassword(String email) {
        return mAuthRepository.recoverPassword(email);
    }
}
