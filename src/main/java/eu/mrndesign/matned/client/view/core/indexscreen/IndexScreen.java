package eu.mrndesign.matned.client.view.core.indexscreen;

import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.menu.BaseScreenWithMenu;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;
import eu.mrndesign.matned.client.view.screenmanager.screencontent.BaseContent;

public class IndexScreen extends BaseScreenWithMenu implements IndexScreenInterface{

    private BaseContent content;
    private boolean isActive;

    public IndexScreen(ScreenManagerInterface screenManager) {
        super(screenManager);
        screenType = ScreenManager.ScreenType.INDEX;
        isActive = false;
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
