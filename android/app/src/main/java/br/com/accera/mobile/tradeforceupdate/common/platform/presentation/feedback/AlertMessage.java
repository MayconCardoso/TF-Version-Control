package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.feedback;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.lifecycle.LifecycleOwner;
import br.com.accera.mobile.tradeforceupdate.common.platform.livedata.SingleLiveEvent;

/**
 * A SingleLiveEvent used for Snackbar messages. Like a {@link SingleLiveEvent} but also prevents
 * null messages and uses a custom observer.
 * <p>
 * Note that only one observer is going to be notified of changes.
 */
public class AlertMessage extends SingleLiveEvent<AlertMessage.Builder> {

    public void observe(LifecycleOwner owner, final MessageObserver observer) {
        super.observe(owner, builder -> {
            if (builder == null) {
                return;
            }
            observer.onNewMessage(builder);
        } );
    }

    public interface MessageObserver {
        void onNewMessage( Builder builder );
    }

    public static class Builder {
        private @StringRes int title;
        private @StringRes int message;
        private String titleStr;
        private String messageStr;

        public Builder setTitle( @StringRes int title ) {
            this.title = title;
            return this;
        }

        public Builder setMessage( @StringRes int message ) {
            this.message = message;
            return this;
        }

        public Builder setMessage( String message ) {
            this.messageStr = message;
            return this;
        }

        public String getMessage( Context context ) {
            if(messageStr != null){
                return messageStr;
            }

            return context.getString( message );
        }

        public String getTitle( Context context ) {
            if(titleStr != null){
                return titleStr;
            }

            return context.getString( title );
        }
    }
}