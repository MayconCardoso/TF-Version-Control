package br.com.accera.mobile.tradeforceupdate.domain.instance.cases;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class FilterInstanceByGroupCase {
    @Inject
    public FilterInstanceByGroupCase() {
    }

    public List<Instance> run( List<Instance> value, int group ) {
        List<Instance> response = new ArrayList<>();
        for ( Instance instance : value ) {
            if( instance.getUpdateGroup() == group ) {
                response.add( instance );
            }
        }
        return response;
    }
}
