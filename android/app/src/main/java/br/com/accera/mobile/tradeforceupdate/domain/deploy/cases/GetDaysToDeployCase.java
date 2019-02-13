package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import java.util.ArrayList;
import java.util.List;

import br.com.accera.mobile.tradeforceupdate.common.platform.util.DateUtil;

/**
 * @author MAYCON CARDOSO on 05/02/2019.
 */
public class GetDaysToDeployCase {

    public List<String> run( int initialDays, int countOfDays, int interval) {
        List<String> response = new ArrayList<>();

        for ( int deployDay = 1; deployDay <= countOfDays; deployDay++ ) {
            response.add( getDay( initialDays + (deployDay * interval) ) );
        }

        return response;
    }

    private String getDay( int daysAfeterToday ) {
        return DateUtil.addDaysMappingToString( daysAfeterToday );
    }
}
