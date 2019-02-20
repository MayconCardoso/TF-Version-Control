package br.com.accera.mobile.tradeforceupdate.domain.deploy.repository;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public interface DeployRepository {
    Completable scheduleDeploy( ScheduleDeploy scheduleDeploy);

    Observable<ScheduleDeploy> getScheduleByVersionName( String versionName );

    CompletableSource doDeploy( Deploy deploy );
}