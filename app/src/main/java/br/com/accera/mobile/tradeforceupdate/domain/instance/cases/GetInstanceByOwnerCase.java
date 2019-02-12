package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.ObservableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class GetInstanceByOwnerCase extends EntityObserverCase<String, List<Instance>> {
    private InstanceRepository mRepository;

    @Inject
    public GetInstanceByOwnerCase( InstanceRepository repository ) {
        mRepository = repository;
    }

    @Override
    protected Observable<List<Instance>> getObservable( String value ) {
        return mRepository.getAllInstancesByOwner( value );
    }

}
