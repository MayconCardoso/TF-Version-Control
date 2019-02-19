package br.com.accera.mobile.tradeforceupdate.presentation.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemListUserBinding;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * Created by Rafael Spitaliere on 19/02/19.
 */
public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ViewHolder> {
    private List<User> mItens;
    private LayoutInflater mLayoutInflater;
    private Event mEvent;

    @Inject
    public ListUserAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemListUserBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_list_user, parent, false );
        return new ViewHolder( binding );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        User item = mItens.get( position );
        holder.binding.setItem( item );
        holder.binding.buttonApprovement.setOnClickListener( view -> mEvent.setUserAccess( item ) );
        holder.binding.buttonPermission.setOnClickListener(view -> mEvent.setUserPermission(item));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItens == null ? 0 : mItens.size();
    }

    public void setItens( List<User> users ) {

        if( mItens == null ) {
            mItens = users;
            notifyItemRangeInserted( 0, users.size() );
            return;
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff( new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mItens.size();
            }

            @Override
            public int getNewListSize() {
                return users.size();
            }

            @Override
            public boolean areItemsTheSame( int oldItemPosition, int newItemPosition ) {
                User old = mItens.get( oldItemPosition );
                User newValue = users.get( newItemPosition );
                return old.getEmail().equals( newValue.getEmail() );
            }

            @Override
            public boolean areContentsTheSame( int oldItemPosition, int newItemPosition ) {
                User old = mItens.get( oldItemPosition );
                User newValue = users.get( newItemPosition );
                return old.getEmail().equals( newValue.getEmail() )
                        && old.getFirstName().equals( newValue.getFirstName() )
                        && old.getLastName() == newValue.getLastName();
            }
        } );
        mItens = users;
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
        private final ItemListUserBinding binding;

        public ViewHolder( final ItemListUserBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }

    public interface Event {
        void setUserAccess(User item);
        void setUserPermission (User item);
    }
}
