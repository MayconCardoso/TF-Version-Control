package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.GetUserPermissionsCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.UpdateUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */

public class PermissionViewModel extends BaseObservableViewModel<PermissionObservables, PermissionState> {

    private GetUserPermissionsCase mGetUserPermissionsCase;
    private UpdateUserCase mUpdateUserCase;
    private User mUser;

    @Inject
    public PermissionViewModel(GetUserPermissionsCase getUserPermissionsCase, UpdateUserCase updateUserCase) {
        mGetUserPermissionsCase = addUseCase(getUserPermissionsCase);
        mUpdateUserCase = updateUserCase;
    }

    public void loadPermissions() {

        if (mObservable.mPermissions.getValue() != null) {
            return;
        }

        RxCaseExecutor.execute(mGetUserPermissionsCase, mUser)
                .subscribe(new SingleObserver<List<Permission>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Permission> permissions) {
                        mObservable.mPermissions.setValue(permissions);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void savePermissions(){
        List<Permission> value = getPermissions();

        mUser.setPermissions(value);
        RxCaseExecutor.execute(mUpdateUserCase, mUser)
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(User user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private List<Permission> getPermissions() {
        List<Permission> value = new ArrayList<>(mObservable.mPermissions.getValue());

        for (Permission p : value) {
            if (!p.isActive()){
                value.remove(p);
            }
        }
        return value;
    }

    public void setUser(User user) {
        if(mUser == null){
            mUser = user;
        }
    }
}
