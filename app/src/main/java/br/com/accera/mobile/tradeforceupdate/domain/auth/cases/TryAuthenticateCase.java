package br.com.accera.mobile.tradeforceupdate.domain.auth.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class TryAuthenticateCase extends SingleUseCase<TryAuthenticateCase.Request, User> {

    private AuthSession mAuthSession;

    @Inject
    public TryAuthenticateCase( AuthSession authSession ) {
        mAuthSession = authSession;
    }

    @Override
    public Single<User> run( Request value ) {
        if( value == null ) throw new IllegalArgumentException( "Request cannot be null." );

        return Single.defer( () -> mAuthSession.tryConnect( value.email, value.password ) );
    }

    public Single<User> run() {
        return run( null );
    }

    public static class Request {
        private String email;
        private String password;

        public Request( String email, String password ) {
            this.email = email;
            this.password = password;
        }
    }
}
