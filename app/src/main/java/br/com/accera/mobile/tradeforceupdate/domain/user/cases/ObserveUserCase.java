package br.com.accera.mobile.tradeforceupdate.domain.user.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 23/01/2019.
 */
public class ObserveUserCase extends EntityObserverCase<String, User> {
    private UserRepository mRepository;

    @Inject
    public ObserveUserCase( UserRepository repository ) {
        mRepository = repository;
    }

    @Override
    protected Observable<User> getObservable( String email ) {
        return mRepository.observerUser( email );
    }
}
