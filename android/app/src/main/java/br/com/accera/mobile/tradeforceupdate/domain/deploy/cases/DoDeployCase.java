package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.PermissionAvailable;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.HasPermissionCase;
import br.com.accera.mobile.tradeforceupdate.domain.permission.usecase.PermissionChecker;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 19/02/2019.
 */
public class DoDeployCase extends CompletableUseCase<Deploy> implements PermissionChecker {
    private DeployRepository mDeployRepository;
    private HasPermissionCase mHasPermissionCase;

    @Inject
    public DoDeployCase( DeployRepository deployRepository, HasPermissionCase hasPermissionCase ) {
        mDeployRepository = deployRepository;
        mHasPermissionCase = hasPermissionCase;
    }

    @Override
    public Completable run( Deploy deploy ) {
        return Completable.defer( () -> {
            deploy.setDone( true );
            return mHasPermissionCase.run(getPermission())
                    .flatMapCompletable(hasPermission -> mDeployRepository.doDeploy( deploy ));
        } );
    }

    @Override
    public PermissionAvailable getPermission() {
        return PermissionAvailable.DO_DEPLOY;
    }
}
