package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.instance.repository.InstanceRepository;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 04/02/2019.
 */
public class RegisterInstanceCase extends CompletableUseCase<Instance> {
    private InstanceRepository mRepository;

    @Inject
    public RegisterInstanceCase( InstanceRepository userRepository ) {
        mRepository = userRepository;
    }

    @Override
    public Completable run( Instance value ) {
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

            return mRepository.register( value );
        } );
    }
}
