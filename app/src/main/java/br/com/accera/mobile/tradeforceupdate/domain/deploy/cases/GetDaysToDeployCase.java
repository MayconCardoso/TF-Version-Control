package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import java.util.ArrayList;
import java.util.List;

import br.com.accera.mobile.tradeforceupdate.common.platform.util.DateUtil;

/**
 * @author MAYCON CARDOSO on 05/02/2019.
 */
public class GetDaysToDeployCase {

    public List<String> run( int daysToDeploy, int countDaysNecessary ) {
        List<String> response = new ArrayList<>();

        for ( int deployDay = 1; deployDay <= daysToDeploy; deployDay++ ) {
            response.add( getDay( deployDay * countDaysNecessary ) );
        }

        return response;
    }

    private String getDay( int daysAfeterToday ) {
        return DateUtil.addDaysMappingToString( daysAfeterToday );
    }
}
