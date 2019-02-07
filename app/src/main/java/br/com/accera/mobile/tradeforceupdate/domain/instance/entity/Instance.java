package br.com.accera.mobile.tradeforceupdate.domain.instance.entity;

import java.io.Serializable;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class Instance implements Serializable {
    private String name;
    private String dbName;
    private String mdm;
    private String image;
    private int totalUsuarios;
    private AppVersion currentVersion;
    private InstanceOwner owner;
    private int updateGroup;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName( String dbName ) {
        this.dbName = dbName;
    }

    public String getMdm() {
        return mdm;
    }

    public void setMdm( String mdm ) {
        this.mdm = mdm;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image = image;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios( int totalUsuarios ) {
        this.totalUsuarios = totalUsuarios;
    }

    public AppVersion getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion( AppVersion currentVersion ) {
        this.currentVersion = currentVersion;
    }

    public InstanceOwner getOwner() {
        return owner;
    }

    public void setOwner( InstanceOwner owner ) {
        this.owner = owner;
    }

    public int getUpdateGroup() {
        return updateGroup;
    }

    public void setUpdateGroup( int updateGroup ) {
        this.updateGroup = updateGroup;
    }
}
