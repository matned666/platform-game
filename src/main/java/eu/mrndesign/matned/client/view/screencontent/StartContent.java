package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public class StartContent extends Content implements IContent{

    private static volatile StartContent instance;

    public static StartContent getInstance(){
        if (instance == null) {
            synchronized (StartContent.class){
                if (instance == null) {
                    instance = new StartContent();
                }
            }
        }
        return instance;
    }

    private StartContent() {
        super(ScreenManager.ScreenType.START_SCREEN);
        initDescription();
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("<br>" +
                "");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }

    @Override
    public Widget getWidget() {
        return this;
    }
}
