package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.FlowPanel;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;

public abstract class Content extends FlowPanel {

    protected ScreenManager.ScreenType screenType;

    public Content(ScreenManager.ScreenType screenType) {
        this.getElement().setClassName("content");
        this.screenType = screenType;
    }

    public ScreenManager.ScreenType getScreenType() {
        return screenType;
    }
}
