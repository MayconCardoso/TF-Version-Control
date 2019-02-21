package br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerHeader;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerItem;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerSection;
import br.com.accera.mobile.tradeforceupdate.presentation.appversion.list.ListAppVersionActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.dashboard.DashboardActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.deploy.list.ListScheduleActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.instance.list.ListInstanceActivity;
import br.com.accera.mobile.tradeforceupdate.presentation.user.list.ListUserActivity;

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

        DrawerItem item = getDrawerItem(GoogleMaterial.Icon.gmd_dashboard, "Autorizar", 0, ListUserActivity.class.getName());


        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }

    private DrawerSection createOperationalSection() {
        DrawerSection section = new DrawerSection();
        section.setOrdem( 2 );
        section.setTitle( "Operação" );

        DrawerItem item = getDrawerItem(GoogleMaterial.Icon.gmd_dashboard,"Calendário", 2, ListScheduleActivity.class.getName());
        DrawerItem item2 = getDrawerItem(GoogleMaterial.Icon.gmd_dashboard,"Cliente", 1, ListInstanceActivity.class.getName());
        DrawerItem item3 = getDrawerItem(GoogleMaterial.Icon.gmd_dashboard,"Versão", 0, ListAppVersionActivity.class.getName());

        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        items.add( item2 );
        items.add( item3 );
        section.setItens( items );

        return section;
    }

    private DrawerSection createGeneralSection() {
        DrawerSection section = new DrawerSection();
        section.setOrdem( 0 );
        section.setTitle( "Geral" );

        DrawerItem item = getDrawerItem(GoogleMaterial.Icon.gmd_account_balance_wallet, "Inicio", 0, DashboardActivity.class.getName());


        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }

    private DrawerItem getDrawerItem(GoogleMaterial.Icon icon, String title, int ordem, String target) {
        DrawerItem item = new DrawerItem();
        item.setOrdem(ordem);
        item.setTitle(title);
        item.setIcon(icon.getName());
        item.setTarget(target);
        return item;
    }
}
