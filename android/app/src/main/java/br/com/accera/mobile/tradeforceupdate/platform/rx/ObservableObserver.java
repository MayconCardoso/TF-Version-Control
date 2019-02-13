package br.com.accera.mobile.tradeforceupdate.platform.rx;

import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;
import io.reactivex.disposables.Disposable;

/**
 * @author MAYCON CARDOSO on 17/01/2019.
 */
public abstract class ObservableObserver<T> implements io.reactivex.Observer<T> {
    //==============================================================================================
    // IMPLEMENTATION
    //==============================================================================================
    @Override
    public void onSubscribe( Disposable d ) {

    }

    @Override
    public final void onNext( T t ) {
        onAnyResponseEvent();
        onNextEvent( t );
    }

    @Override
    public void onComplete() {

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
    public abstract void onNextEvent( T t );

    public void onErrorEvent( Throwable e ){
        AppLogger.e( e );
    }

    public void onAnyResponseEvent(){

    }
}
