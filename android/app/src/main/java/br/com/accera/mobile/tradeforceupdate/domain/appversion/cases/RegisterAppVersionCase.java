package br.com.accera.mobile.tradeforceupdate.domain.appversion.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.repository.AppVersionRepository;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.HasPermissionCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.PermissionChecker;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class RegisterAppVersionCase extends CompletableUseCase<AppVersion> implements PermissionChecker {
    private AppVersionRepository mRepository;
    private HasPermissionCase mHasPermissionCase;

    @Inject
    public RegisterAppVersionCase( AppVersionRepository userRepository, HasPermissionCase hasPermissionCase ) {
        mRepository = userRepository;
        mHasPermissionCase = hasPermissionCase;
    }

    @Override
    public Completable run( AppVersion value ) {
        return Completable.defer( () -> {
            if( StringUtil.isEmpty( value.getVersionCode() ) )
                throw new IllegalArgumentException( "VersionCode cannot be null" );
            if( StringUtil.isEmpty( value.getVersionName() ) )
                throw new IllegalArgumentException( "VersionName cannot be null" );
            if( StringUtil.isEmpty( value.getApkPath() ) )
                throw new IllegalArgumentException( "ApkPath cannot be null" );

            return mHasPermissionCase.run(getPermission())
                    .flatMapCompletable(hasPermission -> mRepository.register( value ));
        });
    }

    @Override
    public PermissionAvailable getPermission() {
        return PermissionAvailable.VERSION_CREATE;
    }
}
