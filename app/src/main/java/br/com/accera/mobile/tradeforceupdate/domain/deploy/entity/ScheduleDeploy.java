package br.com.accera.mobile.tradeforceupdate.domain.deploy.entity;

import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;

/**
 * @author MAYCON CARDOSO on 05/02/2019.
 */
public class ScheduleDeploy {
    private List<Deploy> deploys;
    private String createdDate;
    private boolean completed;

    public List<Deploy> getDeploys() {
        return deploys;
    }

    public void setDeploys( List<Deploy> deploys ) {
        this.deploys = deploys;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( String createdDate ) {
        this.createdDate = createdDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted( boolean completed ) {
        this.completed = completed;
    }
}
