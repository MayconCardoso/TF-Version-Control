package br.com.accera.mobile.tradeforceupdate.domain.permission.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.permission.repository.PermissionRepository;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Single;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class GetUserPermissionsCase extends SingleUseCase<User, List<Permission>> {

    private PermissionRepository mPermissionRepository;

    @Inject
    public GetUserPermissionsCase(PermissionRepository permissionRepository) {
        mPermissionRepository = permissionRepository;
    }

    @Override
    public Single<List<Permission>> run(User user) {

        return Single.defer(()->{
            List<Permission> userPermissions = user.getPermissions() != null? user.getPermissions():new ArrayList<>();

            return mPermissionRepository.getUserPermissions()
                    .flatMapIterable(permissions -> permissions)
                    .map(permission -> {
                        if (userPermissions.contains(permission)){
                            permission.setActive(true);
                        }
                        return permission;
                    }).toList();
        });

    }
}
