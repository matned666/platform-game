package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public interface IContent {

    Widget getWidget();

    ScreenManager.ScreenType getScreenType();
}
