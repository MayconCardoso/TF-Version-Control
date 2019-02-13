package br.com.accera.mobile.tradeforceupdate.data.appversion.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.data.appversion.datasource.AppVersionDatasource;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public class AppVersionRepositoryImpl implements AppVersionRepository {
    private AppVersionDatasource mDatasource;

    @Inject
    public AppVersionRepositoryImpl( AppVersionDatasource datasource ) {
        mDatasource = datasource;
    }

    @Override
    public Completable register( AppVersion version ) {
        return mDatasource.register( version );
    }

    @Override
    public Observable<List<AppVersion>> getAllVersions() {
        return mDatasource.getAllVersions();
    }
}
