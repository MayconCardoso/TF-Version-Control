package br.com.accera.mobile.tradeforceupdate.common.domain.usecase;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
public abstract class BaseUseCase<Input, Output> implements CancelableUseCase<Input, Output> {
    @Override
    public void cancel() {

    }
}
