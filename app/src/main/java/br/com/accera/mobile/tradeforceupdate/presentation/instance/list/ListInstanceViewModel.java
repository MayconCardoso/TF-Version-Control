package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.instance.cases.GetInstanceByOwnerCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.InstanceOwner;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class ListInstanceViewModel extends BaseObservableViewModel<ListInstanceObservables, ListInstanceState> {

    private GetInstanceByOwnerCase mGetInstanceCase;

    @Inject
    public ListInstanceViewModel( GetInstanceByOwnerCase getAll ) {
        mGetInstanceCase = addUseCase( getAll );
    }

    public void goToRegisterPage() {
        getObservable().mRegister.call();
    }

    public void loadInstancesFromTech(){
        getInstances( InstanceOwner.TECH.getOwner() );
    }

    public void loadInstancesFromOps(){
        getInstances( InstanceOwner.OPERATION.getOwner() );
    }

    private void getInstances( String owner ) {
        // Set current selected ownser.
        mState.mInstance.set( owner );

        // Load, executing the use case.
        RxCaseExecutor.execute( mGetInstanceCase, owner ).subscribe( new ObservableObserver<List<Instance>>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                mState.mLoading.set( true );
            }

            @Override
            public void onNextEvent( List<Instance> instances ) {
                mObservable.mItens.postValue( instances );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    public void loadInstances() {
        if( TextUtils.isEmpty( mState.mInstance.get() ) ){
            mState.mInstance.set( InstanceOwner.TECH.getOwner() );
        }

        getInstances( mState.mInstance.get() );
    }
}