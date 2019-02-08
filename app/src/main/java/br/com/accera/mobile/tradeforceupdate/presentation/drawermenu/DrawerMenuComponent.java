package br.com.accera.mobile.tradeforceupdate.presentation.drawermenu;

import android.view.Gravity;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import br.com.accera.mobile.tradeforceupdate.R;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerItem;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerSection;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class DrawerMenuComponent implements LifecycleObserver {
    private AppCompatActivity mActivity;
    private DrawerMenuViewModel mDrawerMenuViewModel;
    private com.mikepenz.materialdrawer.Drawer mNavigationDrawer;
    private ProfileDrawerItem mProfileItem;
    private AccountHeader mAccountHeader;

    @Inject
    public DrawerMenuComponent( AppCompatActivity activity, DrawerMenuViewModel drawerMenuViewModel) {
        mActivity = activity;
        mDrawerMenuViewModel = drawerMenuViewModel;
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
                // .withSelectedItem( selecion )
                // .withOnDrawerItemClickListener( baseOnClickItem() )
                .build();
    }

    private void createProfile() {
        User mLogged = new User();
        mLogged.setLastName( "Cardoso" );
        mLogged.setFirstName( "Maycon" );
        mLogged.setEmail( "maycon.cardoso@accera.com.br" );
        mProfileItem = new ProfileDrawerItem()
                .withTextColor( android.R.color.white )
                .withName( mLogged.getLastName().toUpperCase().concat( ", " ).concat( mLogged.getFirstName() ))
                .withEmail( mLogged.getEmail() )
                .withIdentifier( mLogged.getEmail().hashCode() );
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

    private PrimaryDrawerItem createItem( DrawerItem drawerItem ) {

        // Id da String
//        VectorDrawableCompat icon = mIconsCacheUtils.getVectorByName( drawerItem.getIconName() );


        // Cria o item
        PrimaryDrawerItem item = new PrimaryDrawerItem()
                .withName( drawerItem.getTitle() )
                .withTag( drawerItem )
               // .withIcon( icon )
                //.withSetSelected( mNameSelecion.equals( drawerItem.getStringName() ) )
                .withSelectable( true );

        mNavigationDrawer.addItem( item );
        return item;
    }

}
