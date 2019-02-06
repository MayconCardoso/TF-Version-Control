package br.com.accera.mobile.tradeforceupdate.common.domain.usecase;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface CancelableUseCase<Input, Output> extends UseCase<Input, Output>{
    void cancel();
}
