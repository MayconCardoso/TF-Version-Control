package br.com.accera.mobile.tradeforceupdate.common.domain.usecase;

import androidx.annotation.CallSuper;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.ObservableUseCase;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
public abstract class EntityObserverCase<INPUT, OUTPUT> extends ObservableUseCase<INPUT, OUTPUT> {
    private Disposable mDisposable;

    protected abstract Observable<OUTPUT> getObservable( INPUT input );

    @Override
    public final Observable<OUTPUT> run( INPUT input ) {
        return getObservable( input ).doOnSubscribe( disposable -> mDisposable = disposable );
    }

    @Override
    @CallSuper
    public void cancel() {
        if( mDisposable == null || mDisposable.isDisposed() ) return;
        mDisposable.dispose();
        mDisposable = null;
    }
}
