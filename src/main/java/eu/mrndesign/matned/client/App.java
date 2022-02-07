package eu.mrndesign.matned.client;

import com.google.gwt.core.client.EntryPoint;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManagerInterface;


public class App implements EntryPoint
{

    @Override
    public void onModuleLoad() {
        ScreenManagerInterface sm = new ScreenManager();
        sm.start();
    }
}
