package eu.mrndesign.matned.client.view.screenmanager;

public interface ScreenManagerInterface {

    void start();
    void initializeScreen(ScreenManager.ScreenType screenType);
    ScreenManager.ScreenType screenType();
}
