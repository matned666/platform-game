package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public class QuitContent extends Content implements IContent{

    private static QuitContent instance;

    public static QuitContent getInstance(){
        if (instance == null) {
            synchronized (QuitContent.class){
                if (instance == null) {
                    instance = new QuitContent();
                }
            }
        }
        return instance;
    }

    private QuitContent() {
        super(ScreenManager.ScreenType.QUIT);
        initDescription();
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("Return some day");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }

    @Override
    public Widget getWidget() {
        return this;
    }
}
