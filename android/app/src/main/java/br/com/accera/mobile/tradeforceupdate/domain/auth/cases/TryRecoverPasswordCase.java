package br.com.accera.mobile.tradeforceupdate.domain.auth.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by LuisAlmeida on 25/02/19.
 */

public class TryRecoverPasswordCase extends SingleUseCase<TryRecoverPasswordCase.Request, Boolean> {

    private AuthSession mAuthSession;

    @Inject
    public TryRecoverPasswordCase ( AuthSession authSession) { mAuthSession = authSession; }

    @Override
    public Single run(Request value) {
        if( value == null ) throw new IllegalArgumentException( "Request cannot be null." );

        return Single.defer( () -> mAuthSession.tryRecoverPassword( value.email ) );

    }


    public static class Request {
        public String email;

        public Request(String email) {
            this.email = email;
        }
    }
}
