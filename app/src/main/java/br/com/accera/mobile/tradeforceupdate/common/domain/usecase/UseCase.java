package br.com.accera.mobile.tradeforceupdate.common.domain.usecase;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface UseCase<Input, Output> {
    Output run( Input value);

    void cancel();
}
