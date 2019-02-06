package br.com.accera.mobile.tradeforceupdate.data.instance.datasource;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public class InstanceDatasourceImpl extends BaseFirestoreDatasource<Instance> implements InstanceDatasource {

    @Inject
    public InstanceDatasourceImpl( FirebaseFirestore firestore ) {
        super( firestore.collection( "instance" ) );
    }


    @Override
    public Completable register( Instance instance ) {
        return register( instance, instance.getDbName() );
    }

    @Override
    public Observable<List<Instance>> getAllInstancesByOwner( String value ) {
        return getAll( Instance.class, mCollection
                .whereEqualTo( "owner", value )
                .orderBy( "name", Query.Direction.ASCENDING )
        );
    }
}
