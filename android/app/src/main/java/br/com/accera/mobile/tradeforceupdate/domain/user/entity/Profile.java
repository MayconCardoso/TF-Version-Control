package br.com.accera.mobile.tradeforceupdate.domain.user.entity;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public enum Profile {
    UNKNOWN(0), ADM(1), OPERATION(1), TECHNOLOGY(3);

    private int profile;

    Profile( int profile ) {
        this.profile = profile;
    }

    public int getProfile() {
        return profile;
    }
}
