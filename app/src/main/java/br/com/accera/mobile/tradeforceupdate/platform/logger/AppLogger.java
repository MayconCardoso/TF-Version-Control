package br.com.accera.mobile.tradeforceupdate.platform.logger;

import br.com.accera.mobile.tradeforceupdate.BuildConfig;
import timber.log.Timber;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public final class AppLogger {

    private AppLogger() {
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
    }

    public static void e(Throwable throwable, String s, Object... objects) {
        Timber.e(throwable, s, objects);
    }

    public static void e(Throwable throwable, Object... objects) {
        Timber.e(throwable, throwable.getMessage(), objects);
    }

    public static void i(String s, Object... objects) {
        Timber.i(s, objects);
    }

    public static void w(String s, Object... objects) {
        Timber.w(s, objects);
    }

    public static void init() {
        if ( BuildConfig.DEBUG ) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}