package br.com.accera.mobile.tradeforceupdate.domain.permission.usecase;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.exceptions.UserUnauthorizedException;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.Profile;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class HasPermissionCase extends SingleUseCase<PermissionAvailable, Boolean> {

    private AuthSession authSession;

    @Inject
    public HasPermissionCase(AuthSession authSession) {
        this.authSession = authSession;
    }

    @Override
    public Single<Boolean> run(PermissionAvailable permissionAvailable ) {
        return authSession.getLoggedUser()
                .flatMap(user -> {

                    if (!user.isAuthorized()){
                        return Single.error(new UserUnauthorizedException());
                    }

                    if (user.getProfile() == Profile.ADM){
                        return Single.just(true);
                    }

                    for ( Permission permission : user.getPermissions() ) {
                        if( permission.getAction().equals( permissionAvailable.getAction() ) ) {
                            return Single.just(true);
                        }
                    }

                    return Single.error(new UserUnauthorizedException());
                });
    }


}
