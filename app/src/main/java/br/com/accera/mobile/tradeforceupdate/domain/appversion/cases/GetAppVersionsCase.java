package br.com.accera.mobile.tradeforceupdate.domain.appversion.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.ObservableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import io.reactivex.Observable;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class GetAppVersionsCase extends ObservableUseCase<Void, List<AppVersion>> {
    private AppVersionRepository mRepository;

    @Inject
    public GetAppVersionsCase( AppVersionRepository userRepository ) {
        mRepository = userRepository;
    }

    @Override
    public Observable
            <List<AppVersion>> run( Void value ) {
        return mRepository.getAllVersions();
    }
}
