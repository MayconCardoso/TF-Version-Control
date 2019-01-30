package br.com.accera.mobile.tradeforceupdate.common.platform.presentation.navigation;

/**
 * @author MAYCON CARDOSO on 07/01/2019.
 */
public interface Navigator {
    void goToErrorScreen(String title, String message);
    void goToErrorScreen(String message);
    void onCleared();
}
