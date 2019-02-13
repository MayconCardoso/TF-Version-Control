package br.com.accera.mobile.tradeforceupdate.domain.user.mapper;

import com.google.firebase.auth.FirebaseUser;

import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public class UserMapper {
    private UserMapper(){}

    public static User transformToUser( FirebaseUser firebaseUser ){
        if(firebaseUser == null) return null;

        User user = new User();
        return user;
    }
}
