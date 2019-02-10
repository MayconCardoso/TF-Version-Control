package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class FilterInstanceRandomlyCase {

    private GetRandomInstanceCase mGetRandomInstanceCase;

    @Inject
    public FilterInstanceRandomlyCase( GetRandomInstanceCase getRandomInstanceCase ) {
        mGetRandomInstanceCase = getRandomInstanceCase;
    }

    public List<Instance> run( int countOfInitialClients, List<Instance> instances ) {
        List<Instance> filtered = new ArrayList<>();

        for ( int count = 0; count < countOfInitialClients; count++ ) {
            // Get random instance.
            Instance instance = mGetRandomInstanceCase.run( instances );

            // Remove it from array to don't repeat it in the next call.
            instances.remove( instance );

            // Add on new array
            filtered.add( instance );
        }

        return filtered;
    }
}
