package br.com.accera.mobile.tradeforceupdate.common.platform.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public final class KeyboardUtils {

    private KeyboardUtils() {
    }

    public static void hideSoftInput(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);

        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(imm == null) return;

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftInput( EditText edit, Context context) {
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
        edit.requestFocus();

        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm == null) return;

        imm.showSoftInput(edit, 0);
    }

    public static void toggleSoftInput(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm == null) return;

        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

}