package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.CompletableUseCase;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.repository.DeployRepository;
import io.reactivex.Completable;

/**
 * @author MAYCON CARDOSO on 19/02/2019.
 */
public class DoDeployCase extends CompletableUseCase<Deploy> {
    private DeployRepository mDeployRepository;

    @Inject
    public DoDeployCase( DeployRepository deployRepository ) {
        mDeployRepository = deployRepository;
    }

    @Override
    public Completable run( Deploy deploy ) {
        return Completable.defer( () -> {
            deploy.setDone( true );
            return mDeployRepository.doDeploy( deploy );
        } );
    }
}
