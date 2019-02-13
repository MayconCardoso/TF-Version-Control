package br.com.accera.mobile.tradeforceupdate.platform.exception;

import br.com.accera.mobile.tradeforceupdate.platform.logger.AppLogger;

/**
 * @author MAYCON CARDOSO on 15/01/2019.
 */
public class ErroHandler {
    public static void handlerError(Throwable e){
        AppLogger.e( e );
    }
}
