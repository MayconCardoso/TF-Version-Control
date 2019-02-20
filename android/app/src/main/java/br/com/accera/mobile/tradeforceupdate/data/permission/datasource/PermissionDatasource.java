package br.com.accera.mobile.tradeforceupdate.data.permission.datasource;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import io.reactivex.Observable;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public interface PermissionDatasource {
    Observable<List<Permission>> getUserPermissions();
}
