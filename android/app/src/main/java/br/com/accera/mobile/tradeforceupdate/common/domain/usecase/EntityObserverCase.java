package br.com.accera.mobile.tradeforceupdate.common.domain.usecase;

import androidx.annotation.CallSuper;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.ObservableUseCase;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
public abstract class EntityObserverCase<INPUT, OUTPUT> extends ObservableUseCase<INPUT, OUTPUT> {
    private CompositeDisposable mDisposable = new CompositeDisposable();

    protected abstract Observable<OUTPUT> getObservable( INPUT input );

    @Override
    public final Observable<OUTPUT> run( INPUT input ) {
        return Observable.defer( () -> {
            cancel();
            return getObservable( input ).doOnSubscribe( mDisposable::add );

        } );
    }

    @Override
    @CallSuper
    public void cancel() {
        mDisposable.clear();
    }
}
