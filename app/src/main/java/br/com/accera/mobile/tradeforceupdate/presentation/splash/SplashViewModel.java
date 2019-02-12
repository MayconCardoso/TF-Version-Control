package br.com.accera.mobile.tradeforceupdate.presentation.splash;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.error.ErrorHandler;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm.BaseObservableViewModel;
import br.com.accera.mobile.tradeforceupdate.domain.auth.cases.GetLoggedUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.auth.exception.LoggedUserEmpty;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.cases.CreateDrawer;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.platform.exception.ErroHandler;
import br.com.accera.mobile.tradeforceupdate.platform.rx.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public class SplashViewModel extends BaseObservableViewModel<SplashObservables, SplashState> {
    //==============================================================================================
    // OBJETOS
    //==============================================================================================
    private final GetLoggedUserCase getLoogedUserCase;
    private final CreateDrawer mCreateDrawer;
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CONSTRUCTORS
    //==============================================================================================

    @Inject
    public SplashViewModel( GetLoggedUserCase isUserLoggedCase, CreateDrawer createDrawer ) {
        getLoogedUserCase = addUseCase( isUserLoggedCase );
        mCreateDrawer = createDrawer;
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODS
    //==============================================================================================

    public void checkAuth() {
//        RxCaseExecutor.execute( getLoogedUserCase )
        RxCaseExecutor.execute( mCreateDrawer ).andThen( RxCaseExecutor.execute( getLoogedUserCase ) )
                .delay( 1, TimeUnit.SECONDS )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new SingleObserver<User>() {
                    @Override
                    public void onSubscribe( Disposable disposable ) {
                        getCompositeDisposable().add( disposable );
                    }

                    @Override
                    public void onSuccessEvent( User user ) {
                        if(user.isAuthorized()){
                            mObservable.mDashboardNavitation.call();
                        }
                        else{
                            mObservable.mWaitingAppovementNavitation.setValue( user );
                        }
                    }

                    @Override
                    public void onErrorEvent( Throwable e ) {
                        ErrorHandler.newBuilder( e )
                                .addConsumer( LoggedUserEmpty.class, excetion -> mObservable.mLoginNavitation.call() )
                                .setDefault( ErroHandler::handlerError )
                                .call();
                    }
                } );

    }

    //==============================================================================================
}