package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import javax.inject.Inject;

/**
 * É como se fosse o PRESENTER do MVP.
 * Só para quem não conhece esse padrão conseguir fazer uma associação.
 *
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public abstract class BaseObservableViewModel<OBSERVABLE extends DataObservable, STATE extends DataState> extends BaseViewModel {
    //==============================================================================================
    // OBJECTS
    //==============================================================================================

    /**
     * Has all observable objects that the view will be subscribed.
     */
    protected OBSERVABLE mObservable;
    /**
     * Has all view state like a progress bar state or a message state.
     */
    protected STATE mState;
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODOS
    //==============================================================================================

    @Inject
    public void setObservable( OBSERVABLE observable ) {
        mObservable = observable;
    }

    @Inject
    public void setState( STATE state ) {
        mState = state;
    }

    public OBSERVABLE getObservable() {
        return mObservable;
    }

    public STATE getState() {
        return mState;
    }
    //==============================================================================================
}