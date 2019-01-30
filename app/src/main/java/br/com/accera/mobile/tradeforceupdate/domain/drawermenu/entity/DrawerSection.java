package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity;

import java.util.List;

/**
 * @author MAYCON CARDOSO on 23/01/2019.
 */
public class DrawerSection {
    private String title;
    private List<DrawerItem> itens;
    private int ordem;

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public List<DrawerItem> getItens() {
        return itens;
    }

    public void setItens( List<DrawerItem> itens ) {
        this.itens = itens;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem( int ordem ) {
        this.ordem = ordem;
    }
}
