package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity;

/**
 * @author MAYCON CARDOSO on 23/01/2019.
 */
public class DrawerItem {
    private String title;
    private String icon;
    private int ordem;

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem( int ordem ) {
        this.ordem = ordem;
    }
}
