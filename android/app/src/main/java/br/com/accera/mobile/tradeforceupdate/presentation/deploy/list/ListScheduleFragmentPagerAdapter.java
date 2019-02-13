package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base.BaseFragmentPagerAdapter;
import br.com.accera.mobile.tradeforceupdate.common.platform.presentation.base.Pager;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.Deploy;
import br.com.accera.mobile.tradeforceupdate.domain.deploy.entity.ScheduleDeploy;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class ListScheduleFragmentPagerAdapter extends BaseFragmentPagerAdapter {

    @Inject
    public ListScheduleFragmentPagerAdapter( ListScheduleActivity activity ) {
        super( activity.getSupportFragmentManager() );
    }

    public void setDeploy( ScheduleDeploy deploySchedule ) {
        for ( Deploy deploy : deploySchedule.getDeploys() ) {
            add( createPager( deploy ) );
        }
    }

    private Pager createPager( Deploy deploy ) {
        return Pager.create(
                deploy.getDate(),
                ListScheduleInstanceFragment.create( deploy.getInstances() )
        );
    }
}
