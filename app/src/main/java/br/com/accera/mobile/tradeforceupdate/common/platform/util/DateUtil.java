package br.com.accera.mobile.tradeforceupdate.common.platform.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class DateUtil {
    public static final String DEFAULT_FORMAT = "dd-MM-yyyy HH:mm";

    public static String getCurrentDate() {
        return formatToString( new Date() );
    }

    public static String addDaysMappingToString( int daysAfeterToday ) {
        Calendar date = Calendar.getInstance();
        date.add( Calendar.DAY_OF_MONTH, daysAfeterToday );
        return formatToString( date.getTime() );
    }

    private static String formatToString( Date date ) {
        return new SimpleDateFormat( DEFAULT_FORMAT, Locale.getDefault() ).format( date );
    }
}
