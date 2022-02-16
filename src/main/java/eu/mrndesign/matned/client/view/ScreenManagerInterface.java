package eu.mrndesign.matned.client.view;

public interface ScreenManagerInterface {

    void start();

    void initializeScreen(ScreenManager.ScreenType screenType);

    void onMenuButtonClick(ScreenManager.ScreenType screenType);

}
