package br.com.accera.mobile.tradeforceupdate.data.deploy.datasource;

import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public interface DeployDatasource {
    Completable scheduleDeploy( ScheduleDeploy scheduleDeploy );
}
