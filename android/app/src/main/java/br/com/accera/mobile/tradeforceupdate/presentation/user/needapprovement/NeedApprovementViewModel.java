package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.GetUsersByAuthorizedStatusCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.UpdateUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class NeedApprovementViewModel extends BaseObservableViewModel<NeedApprovementObservables, NeedApprovementState> {

    private GetUsersByAuthorizedStatusCase mGetUsersByAuthorizedStatusCase;
    private UpdateUserCase mUpdateUserCase;

    @Inject
    public NeedApprovementViewModel(GetUsersByAuthorizedStatusCase getUsersByAuthorizedStatusCase, UpdateUserCase updateUserCase) {
        mGetUsersByAuthorizedStatusCase = addUseCase(getUsersByAuthorizedStatusCase);
        mUpdateUserCase = addUseCase(updateUserCase);
    }

    public void loadUsersAuthorized() {
        mState.mAuthStatus.set(true);
        getUsers();
    }

    public void loadUsersNotAuthorized() {
        mState.mAuthStatus.set(false);
        getUsers();
    }

    public void changeUserAuthorization(User item) {
        item.setAuthorized(!item.isAuthorized());
        RxCaseExecutor.execute(mUpdateUserCase, item)
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onSuccess(User user) {
                        mObservable.mApprove.setValue(getToastMessage(user));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void loadUsers() {
        getUsers();
    }

    private void getUsers(){
        RxCaseExecutor.execute(mGetUsersByAuthorizedStatusCase, mState.mAuthStatus.get())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getState().mLoading.set(true);
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onNext(List<User> users) {
                        getState().mLoading.set(false);
                        mObservable.mUsers.setValue(users);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private String getToastMessage(User user) {
        if (user.isAuthorized()){
            return user.getFirstName() + " " + "foi autorizado!";
        }

        return user.getFirstName() + " " + "foi revogado!";
    }
}
