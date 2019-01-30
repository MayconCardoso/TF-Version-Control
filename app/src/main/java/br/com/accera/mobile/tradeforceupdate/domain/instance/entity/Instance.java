package br.com.accera.mobile.tradeforceupdate.domain.instance.entity;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class Instance {
    private AppVersion currentVersion;
    private String id;
    private String name;
    private String image;

    public AppVersion getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion( AppVersion currentVersion ) {
        this.currentVersion = currentVersion;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image = image;
    }
}
