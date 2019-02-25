package br.com.accera.mobile.tradeforceupdate.domain.instance.repository;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface InstanceRepository {

    Completable register( Instance instance );

    Observable<List<Instance>> getAllInstancesByOwner( String value );

    Observable<List<Instance>> getAllInstances(  );

}
