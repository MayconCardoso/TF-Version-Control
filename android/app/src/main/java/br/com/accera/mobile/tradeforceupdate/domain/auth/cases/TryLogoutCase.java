package br.com.accera.mobile.tradeforceupdate.domain.auth.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class TryLogoutCase extends CompletableUseCase<Void> {

    private AuthSession mAuthSession;

    @Inject
    public TryLogoutCase( AuthSession authSession ) {
        mAuthSession = authSession;
    }

    @Override
    public Completable run( Void valeu ) {
        return mAuthSession.disconnect();
    }

    public Completable run() {
        return run( null );
    }
}
