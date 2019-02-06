package br.com.accera.mobile.tradeforceupdate.domain.instance.entity;

/**
 * @author MAYCON CARDOSO on 03/02/2019.
 */
public enum InstanceOwner {
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
