package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.UseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.AlertMessage;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback.HideKeyboard;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.ResourceUtil;
import io.reactivex.disposables.CompositeDisposable;

/**
 * É como se fosse o PRESENTER do MVP.
 * Só para quem não conhece esse padrão conseguir fazer uma associação.
 *
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public abstract class BaseViewModel extends ViewModel {
    //==============================================================================================
    // OBJECTS
    //==============================================================================================
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private final List<UseCase> mUseCaseList = new ArrayList<>();
    private final AlertMessage mAlertMessage = new AlertMessage();
    private final HideKeyboard mHideKeyboard = new HideKeyboard();

    protected ResourceUtil mResourceUtil;

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // LIFE-CYCLE
    //==============================================================================================
    @Override
    protected void onCleared() {
        if( !mCompositeDisposable.isDisposed() ) {
            mCompositeDisposable.dispose();
        }
        releaseUseCases();
        super.onCleared();
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // EVENTS
    //==============================================================================================
    public AlertMessage getAlertFeedback() {
        return mAlertMessage;
    }

    public HideKeyboard getHideKeyboard() {
        return mHideKeyboard;
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODOS
    //==============================================================================================
    @Inject
    public void setResourceUtil( ResourceUtil resourceUtil ) {
        mResourceUtil = resourceUtil;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    protected <USECASE extends UseCase> USECASE addUseCase( USECASE useCase ) {
        mUseCaseList.add( useCase );
        return useCase;
    }

    private void releaseUseCases() {
        for ( UseCase useCase : mUseCaseList ) {
            useCase.cancel();
        }
    }
    //==============================================================================================
}