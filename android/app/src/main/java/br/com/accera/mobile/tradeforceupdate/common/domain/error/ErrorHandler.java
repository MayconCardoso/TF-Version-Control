package br.com.accera.mobile.tradeforceupdate.common.domain.error;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MAYCON CARDOSO on 21/01/2019.
 */
public class ErrorHandler {
    private Map<Class<? extends Throwable>, Consumer<?>> mConsumers = new HashMap<>();
    private Consumer<Throwable> mDefaultHandler;

    private <T extends Throwable> void call( T throwable ) {
        Consumer<T> consumer = (Consumer<T>) mConsumers.get( throwable.getClass() );

        if( consumer != null ) {
            consumer.handle( throwable );
            return;
        }

        if( mDefaultHandler != null ) {
            mDefaultHandler.handle( throwable );
            return;
        }

        throw new RuntimeException( "Error handler not found" );
    }

    public static Builder newBuilder( Throwable e ){
        return new Builder( e );
    }

    public static class Builder {
        private ErrorHandler handler = new ErrorHandler();
        private Throwable mThrowable;

        public Builder( Throwable throwable ) {
            mThrowable = throwable;
        }

        public <ERROR extends Throwable> Builder addConsumer( Class<ERROR> errorClass, Consumer<ERROR> action ) {
            handler.mConsumers.put( errorClass, action );
            return this;
        }


        public Builder setDefault( Consumer<Throwable> action ) {
            handler.mDefaultHandler = action;
            return this;
        }

        public void call() {
            handler.call( mThrowable );
        }
    }

    public interface Consumer<T extends Throwable> {
        void handle( T excetion );
    }
}
