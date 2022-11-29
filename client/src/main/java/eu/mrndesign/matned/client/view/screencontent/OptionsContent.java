package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public class OptionsContent extends Content implements IContent{

    private static volatile OptionsContent instance;

    public static OptionsContent getInstance(){
        if (instance == null) {
            synchronized (OptionsContent.class){
                if (instance == null) {
                    instance = new OptionsContent();
                }
            }
        }
        return instance;
    }

    private OptionsContent() {
        super(ScreenManager.ScreenType.OPTIONS);
        initDescription();
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("" +
                "<p>VOICE OPTIONS</p>" +
                "<p>GRAPHIC OPTIONS</p>" +
                "<p>Change whatever you wish.</p>" +
                "<br>" +
                "<p>Enjoy.</p> <br>" +
                "");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }
    @Override
    public Widget getWidget() {
        return this;
    }

}
