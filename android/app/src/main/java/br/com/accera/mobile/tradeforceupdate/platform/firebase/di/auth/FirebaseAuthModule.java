package br.com.accera.mobile.tradeforceupdate.platform.firebase.di.auth;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
@Module
public abstract class FirebaseAuthModule {
    @Provides
    @Singleton
    static FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }
}
