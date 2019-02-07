package br.com.accera.mobile.tradeforceupdate.domain.instance.entity;

import java.io.Serializable;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public enum InstanceOwner implements Serializable {
    TECH("TECH"),
    OPERATION("OPERATION");

    String owner;

    InstanceOwner( String owner ) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
