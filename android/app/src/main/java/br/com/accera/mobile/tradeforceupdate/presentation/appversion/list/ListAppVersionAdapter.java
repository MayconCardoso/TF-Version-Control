package br.com.accera.mobile.tradeforceupdate.presentation.appversion.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.databinding.ItemAppVersionBinding;
import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 02/02/2019.
 */
public class ListAppVersionAdapter extends RecyclerView.Adapter<ListAppVersionAdapter.ViewHolder> {
    private List<AppVersion> mItens;
    private LayoutInflater mLayoutInflater;

    @Inject
    public ListAppVersionAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        if( mLayoutInflater == null ) {
            mLayoutInflater = LayoutInflater.from( parent.getContext() );
        }
        ItemAppVersionBinding binding = DataBindingUtil.inflate( mLayoutInflater, R.layout.item_app_version, parent, false );
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

    public void setVersions( List<AppVersion> versions ) {

        if( mItens == null ) {
            mItens = versions;
            notifyItemRangeInserted( 0, versions.size() );
            return;
        }

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff( new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mItens.size();
            }

            @Override
            public int getNewListSize() {
                return versions.size();
            }

            @Override
            public boolean areItemsTheSame( int oldItemPosition, int newItemPosition ) {
                AppVersion old = mItens.get( oldItemPosition );
                AppVersion newValue = versions.get( newItemPosition );
                return old.getVersionName().equals( newValue.getVersionName() );
            }

            @Override
            public boolean areContentsTheSame( int oldItemPosition, int newItemPosition ) {
                AppVersion old = mItens.get( oldItemPosition );
                AppVersion comment = versions.get( newItemPosition );
                return old.getVersionName().equals( comment.getVersionName() )
                        && old.getApkPath().equals( comment.getApkPath() )
                        && old.getVersionCode().equals( comment.getVersionCode() )
                        && old.getCreatedDate().equals( comment.getCreatedDate() );
            }
        } );
        mItens = versions;
        diffResult.dispatchUpdatesTo( this );
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemAppVersionBinding binding;

        public ViewHolder( final ItemAppVersionBinding itemBinding ) {
            super( itemBinding.getRoot() );
            this.binding = itemBinding;
        }
    }
}
