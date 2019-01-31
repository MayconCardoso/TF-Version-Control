package br.com.accera.mobile.tradeforceupdate.data.appversion.datasource;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 30/01/2019.
 */
public interface AppVersionDatasource {
    Completable register( AppVersion version );
    Observable<List<AppVersion>> getAllVersions();
}
