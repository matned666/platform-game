package eu.mrndesign.matned.client.view.screenmanager.menu;

import com.google.gwt.user.client.ui.Button;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;

public abstract class MenuButton extends Button {

    private ScreenManagerInterface screenManager;

    public abstract boolean isSelected(ScreenManager.ScreenType screenType);

    public MenuButton(ScreenManagerInterface screenManager) {
        this.screenManager = screenManager;
    }

    protected void initButton(ScreenManager.ScreenType screenType){
        this.getElement().setClassName("button not-selected");
        this.addClickHandler(x-> screenManager.initializeScreen(screenType));
    }

}
