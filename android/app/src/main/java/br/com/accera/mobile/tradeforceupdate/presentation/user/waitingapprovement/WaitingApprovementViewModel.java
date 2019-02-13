package br.com.accera.mobile.tradeforceupdate.presentation.user.waitingapprovement;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.user.cases.ObserveUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.rx.ObservableObserver;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class WaitingApprovementViewModel extends BaseObservableViewModel<WaitingApprovementObservables, WaitingApprovementState> {
    private ObserveUserCase mObserveUserCase;

    @Inject
    public WaitingApprovementViewModel( ObserveUserCase observeUserCase ) {
        mObserveUserCase = addUseCase( observeUserCase );
    }

    public void init() {
        mState.mMessage.set( mResourceUtil.getString( R.string.waiting_approvement ) );
    }

    public void observeUser( User user ) {
        if( user == null ) {
            throw new IllegalArgumentException( "User cannot be null" );
        }

        RxCaseExecutor.execute( mObserveUserCase, user.getEmail() ).subscribe( new ObservableObserver<User>() {
            @Override
            public void onNextEvent( User user ) {
                onUserUpdated( user );
            }
        } );
    }

    private void onUserUpdated( User user ) {
        if( user.isAuthorized() ) {
            mState.mMessage.set( mResourceUtil.getString( R.string.user_request_approved ) );
            mState.mWaitingApprovement.set( false );
            cancelUserObserver();
        }
    }

    public void cancelUserObserver() {
        mObserveUserCase.cancel();
    }
}