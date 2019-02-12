package br.com.accera.mobile.tradeforceupdate.domain.deploy.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.appversion.entity.AppVersion;
import br.com.accera.mobile.tradeforceupdate.domain.instance.entity.Instance;

/**
 * @author MAYCON CARDOSO on 05/02/2019.
 */
public class Deploy {
    private String date;
    private int affectedUsers;
    private int totalClients;
    private List<Instance> instances;
    private AppVersion version;
    private boolean done;

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public int getAffectedUsers() {
        return affectedUsers;
    }

    public void setAffectedUsers( int affectedUsers ) {
        this.affectedUsers = affectedUsers;
    }

    public int getTotalClients() {
        return totalClients;
    }

    public void setTotalClients( int totalClients ) {
        this.totalClients = totalClients;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances( List<Instance> instances ) {
        this.instances = instances;
    }

    public AppVersion getVersion() {
        return version;
    }

    public void setVersion( AppVersion version ) {
        this.version = version;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone( boolean done ) {
        this.done = done;
    }

    public synchronized void addInstance( Instance instance ){
        if(instances == null){
            instances = new ArrayList<>();
        }

        instances.add( instance );
    }
}
