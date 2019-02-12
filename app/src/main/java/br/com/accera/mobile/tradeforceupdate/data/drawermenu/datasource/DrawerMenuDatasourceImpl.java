package br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.platform.firebase.di.firestore.RxFirestoreObserver;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuDatasourceImpl extends BaseFirestoreDatasource<Drawer> implements DrawerMenuDatasource {

    @Inject
    public DrawerMenuDatasourceImpl( FirebaseFirestore firebaseFirestore ) {
        super( firebaseFirestore.collection( "drawer_menu" ) );
    }

    @Override
    public Completable createMenu() {
        return register( new DrawerMenuCreator().createDrawer(), getDrawerMenuVersion() );
    }

    private String getDrawerMenuVersion() {
        return "V1";
    }

    @Override
    public Observable<Drawer> getDrawerMenu() {
        return RxFirestoreObserver.create( Drawer.class ).observeDocument(
                mCollection.document( getDrawerMenuVersion() )
        );
    }
}
