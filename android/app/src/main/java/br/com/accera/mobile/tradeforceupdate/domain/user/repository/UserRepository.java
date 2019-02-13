package br.com.accera.mobile.tradeforceupdate.domain.user.repository;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public interface UserRepository {
    Single<User> tryRegisterUser( User user, String password );
    Maybe<User> getUserByEmail( String email );
    Observable<User> observerUser( String email );
}
