package br.com.accera.mobile.tradeforceupdate.domain.user.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.HasPermissionCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.PermissionChecker;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Single;

public class UpdateUserCase extends SingleUseCase<User, User> implements PermissionChecker {

    private UserRepository mUserRepository;
    private HasPermissionCase mHasPermissionCase;

    @Inject
    public UpdateUserCase(UserRepository userRepository, HasPermissionCase hasPermissionCase) {
        mUserRepository = userRepository;
        mHasPermissionCase = hasPermissionCase;
    }

    @Override
    public Single<User> run(User value) {
        return mHasPermissionCase.run(getPermission())
                .flatMap(hasPermission -> mUserRepository.updateUser(value));
    }

    @Override
    public PermissionAvailable getPermission() {
        return PermissionAvailable.UPDATE_USER_INFO;
    }
}
