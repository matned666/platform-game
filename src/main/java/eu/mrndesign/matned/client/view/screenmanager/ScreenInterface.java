package eu.mrndesign.matned.client.view.screenmanager;

import eu.mrndesign.matned.client.view.screenmanager.screencontent.BaseContent;

public interface ScreenInterface {

    void show();
    void hide();
    ScreenManager.ScreenType getScreenType();
    boolean isActive();
    void setActive(boolean status);
    BaseContent content();

}
