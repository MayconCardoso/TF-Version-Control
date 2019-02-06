package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class CreateDeployCase {

    private GetRandomInstanceCase mGetRandomInstanceCase;

    @Inject
    public CreateDeployCase( GetRandomInstanceCase getRandomInstanceCase ) {
        mGetRandomInstanceCase = getRandomInstanceCase;
    }

    public Deploy run( String date, List<Instance> instances, int countOfInitialClients, AppVersion version ) {
        Deploy deploy = new Deploy();
        deploy.setVersion( version );
        deploy.setDate( date );
        int countAffectUsers = 0;

        for ( int count = 0; count < countOfInitialClients; count++ ) {
            // Get random instance.
            Instance instance = mGetRandomInstanceCase.run( instances );

            // Remove it from array to don't repeat it in the next call.
            instances.remove( instance );

            // Sum total of affected users.
            countAffectUsers += instance.getTotalUsuarios();

            // Add instance on schedule.
            deploy.addInstance( instance );
        }

        deploy.setTotalClients( deploy.getInstances().size() );
        deploy.setAffectedUsers( countAffectUsers );

        return deploy;
    }
}
