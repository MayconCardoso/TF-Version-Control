package br.com.accera.mobile.tradeforceupdate.presentation.deploy.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemInstanceBinding;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemInstanceJustTitleBinding;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 02/02/2019.
 */
public class ListScheduleInstanceAdapter extends RecyclerView.Adapter<ListScheduleInstanceAdapter.ViewHolder> {
    private List<Instance> mItens;
    private LayoutInflater mLayoutInflater;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemInstanceJustTitleBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_instance_just_title, parent, false );
        return new ViewHolder( binding );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        Instance item = mItens.get( position );
        holder.binding.setItem( item );
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItens == null ? 0 : mItens.size();
    }

    public void setItens( List<Instance> instances ) {
        mItens = instances;
        notifyItemRangeInserted( 0, instances.size() );
    }

    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // INNER CLASS
    //==============================================================================================
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemInstanceJustTitleBinding binding;
        public ViewHolder( final ItemInstanceJustTitleBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }
}
