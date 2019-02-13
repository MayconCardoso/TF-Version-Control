package br.com.accera.mobile.tradeforceupdate.presentation.user.register;

import javax.inject.Inject;

import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.RequiredFieldValidation;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.RegisterUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.Profile;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.rx.SingleObserver;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class RegisterUserViewModel extends BaseObservableViewModel<RegisterUserObservables, RegisterUserState> {

    private RegisterUserCase mRegisterUserCase;

    @Inject
    public RegisterUserViewModel( RegisterUserCase registerUserCase ) {
        mRegisterUserCase = addUseCase( registerUserCase );
    }

    public void requestSystenAccess( String name, String lastName, String email, String pass, String rePass ) {
        cleanAllErrors();

        if( isDataInvalid( name, lastName, email, pass, rePass ) ) {
            return;
        }

        // Create user
        User user = createUser( name, lastName, email );

        // Create request
        RegisterUserCase.Request request = createRequest( pass, user );

        // Run use case
        RxCaseExecutor.execute( mRegisterUserCase, request ).subscribe( new SingleObserver<User>() {
            @Override
            public void onSubscribe( Disposable disposable ) {
                getCompositeDisposable().add( disposable );
                getHideKeyboard().call();

                mState.mLoading.set( true );
            }

            @Override
            public void onSuccessEvent( User user ) {
                mObservable.mWaitingApprovement.setValue( user );
            }

            @Override
            public void onErrorEvent( Throwable throwable ) {
                getAlertFeedback().setValue( new AlertMessage.Builder()
                        .setTitle( R.string.atenttion )
                        .setMessage( throwable.getMessage() )
                );
            }

            @Override
            public void onAnyResponseEvent() {
                mState.mLoading.set( false );
            }
        } );
    }

    private RegisterUserCase.Request createRequest( String pass, User user ) {
        RegisterUserCase.Request request = new RegisterUserCase.Request();
        request.setUser( user );
        request.setPassword( pass );
        return request;
    }

    private User createUser( String name, String lastName, String email ) {
        User user = new User();
        user.setFirstName( name );
        user.setLastName( lastName );
        user.setEmail( email );
        user.setProfile( Profile.OPERATION );
        return user;
    }

    private boolean isDataInvalid( String name, String lastName, String email, String pass, String rePass ) {
        // Required fields
        boolean valid = RequiredFieldValidation.check( mResourceUtil, name, mState.mFirstNameError );
        valid &= RequiredFieldValidation.check( mResourceUtil, lastName, mState.mLastNameError );
        valid &= RequiredFieldValidation.check( mResourceUtil, email, mState.mEmailError );
        valid &= RequiredFieldValidation.check( mResourceUtil, pass, mState.mPasswordError );
        valid &= RequiredFieldValidation.check( mResourceUtil, rePass, mState.mPasswordError );

        // Pass validation
        valid &= passwordValidation( pass, rePass );

        return !valid;
    }

    private boolean passwordValidation( String pass, String rePass ) {
        if( pass.equals( rePass ) ) {
            return true;
        }
        mState.mPasswordError.set( mResourceUtil.getString( R.string.password_doesnt_matche ) );

        return false;
    }

    private void cleanAllErrors() {
        mState.mFirstNameError.set( "" );
        mState.mLastNameError.set( "" );
        mState.mEmailError.set( "" );
        mState.mPasswordError.set( "" );
    }
}