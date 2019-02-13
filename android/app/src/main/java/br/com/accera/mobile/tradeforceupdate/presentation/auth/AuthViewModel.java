package br.com.accera.mobile.tradeforceupdate.presentation.auth;

import android.text.TextUtils;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.auth.cases.TryAuthenticateCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.rx.SingleObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class AuthViewModel extends BaseObservableViewModel<AuthObservables, AuthState> {

    private TryAuthenticateCase mTryAuthenticateCase;

    @Inject
    public AuthViewModel( TryAuthenticateCase tryAuthenticateCase ) {
        mTryAuthenticateCase = addUseCase( tryAuthenticateCase );
    }

    public void tryLogin( String email, String password ) {
        // Execute authentication case.
        RxCaseExecutor.execute(
                mTryAuthenticateCase,
                new TryAuthenticateCase.Request( email, password )
        ).subscribe( new SingleObserver<User>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                getHideKeyboard().call();
                mState.mLoading.set( true );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }

            @Override
            public void onSuccessEvent( User user ) {
                // User has been logged in.
                mObservable.mDashboardNavigation.call();
            }

            @Override
            public void onErrorEvent( Throwable throwable ) {
                getAlertFeedback().setValue( new AlertMessage.Builder()
                        .setTitle( R.string.atenttion )
                        .setMessage( throwable.getMessage() )
                );
            }
        } );
    }

    public void requestAccess( String email ) {
        mObservable.mRequestAccessNavigation.setValue( TextUtils.isEmpty( email ) ? null : email);
    }
}