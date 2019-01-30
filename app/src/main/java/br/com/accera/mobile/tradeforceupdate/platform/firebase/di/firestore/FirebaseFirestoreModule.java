package br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
@Module
public abstract class FirebaseFirestoreModule {

    @Provides
    @Singleton
    static FirebaseFirestore provideFirebaseFirestore() {
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled( true )
                .build();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.setFirestoreSettings( settings );
        return db;
    }

}
