package br.com.accera.mobile.tradeforceupdate.data.auth.repository;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.auth.datasource.AuthDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.auth.repository.AuthRepository;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class AuthRepositoryImpl implements AuthRepository {

    private AuthDatasource mUserDatasource;

    @Inject
    public AuthRepositoryImpl( AuthDatasource userDatasource ) {
        mUserDatasource = userDatasource;
    }

    @Override
    public Single<User> getLoggedUser() {
        return mUserDatasource.getUser();
    }

    @Override
    public Single<User> tryLogin( String email, String password ) {
        return mUserDatasource.tryLogin( email, password );
    }

    @Override
    public Completable logout() {
        return mUserDatasource.logout();
    }

    @Override
    public Single<Boolean> recoverPassword(String email) {
        return mUserDatasource.tryRecoverPassword(email);
    }
}
