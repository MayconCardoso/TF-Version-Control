package br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.BaseUseCase;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public abstract class ObservableUseCase<Input, Output> extends BaseUseCase<Input, Observable<Output>> {
}
