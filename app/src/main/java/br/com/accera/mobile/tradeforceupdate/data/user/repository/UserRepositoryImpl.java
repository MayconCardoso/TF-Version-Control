package br.com.accera.mobile.tradeforceupdate.data.user.repository;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.user.datasource.UserDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class UserRepositoryImpl implements UserRepository {

    private UserDatasource mUserDatasource;

    @Inject
    public UserRepositoryImpl( UserDatasource userDatasource ) {
        mUserDatasource = userDatasource;
    }

    @Override
    public Single<User> tryRegisterUser( User user, String password ) {
        return mUserDatasource.tryRegister( user, password );
    }

    @Override
    public Maybe<User> getUserByEmail( String email ) {
        return mUserDatasource.getUserByEmail( email );
    }

    @Override
    public Observable<User> observerUser( String email ) {
        return mUserDatasource.observeUser( email );
    }
}
