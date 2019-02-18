package br.com.accera.mobile.tradeforceupdate.data.user.datasource;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public interface UserDatasource {
    Single<User> tryRegister( User user, String password );
    Maybe<User> getUserByEmail( String email );

    Observable<User> observeUser( String email );
    Observable<List<User>> getAllUsers(boolean authorized);
    Single<User> updateUser(User user);
}
