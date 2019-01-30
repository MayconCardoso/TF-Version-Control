package br.com.accera.mobile.tradeforceupdate.data.drawermenu.datasource;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.Drawer;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerHeader;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerItem;
import br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity.DrawerSection;

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
        item.setIcon( "ic_teste" );


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
        item.setIcon( "ic_teste" );

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
        item.setIcon( "ic_teste" );


        List<DrawerItem> items = new ArrayList<>();
        items.add( item );
        section.setItens( items );

        return section;
    }
}
