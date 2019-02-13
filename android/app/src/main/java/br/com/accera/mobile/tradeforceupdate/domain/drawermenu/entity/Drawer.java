package br.com.accera.mobile.tradeforceupdate.domain.drawermenu.entity;

import java.util.List;

/**
 * @author MAYCON CARDOSO on 24/01/2019.
 */
public class Drawer {
    private DrawerHeader header;
    private List<DrawerSection> sections;

    public List<DrawerSection> getSections() {
        return sections;
    }

    public void setSections( List<DrawerSection> sections ) {
        this.sections = sections;
    }

    public DrawerHeader getHeader() {
        return header;
    }

    public void setHeader( DrawerHeader header ) {
        this.header = header;
    }
}
