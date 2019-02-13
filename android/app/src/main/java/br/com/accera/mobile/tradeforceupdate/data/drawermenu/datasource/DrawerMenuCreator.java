package br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerHeader;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerItem;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerSection;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;

/**
 * @author MAYCON CARDOSO on 29/01/2019.
 */
public class DrawerMenuCreator {

    @NonNull
    public Drawer createDrawer() {
        Drawer drawer = new Drawer();
        drawer.setHeader( creatHeader() );
        drawer.setSections( createSections() );
        return drawer;
    }

    private DrawerHeader creatHeader() {
        DrawerHeader header = new DrawerHeader();
        header.setAllowMultipleAccount( false );
        return header;
    }

    private List<DrawerSection> createSections() {
        List<DrawerSection> sections = new ArrayList<>();
        sections.add( createGeneralSection() );
        sections.add( createOperationalSection() );
        sections.add( createApplicationSection() );
        return sections;
    }

    private DrawerSection createApplicationSection() {
        DrawerSection section = new DrawerSection();
        section.setOrdem( 2 );
        section.setTitle( "Configurações" );

        DrawerItem item = new DrawerItem();
        item.setOrdem( 0 );
        item.setTitle( "Início" );
        item.setIcon( GoogleMaterial.Icon.gmd_dashboard.getName() );


        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }

    private DrawerSection createOperationalSection() {
        DrawerSection section = new DrawerSection();
        section.setOrdem( 2 );
        section.setTitle( "Operação" );

        DrawerItem item = new DrawerItem();
        item.setOrdem( 0 );
        item.setTitle( "Início" );
        item.setIcon( GoogleMaterial.Icon.gmd_dashboard.getName() );

        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }

    private DrawerSection createGeneralSection() {
        DrawerSection section = new DrawerSection();
        section.setOrdem( 0 );
        section.setTitle( "Geral" );

        DrawerItem item = new DrawerItem();
        item.setOrdem( 0 );
        item.setTitle( "Início" );
        item.setIcon( GoogleMaterial.Icon.gmd_account_balance_wallet.getName() );
        item.setTarget( DashboardActivity.class.getName() );



        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }
}
