package br.com.accera.mobile.tradeforceupdate.domain.appversion.repository;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface AppVersionRepository {
    Completable register( AppVersion version );
    Observable<List<AppVersion>> getAllVersions();
}