package br.com.accera.mobile.tradeforceupdate.domain.deploy.cases;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.UseCase;

/**
 * @author MAYCON CARDOSO on 10/02/2019.
 */
public class GetNecessaryDaysToDeployCase {

    public int run() {
        return getDaysToForthTuesdayOfMonth();
    }

    private int getDaysToForthTuesdayOfMonth() {
        return 0;
    }
}
