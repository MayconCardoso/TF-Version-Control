package br.com.accera.mobile.tradeforceupdate.common.platform.livedata;

import androidx.databinding.ObservableField;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.ResourceUtil;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class RequiredFieldValidation {
    public static boolean check( ResourceUtil resourceUtil, String name, ObservableField<String> observableField ) {
        if( StringUtil.isEmpty( name ) ) {
            observableField.set( resourceUtil.getString( R.string.required_field ) );
            return false;
        }
        return true;
    }

}
