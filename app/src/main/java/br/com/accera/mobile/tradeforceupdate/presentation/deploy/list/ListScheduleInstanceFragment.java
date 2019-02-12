package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import java.util.List;

import androidx.fragment.app.Fragment;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class ListScheduleInstanceFragment extends Fragment {
    private List<Instance> mInstances;

    public static ListScheduleInstanceFragment create( List<Instance> instances ) {
        ListScheduleInstanceFragment fragment = new ListScheduleInstanceFragment();
        fragment.mInstances = instances;
        return fragment;
    }
}
