package eu.mrndesign.matned.client.view.screenmanager;

import eu.mrndesign.matned.client.view.core.aboutscreen.AboutScreen;
import eu.mrndesign.matned.client.view.core.aboutscreen.AboutScreenInterface;
import eu.mrndesign.matned.client.view.core.contactscreen.ContactScreen;
import eu.mrndesign.matned.client.view.core.contactscreen.ContactScreenInterface;
import eu.mrndesign.matned.client.view.core.indexscreen.IndexScreen;
import eu.mrndesign.matned.client.view.core.indexscreen.IndexScreenInterface;
import eu.mrndesign.matned.client.view.core.ordersscreen.OrdersScreen;

public class ScreenManager implements
        ScreenManagerInterface,
        AboutScreenInterface.ScreenListener,
        IndexScreenInterface.ScreenListener,
        ContactScreenInterface.ScreenListener

{

    private ScreenType screenType;
    private ScreenInterface screen;

    public ScreenManager() {
        screenType = ScreenType.INDEX;
    }

    //    on start game we have menu
    @Override
    public void start() {
        initializeScreen(ScreenType.INDEX);
    }

    //    initializes a screen according to a screen type
    @Override
    public void initializeScreen(ScreenType screenType) {
        if (screen != null) screen.hide();
        switch (screenType) {
            case ABOUT: {
                this.screenType = ScreenType.ABOUT;
                screen = new AboutScreen(this);
                break;
            }
            case CONTACT: {
                this.screenType = ScreenType.CONTACT;
                screen = new ContactScreen(this);
                break;
            }
            case ORDERS: {
                this.screenType = ScreenType.ORDERS;
                screen = new OrdersScreen(this);
                break;
            }
            default: {
                this.screenType = ScreenType.INDEX;
                screen = new IndexScreen(this);
            }
        }
        screen.show();
    }

    @Override
    public ScreenType screenType(){
        return screenType;
    }


    public enum ScreenType {
        INDEX, ABOUT, CONTACT, ORDERS
    }

}

