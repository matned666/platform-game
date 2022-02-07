package eu.mrndesign.matned.client.view.core.ordersscreen;

import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;
import eu.mrndesign.matned.client.view.screenmanager.menu.BaseScreenWithMenu;
import eu.mrndesign.matned.client.view.screenmanager.screencontent.BaseContent;

public class OrdersScreen extends BaseScreenWithMenu implements OrdersScreenInterface{

    private BaseContent content;
    private boolean isActive;

    public OrdersScreen(ScreenManagerInterface screenManager) {
        super(screenManager);
        screenType = ScreenManager.ScreenType.ORDERS;
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
