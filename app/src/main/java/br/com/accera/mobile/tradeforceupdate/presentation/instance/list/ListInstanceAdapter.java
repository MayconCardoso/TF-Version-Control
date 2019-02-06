package br.com.accera.mobile.tradeforceupdate.presentation.instance.list;

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
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 02/02/2019.
 */
public class ListInstanceAdapter extends RecyclerView.Adapter<ListInstanceAdapter.ViewHolder> {
    private List<Instance> mItens;
    private LayoutInflater mLayoutInflater;

    @Inject
    public ListInstanceAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemInstanceBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_instance, parent, false );
        return new ViewHolder( binding );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        holder.binding.setItem( mItens.get( position ) );
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItens == null ? 0 : mItens.size();
    }

    public void setItens( List<Instance> instances ) {

        if( mItens == null ) {
            mItens = instances;
            notifyItemRangeInserted( 0, instances.size() );
            return;
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff( new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mItens.size();
            }

            @Override
            public int getNewListSize() {
                return instances.size();
            }

            @Override
            public boolean areItemsTheSame( int oldItemPosition, int newItemPosition ) {
                Instance old = mItens.get( oldItemPosition );
                Instance newValue = instances.get( newItemPosition );
                return old.getDbName().equals( newValue.getDbName() );
            }

            @Override
            public boolean areContentsTheSame( int oldItemPosition, int newItemPosition ) {
                Instance old = mItens.get( oldItemPosition );
                Instance newValue = instances.get( newItemPosition );
                return old.getDbName().equals( newValue.getDbName() )
                        && old.getName().equals( newValue.getName() )
                        && old.getTotalUsuarios() == newValue.getTotalUsuarios();
            }
        } );
        mItens = instances;
        diffResult.dispatchUpdatesTo( this );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemInstanceBinding binding;

        public ViewHolder( final ItemInstanceBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }
}
