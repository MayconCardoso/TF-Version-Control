package br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.BaseUseCase;
import io.reactivex.Maybe;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public abstract class MaybeUseCase<Input, Output> extends BaseUseCase<Input, Maybe<Output>> {
}
