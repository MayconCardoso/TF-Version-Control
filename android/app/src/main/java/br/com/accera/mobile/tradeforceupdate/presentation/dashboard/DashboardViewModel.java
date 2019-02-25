package br.com.accera.mobile.tradeforceupdate.presentation.dashboard;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.auth.cases.TryLogoutCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.cases.GetAllInstancesCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.platform.rx.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class DashboardViewModel extends BaseObservableViewModel<DashboardObservables, DashboardState> {

    private TryLogoutCase mTryLogoutCase;
    private GetAllInstancesCase mGetAllInstancesCase;

    @Inject
    public DashboardViewModel(TryLogoutCase tryAuthenticateCase, GetAllInstancesCase getAllInstancesCase) {
        mTryLogoutCase = addUseCase(tryAuthenticateCase);
        mGetAllInstancesCase = addUseCase(getAllInstancesCase);
    }

    public void tryLogout() {
        // Execute authentication case.
        RxCaseExecutor.execute(mTryLogoutCase).subscribe(new CompletableObserver() {
            @Override
            public void onEventCompleted() {
                mObservable.mAuthScreen.call();
            }
        });
    }


    public void synchronyzeInstanceInformation() {
        RxCaseExecutor.execute(mGetAllInstancesCase).subscribe(new Observer<List<Instance>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Instance> instances) {
                HashMap<String, Integer> instanceInformation = retrieveVersionNumberAndInstanceCount(instances);
                mObservable.mPieChartInstances.setValue(instanceInformation);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private HashMap<String, Integer> retrieveVersionNumberAndInstanceCount(List<Instance> instances) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String versionName;
        for (Instance instance : instances) {
            versionName = instance.getCurrentVersion().getVersionName();

            if (!hashMap.containsKey(versionName)) {
                hashMap.put(versionName, 0);
            } else {
                hashMap.put(versionName, hashMap.get(versionName) + 1);
            }

        }
        return hashMap;
    }

}
