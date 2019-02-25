package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.HasPermissionCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.PermissionChecker;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 04/02/2019.
 */
// TODO: 25/02/19 need permission check
public class RegisterInstanceCase extends CompletableUseCase<Instance> implements PermissionChecker {

    private InstanceRepository mRepository;
    private HasPermissionCase mHasPermissionCase;

    @Inject
    public RegisterInstanceCase(InstanceRepository userRepository, HasPermissionCase hasPermissionCase) {
        mRepository = userRepository;
        mHasPermissionCase = hasPermissionCase;
    }

    @Override
    public Completable run(Instance value) {
        return Completable.defer( () -> {
            if( StringUtil.isEmpty( value.getName() ) )
                throw new IllegalArgumentException( "Name cannot be null" );
            if( StringUtil.isEmpty( value.getDbName() ) )
                throw new IllegalArgumentException( "DBName cannot be null" );
            if( StringUtil.isEmpty( value.getTotalUsuarios() + "" ) )
                throw new IllegalArgumentException( "Count users cannot be null" );
            if( value.getCurrentVersion() == null )
                throw new IllegalArgumentException( "Versions cannot be null" );
            if( value.getOwner() == null )
                throw new IllegalArgumentException( "App Owner cannot be null" );

            return mHasPermissionCase.run(getPermission())
                    .flatMapCompletable(hasPermission -> mRepository.register( value ) );
        } );
    }

    @Override
    public PermissionAvailable getPermission() {
        return PermissionAvailable.REGISTER_INSTANCE;
    }
}
