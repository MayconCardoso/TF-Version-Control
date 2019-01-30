package br.com.accera.mobile.tradeforceupdate.data.auth.datasource;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public interface AuthDatasource {
    Single<User> getUser();

    Completable logout();

    Single<User> tryLogin( String email, String password);
}
