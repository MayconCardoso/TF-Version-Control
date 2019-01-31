package br.com.accera.mobile.tradeforceupdate.common.platform.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class DateUtil {
    public static String getCurrentDate() {
        return new SimpleDateFormat( "yyyy-MM-dd HH:mm", Locale.getDefault() ).format( new Date() );
    }
}
