package eu.mrndesign.matned.client.view.screenmanager.menu;

import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;

public class OrdersButton extends MenuButton {

    @Override
    public boolean isSelected(ScreenManager.ScreenType screenType) {
        return screenType == ScreenManager.ScreenType.ORDERS;
    }

    public OrdersButton(ScreenManagerInterface screenManager) {
        super(screenManager);
        this.setText("ORDERS");
        initButton(ScreenManager.ScreenType.ORDERS);
    }
}
