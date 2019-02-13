package br.com.accera.mobile.tradeforceupdate.domain.appversion.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.EntityObserverCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class GetAppVersionsCase extends EntityObserverCase<Void, List<AppVersion>> {
    private AppVersionRepository mRepository;

    @Inject
    public GetAppVersionsCase( AppVersionRepository userRepository ) {
        mRepository = userRepository;
    }

    @Override
    protected Observable<List<AppVersion>> getObservable( Void aVoid ) {
        return mRepository.getAllVersions();
    }

}
