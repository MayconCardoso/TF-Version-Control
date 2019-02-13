package br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class RxCaseExecutor {
    public static <Input, Output> Single<Output> execute( SingleUseCase<Input, Output> useCase ) {
        return execute( useCase, null );
    }

    public static <Input, Output> Single<Output> execute( SingleUseCase<Input, Output> useCase, Input request ) {
        return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
    }

    public static <Input, Output> Observable<Output> execute( ObservableUseCase<Input, Output> useCase ) {
        return execute( useCase, null );
    }

    public static <Input, Output> Observable<Output> execute( ObservableUseCase<Input, Output> useCase, Input request ) {
        return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
    }

    public static <Input> Completable execute( CompletableUseCase<Input> useCase ) {
        return execute( useCase, null );
    }

    public static <Input> Completable execute( CompletableUseCase<Input> useCase, Input request ) {
        return useCase.run( request ).subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() );
    }
}
