package br.com.accera.mobile.tradeforceupdate.domain.auth.session;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public interface AuthSession {
    Single<Boolean> isUserLogged();

    Single<User> getLoggedUser();

    Single<User> tryConnect( String email, String password );

    Completable disconnect();

    Single<Boolean> tryRecoverPassword(String email);
}
