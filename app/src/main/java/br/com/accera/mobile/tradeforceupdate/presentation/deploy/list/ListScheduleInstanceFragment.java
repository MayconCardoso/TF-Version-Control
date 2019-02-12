package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.databinding.FragmentScheduleInstanceBinding;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 11/02/2019.
 */
public class ListScheduleInstanceFragment extends Fragment {
    private List<Instance> mInstances;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        FragmentScheduleInstanceBinding binding = FragmentScheduleInstanceBinding.inflate( inflater );

        ListScheduleInstanceAdapter mAdapter = new ListScheduleInstanceAdapter();
        mAdapter.setItens( mInstances );

        RecyclerView recycler = binding.appRecycler;
        recycler.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        recycler.setItemAnimator( new DefaultItemAnimator() );
        recycler.setAdapter( mAdapter );

        return binding.getRoot();
    }

    public static ListScheduleInstanceFragment create( List<Instance> instances ) {
        ListScheduleInstanceFragment fragment = new ListScheduleInstanceFragment();
        fragment.mInstances = instances;
        return fragment;
    }
}
