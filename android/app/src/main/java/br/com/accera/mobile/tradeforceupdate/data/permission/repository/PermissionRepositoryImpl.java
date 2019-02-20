package br.com.accera.mobile.tradeforceupdate.data.permission.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.permission.datasource.PermissionDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.permission.repository.PermissionRepository;
import io.reactivex.Observable;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionRepositoryImpl implements PermissionRepository {

    private PermissionDatasource mPermissionDatasource;

    @Inject
    public PermissionRepositoryImpl(PermissionDatasource permissionDatasource) {
        mPermissionDatasource = permissionDatasource;
    }

    @Override
    public Observable<List<Permission>> getUserPermissions() {
        return mPermissionDatasource.getUserPermissions();
    }
}
