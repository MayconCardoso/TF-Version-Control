package br.com.accera.mobile.tradeforceupdate.domain.auth.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class GetLoggedUserCase extends SingleUseCase<Void, User> {

    private AuthSession mAuthSession;

    @Inject
    public GetLoggedUserCase( AuthSession authSession ) {
        mAuthSession = authSession;
    }

    @Override
    public Single<User> run( Void value ) {
        return mAuthSession.getLoggedUser();
    }

    public Single<User> run(){
        return run( null );
    }
}
