package br.com.accera.mobile.tradeforceupdate.platform.rx;

import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;
import io.reactivex.disposables.Disposable;

/**
 * @author MAYCON CARDOSO on 17/01/2019.
 */
public abstract class CompletableObserver<T> implements io.reactivex.CompletableObserver{
    //==============================================================================================
    // IMPLEMENTATION
    //==============================================================================================
    @Override
    public void onSubscribe( Disposable d ) {
    }

    @Override
    public final void onComplete() {
        onAnyResponseEvent();
        onEventCompleted();
    }

    @Override
    public final void onError( Throwable e ) {
        onAnyResponseEvent();
        onErrorEvent( e );
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // CLIENT IMPLEMENTATION
    //==============================================================================================
    public abstract void onEventCompleted();

    public void onErrorEvent( Throwable e ){
        AppLogger.e( e );
    }

    public void onAnyResponseEvent(){

    }
}
