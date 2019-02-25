package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class GetAllInstancesCase extends EntityObserverCase<Void, List<Instance>> {
    private InstanceRepository mRepository;

    @Inject
    public GetAllInstancesCase(InstanceRepository repository ) {
        mRepository = repository;
    }

    @Override
    protected Observable<List<Instance>> getObservable(Void aVoid) {
        return mRepository.getAllInstances();
    }
}
