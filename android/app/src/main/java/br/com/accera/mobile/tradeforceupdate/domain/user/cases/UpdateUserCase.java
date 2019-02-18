package br.com.accera.mobile.tradeforceupdate.domain.user.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Single;

public class UpdateUserCase extends SingleUseCase<User, User> {

    private UserRepository mUserRepository;

    @Inject
    public UpdateUserCase(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public Single<User> run(User value) {
        return mUserRepository.updateUser(value);
    }
}
