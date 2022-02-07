package eu.mrndesign.matned.client.view.core.aboutscreen;

import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.menu.BaseScreenWithMenu;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;
import eu.mrndesign.matned.client.view.screenmanager.screencontent.BaseContent;

public class AboutScreen extends BaseScreenWithMenu implements AboutScreenInterface{

    private BaseContent content;
    private boolean isActive;

    public AboutScreen(ScreenManagerInterface screenManager) {
        super(screenManager);
        screenType = ScreenManager.ScreenType.ABOUT;
        this.content = new Content();
        this.addWidget(content);
    }

    @Override
    public ScreenManager.ScreenType getScreenType() {
        return screenType;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean status) {
        isActive = status;
    }

    @Override
    public BaseContent content() {
        return content;
    }
}
