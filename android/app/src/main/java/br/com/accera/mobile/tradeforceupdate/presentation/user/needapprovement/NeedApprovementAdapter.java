package br.com.accera.mobile.tradeforceupdate.presentation.user.needapprovement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemInstanceBinding;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemNeedApprovementBinding;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 02/02/2019.
 */
public class NeedApprovementAdapter extends RecyclerView.Adapter<NeedApprovementAdapter.ViewHolder> {
    private List<User> mItens;
    private LayoutInflater mLayoutInflater;
    private Event mEvent;

    @Inject
    public NeedApprovementAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemNeedApprovementBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_need_approvement, parent, false );
        return new ViewHolder( binding );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        User item = mItens.get( position );
        holder.binding.setItem( item );
        holder.binding.buttonApprovement.setOnClickListener( view -> mEvent.edit( item ) );
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
        private final ItemNeedApprovementBinding binding;

        public ViewHolder( final ItemNeedApprovementBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }

    public interface Event {
        void edit(User item);
    }
}
