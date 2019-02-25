package br.com.accera.mobile.tradeforceupdate.domain.permission.usecase;

import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;

/**
 * Created by Rafael Spitaliere on 25/02/19.
 */
public interface PermissionChecker {

    PermissionAvailable getPermission();

}
