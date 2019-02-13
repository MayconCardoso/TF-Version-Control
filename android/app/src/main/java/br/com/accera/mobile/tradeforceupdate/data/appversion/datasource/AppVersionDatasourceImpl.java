package br.com.accera.mobile.tradeforceupdate.data.appversion.datasource;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.base.BaseFirestoreDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class AppVersionDatasourceImpl extends BaseFirestoreDatasource<AppVersion> implements AppVersionDatasource {
    @Inject
    public AppVersionDatasourceImpl( FirebaseFirestore firestore ) {
        super( firestore.collection( "app_version" ) );
    }

    @Override
    public Completable register( AppVersion version ) {
        return register( version, version.getVersionName() );
    }

    @Override
    public Observable<List<AppVersion>> getAllVersions() {
        return getAll( AppVersion.class, "versionCode" );
    }
}
