package br.com.accera.mobile.tradeforceupdate.domain.user.entity;

import java.io.Serializable;
import java.util.List;

import br.com.accera.mobile.tradeforceupdate.domain.permission.entity.Permission;

/**
 * @author MAYCON CARDOSO on 06/01/2019.
 */
public class User implements Serializable {
    private String lastName;
    private String firstName;
    private String email;
    private String photo;
    private boolean authorized;
    private Profile profile;
    private List<Permission> permissions;

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto( String photo ) {
        this.photo = photo;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized( boolean authorized ) {
        this.authorized = authorized;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile( Profile profile ) {
        this.profile = profile;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions( List<Permission> permissions ) {
        this.permissions = permissions;
    }
}
