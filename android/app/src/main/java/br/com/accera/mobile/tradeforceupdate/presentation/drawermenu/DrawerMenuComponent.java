package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import android.content.Intent;
import android.view.Gravity;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.RxCaseExecutor;
import br.com.accera.mobile.tradeforceupdate.domain.auth.cases.GetLoggedUserCase;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerItem;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerSection;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuComponent implements LifecycleObserver {
    private AppCompatActivity mActivity;
    private DrawerMenuViewModel mDrawerMenuViewModel;
    private GetLoggedUserCase mGetLoggedUserCase;
    private com.mikepenz.materialdrawer.Drawer mNavigationDrawer;
    private ProfileDrawerItem mProfileItem;
    private AccountHeader mAccountHeader;

    @Inject
    public DrawerMenuComponent(AppCompatActivity activity, DrawerMenuViewModel drawerMenuViewModel, GetLoggedUserCase getLoggedUserCase) {
        mActivity = activity;
        mDrawerMenuViewModel = drawerMenuViewModel;
        mGetLoggedUserCase = getLoggedUserCase;
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_CREATE )
    public void setUp() {
        createProfile();
        createHeader();
        createDrawer();
        mDrawerMenuViewModel.getObservable().mDrawerLoaded.observe( mActivity, drawer -> {
            removeAllItens();
            populeItens( drawer.getSections() );
        } );
    }

    public boolean isDrawerOpen(){
        return mNavigationDrawer.isDrawerOpen();
    }

    public void closeDrawer(){
        mNavigationDrawer.closeDrawer();
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_START )
    public void observerDrawerMenu() {
        mDrawerMenuViewModel.loadItems();
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_STOP )
    public void cancelDrawerMenu() {
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // METHODS
    //==============================================================================================
    private void createDrawer() {
        mNavigationDrawer = new DrawerBuilder()
                .withActivity( mActivity )
                .withToolbar( mActivity.findViewById( R.id.toolbar ) )
                .withTranslucentNavigationBar( true )
                .withTranslucentStatusBar( true )
                .withActionBarDrawerToggle(true)
                .withAccountHeader( mAccountHeader )
                .withActionBarDrawerToggleAnimated( true )
                .withDrawerGravity( Gravity.START )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> navigateTo(drawerItem))
                .build();
    }

    private boolean navigateTo(IDrawerItem drawerItem) {
        DrawerItem tag = (DrawerItem) drawerItem.getTag();

        if (isCurrentPage(tag)){
            closeDrawer();
            return true;
        }

        try {
            mActivity.startActivity(new Intent(mActivity, Class.forName(tag.getTarget())));
        } catch (ClassNotFoundException e) {

        }
        return false;
    }

    private void createProfile() {
        RxCaseExecutor.execute(mGetLoggedUserCase).subscribe(new SingleObserver<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(User user) {
                setUpProfileItem(user);
                mAccountHeader.updateProfile(mProfileItem);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        User mLogged = new User();
        mLogged.setLastName( "Carregando..." );
        mLogged.setFirstName( "Carregando..." );
        mLogged.setEmail( "Carregando..." );
        setUpProfileItem(mLogged);
    }

    private void setUpProfileItem(User mLogged) {
        mProfileItem = new ProfileDrawerItem()
                .withTextColor( mActivity.getResources().getColor(android.R.color.white) )
                .withName( mLogged.getLastName().toUpperCase().concat( ", " ).concat( mLogged.getFirstName() ))
                .withEmail( mLogged.getEmail() )
                .withIdentifier( 1 );
        loadImage();
    }

    private void loadImage(  ) {
//        DrawerImageLoader.init( new AbstractDrawerImageLoader() {
//            @Override
//            public void set( ImageView imageView, Uri uri, Drawable placeholder, String tag) {
//                Glide.with(imageView.getContext())
//                        .load(uri)
//                        .placeholder( R.drawable.ic_no_user )
//                        .placeholder(placeholder)
//                        .diskCacheStrategy( DiskCacheStrategy.ALL )
//                        .into(imageView);
//            }
//
//            @Override
//            public void cancel(ImageView imageView) {
//                Glide.clear(imageView);
//            }
//
//            @Override
//            public Drawable placeholder( Context ctx, String tag) {
//                return DrawerUIUtils.getPlaceHolder(ctx);
//            }
//        });
    }

    private void createHeader( ) {
        mAccountHeader = new AccountHeaderBuilder()
                .withActivity( mActivity )
                .withCompactStyle( false )
                .withThreeSmallProfileImages( false )
                .withHeaderBackground( R.drawable.splash_gradient )
                .addProfiles( mProfileItem )
                .build();
    }

    private void removeAllItens() {
        if(mNavigationDrawer==null)return;
        mNavigationDrawer.removeAllItems();
    }

    private void populeItens( List<DrawerSection> sections ) {
        // Percorre os grupos
        for ( DrawerSection group : sections ) {

//            // Verifica a politica de criação
//            if(!mPolicy.isValid( group )){
//                continue;
//            }

            // Desenha o grupo
            mNavigationDrawer.addItem( new SectionDrawerItem().withName(group.getTitle()) );

            // Desenha os itens
            for ( DrawerItem item : group.getItens() ) {

//                // Verifica a politica de criação
//                if(!mPolicy.isItemValid( item )){
//                    continue;
//                }

                // Cria o item
                createItem( item );
            }
        }
    }

    private PrimaryDrawerItem createItem( final DrawerItem drawerItem ) {
        // Cria o item
        PrimaryDrawerItem item = new PrimaryDrawerItem()
                .withName( drawerItem.getTitle() )
                .withTag( drawerItem )
                .withIcon( GoogleMaterial.Icon.valueOf( drawerItem.getIcon() ) )
                .withSetSelected(isCurrentPage(drawerItem))
                .withSelectable( true );

        mNavigationDrawer.addItem( item );
        return item;
    }

    private boolean isCurrentPage(DrawerItem drawerItem) {
        return drawerItem.getTarget().equals(mActivity.getClass().getName());
    }

}
