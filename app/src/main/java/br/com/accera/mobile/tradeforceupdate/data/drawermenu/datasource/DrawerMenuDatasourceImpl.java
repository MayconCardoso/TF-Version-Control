package br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreDocumentObserver;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuDatasourceImpl implements DrawerMenuDatasource {

    private CollectionReference mDrawerCollection;

    @Inject
    public DrawerMenuDatasourceImpl( FirebaseFirestore firebaseFirestore ) {
        mDrawerCollection = firebaseFirestore.collection( "drawer_menu" );
    }

    @Override
    public Completable createMenu() {
        return Completable.defer( () -> Completable.create( emitter -> mDrawerCollection
                .document( getDrawerMenuVersion() )
                .set( new DrawerMenuCreator().createDrawer() )
                .addOnCompleteListener( task -> emitter.onComplete())
        ) );
    }

    private String getDrawerMenuVersion() {
        return "V1";
    }

    @Override
    public Observable<Drawer> getDrawerMenu() {
        return RxFirestoreDocumentObserver.create( Drawer.class ).observe(
                mDrawerCollection.document(getDrawerMenuVersion())
        );
    }
}
