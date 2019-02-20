package br.com.accera.mobile.tradeforceupdate.domain.permission.repository;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import io.reactivex.Observable;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public interface PermissionRepository {
    Observable<List<Permission>> getUserPermissions();
}
