package br.com.accera.mobile.tradeforceupdate.presentation.user.permissions;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemListUserBinding;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemPermissionBinding;
import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */
public class PermissionAdapter extends RecyclerView.Adapter<PermissionAdapter.ViewHolder> {
    private List<Permission> mItens;
    private LayoutInflater mLayoutInflater;
    private Event mEvent;

    @Inject
    public PermissionAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemPermissionBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_permission, parent, false );
        return new ViewHolder( binding );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        Permission item = mItens.get( position );
        holder.binding.setItem( item );
        holder.binding.permissionCheck.setOnClickListener(v -> item.setActive(holder.binding.permissionCheck.isChecked()));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItens == null ? 0 : mItens.size();
    }

    public void setItens( List<Permission> permissions ) {

        if( mItens == null ) {
            mItens = permissions;
            notifyItemRangeInserted( 0, permissions.size() );
            return;
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff( new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mItens.size();
            }

            @Override
            public int getNewListSize() {
                return permissions.size();
            }

            @Override
            public boolean areItemsTheSame( int oldItemPosition, int newItemPosition ) {
                Permission old = mItens.get( oldItemPosition );
                Permission newValue = permissions.get( newItemPosition );
                return old.getAction().equals( newValue.getAction() );
            }

            @Override
            public boolean areContentsTheSame( int oldItemPosition, int newItemPosition ) {
                Permission old = mItens.get( oldItemPosition );
                Permission newValue = permissions.get( newItemPosition );
                return old.getAction().equals( newValue.getAction() )
                        && old.getDescription().equals( newValue.getDescription() )
                        && old.getTitle().equals(newValue.getTitle());
            }
        } );
        mItens = permissions;
        diffResult.dispatchUpdatesTo( this );
    }

    public void setEvent( Event event ) {
        mEvent = event;
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
        private final ItemPermissionBinding binding;

        public ViewHolder( final ItemPermissionBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }

    public interface Event {
        void setUserAccess(User item);
        void setUserPermission(User item);
    }
}
