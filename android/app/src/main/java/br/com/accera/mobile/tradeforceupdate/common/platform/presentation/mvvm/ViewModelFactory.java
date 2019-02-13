package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.mvvm;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> mAllViewModelProviderCreator;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderCreator ) {
        this.mAllViewModelProviderCreator = viewModelProviderCreator;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // Get from provider
        Provider<? extends ViewModel> creator = mAllViewModelProviderCreator.get(modelClass);

        // Doesn't exist. So try get it from parent class.
        if (creator == null) {
            creator = tryGetFromParentClass( modelClass );
        }

        // Doesn't exist yet.
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }

        // Create an object from dagger provider class.
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T extends ViewModel> Provider<? extends ViewModel> tryGetFromParentClass( @NonNull Class<T> modelClass ) {
        for ( Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : mAllViewModelProviderCreator.entrySet()) {
            if (modelClass.isAssignableFrom(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
