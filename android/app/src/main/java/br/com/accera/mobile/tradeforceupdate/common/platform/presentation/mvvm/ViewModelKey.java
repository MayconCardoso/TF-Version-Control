package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

/**
 * The multibinding dagger annotatio key to inject all view model instances inside the factory.
 */
@Documented
@MapKey
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelKey {
    /**
     * Value class.
     *
     * @return the class
     */
    Class<? extends ViewModel> value();

}