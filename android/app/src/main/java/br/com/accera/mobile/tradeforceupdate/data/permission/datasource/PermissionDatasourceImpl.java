package br.com.accera.mobile.tradeforceupdate.data.permission.datasource;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import io.reactivex.Observable;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionDatasourceImpl extends BaseFirestoreDatasource<Permission> implements PermissionDatasource {

    @Inject
    public PermissionDatasourceImpl(FirebaseFirestore firestore) {
        super(firestore.collection("permissions"));
    }

    @Override
    public Observable<List<Permission>> getUserPermissions() {
        Query query = mCollection.limit(50);

        return getFirstList(Permission.class, query);
    }
}
