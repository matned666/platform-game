package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import eu.mrndesign.matned.client.view.ScreenManager;

public abstract class Content extends VerticalPanel {

    protected ScreenManager.ScreenType screenType;

    public Content(ScreenManager.ScreenType screenType) {
        this.getElement().setClassName("content");
        this.screenType = screenType;
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        setWidth("100%");
        setHeight("100%");
    }

    public ScreenManager.ScreenType getScreenType() {
        return screenType;
    }
}
