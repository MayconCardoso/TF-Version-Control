package br.com.accera.mobile.tradeforceupdate.platform.auth;

import javax.inject.Singleton;

import br.com.accera.mobile.tradeforceupdate.domain.auth.session.AuthSession;
import dagger.Binds;
import dagger.Module;

/**
 * @author MAYCON CARDOSO on 13/01/2019.
 */
@Module
public abstract class AuthDataModule {
    @Binds
    @Singleton
    abstract AuthSession provideAuthSession( AuthSessionImpl provider );

}
