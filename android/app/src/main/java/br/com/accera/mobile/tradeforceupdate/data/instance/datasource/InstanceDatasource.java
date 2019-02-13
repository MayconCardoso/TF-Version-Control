package br.com.accera.mobile.tradeforceupdate.data.instance.datasource;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public interface InstanceDatasource {

    Completable register( Instance instance );

    Observable<List<Instance>> getAllInstancesByOwner( String owner );
}
