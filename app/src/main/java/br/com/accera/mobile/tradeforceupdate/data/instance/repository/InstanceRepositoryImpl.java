package br.com.accera.mobile.tradeforceupdate.data.instance.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.instance.datasource.InstanceDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public class InstanceRepositoryImpl implements InstanceRepository {
    private InstanceDatasource mInstanceDatasource;

    @Inject
    public InstanceRepositoryImpl( InstanceDatasource instanceDatasource ) {
        mInstanceDatasource = instanceDatasource;
    }

    @Override
    public Completable register( Instance instance ) {
        return mInstanceDatasource.register( instance );
    }

    @Override
    public Observable<List<Instance>> getAllInstances() {
        return mInstanceDatasource.getAllInstances();
    }
}
