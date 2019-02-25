package br.com.accera.mobile.tradeforceupdate.domain.permission.exceptions;

/**
 * Created by Rafael Spitaliere on 25/02/19.
 */
public class UserUnauthorizedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Usuário não possui permissão para executar essa ação!";
    }
}
