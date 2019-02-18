package br.com.accera.mobile.tradeforceupdate.domain.user.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Observable;

public class GetUsersByAuthorizedStatusCase extends EntityObserverCase<Boolean, List<User>> {

    private UserRepository mRepository;

    @Inject
    public GetUsersByAuthorizedStatusCase( UserRepository repository ) {
        mRepository = repository;
    }

    @Override
    protected Observable<List<User>> getObservable(Boolean authorized) {
        return mRepository.getAllUsers(authorized);
    }
}
