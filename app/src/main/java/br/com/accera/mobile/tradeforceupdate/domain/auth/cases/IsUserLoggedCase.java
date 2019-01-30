package br.com.accera.mobile.tradeforceupdate.domain.auth.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class IsUserLoggedCase extends SingleUseCase<Void, Boolean> {

    private AuthSession mAuthSession;

    @Inject
    public IsUserLoggedCase( AuthSession authSession ) {
        mAuthSession = authSession;
    }

    @Override
    public Single<Boolean> run( Void value ) {
        return mAuthSession.isUserLogged();
    }

    public Single<Boolean> run(){
        return run( null );
    }
}
