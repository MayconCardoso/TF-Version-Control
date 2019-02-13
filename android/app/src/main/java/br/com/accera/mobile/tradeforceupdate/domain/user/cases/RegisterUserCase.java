package br.com.accera.mobile.tradeforceupdate.domain.user.cases;

import javax.inject.Inject;

import br.com.accera.mobile.tradeforceupdate.common.domain.usecase.rx.SingleUseCase;
import br.com.accera.mobile.tradeforceupdate.common.platform.util.StringUtil;
import br.com.accera.mobile.tradeforceupdate.domain.user.entity.User;
import br.com.accera.mobile.tradeforceupdate.domain.user.repository.UserRepository;
import io.reactivex.Single;

/**
 * @author MAYCON CARDOSO on 22/01/2019.
 */
public class RegisterUserCase extends SingleUseCase<RegisterUserCase.Request, User> {
    private UserRepository mUserRepository;

    @Inject
    public RegisterUserCase( UserRepository userRepository ) {
        mUserRepository = userRepository;
    }

    @Override
    public Single<User> run( Request value ) {
        return Single.defer( () -> {
            if( StringUtil.isEmpty( value.user.getFirstName() ) ) throw new IllegalArgumentException( "Name cannot be null" );
            if( StringUtil.isEmpty( value.user.getLastName() ) ) throw new IllegalArgumentException( "Last Name cannot be null" );
            if( StringUtil.isEmpty( value.user.getEmail() ) ) throw new IllegalArgumentException( "Email cannot be null" );
            if( StringUtil.isEmpty( value.password ) ) throw new IllegalArgumentException( "Password cannot be null" );

            return mUserRepository.tryRegisterUser( value.user, value.password );
        } );
    }

    public static class Request{
        User user;
        String password;

        public void setUser( User user ) {
            this.user = user;
        }

        public void setPassword( String password ) {
            this.password = password;
        }
    }
}
