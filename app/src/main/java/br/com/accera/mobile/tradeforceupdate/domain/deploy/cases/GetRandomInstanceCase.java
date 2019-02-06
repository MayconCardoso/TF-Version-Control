package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.UseCase;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 06/02/2019.
 */
public class GetRandomInstanceCase implements UseCase<List<Instance>, Instance> {
    @Inject
    public GetRandomInstanceCase() {
    }

    @Override
    public Instance run( List<Instance> value ) {
        int index = new Random().nextInt( value.size() - 1 );
        return value.get( index );
    }
}
