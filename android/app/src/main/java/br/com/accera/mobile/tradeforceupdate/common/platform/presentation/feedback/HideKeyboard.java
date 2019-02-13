package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback;

import androidx.lifecycle.LifecycleOwner;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;

/**
 * @author MAYCON CARDOSO on 21/01/2019.
 */
public class HideKeyboard extends SingleLiveEvent<Void> {
    public void observe( LifecycleOwner owner, final HideKeyboardObserver observer ) {
        super.observe( owner, builder -> observer.hide() );
    }

    public interface HideKeyboardObserver {
        void hide();
    }
}