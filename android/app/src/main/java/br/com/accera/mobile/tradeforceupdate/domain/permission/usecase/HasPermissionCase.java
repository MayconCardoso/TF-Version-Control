package br.com.accera.mobile.tradeforceupdate.domain.permission.usecase;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.BaseUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class HasPermissionCase extends BaseUseCase<HasPermissionCase.Request, Boolean> {

    @Override
    public Boolean run( Request request ) {
        for ( Permission permission : request.user.getPermissions() ) {
            if( permission.getAction().equals( request.action ) ) {
                return true;
            }
        }
        return false;
    }


    public static class Request {
        private User user;
        private String action;

        public Request( User user, String action ) {
            this.user = user;
            this.action = action;
        }
    }
}
