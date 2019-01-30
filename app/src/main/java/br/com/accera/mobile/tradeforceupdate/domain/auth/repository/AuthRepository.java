package br.com.accera.mobile.tradeforceupdate.domain.auth.repository;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface AuthRepository {

    Single<User> getLoggedUser();

    Single<User> tryLogin( String email, String password );

    Completable logout();
}
