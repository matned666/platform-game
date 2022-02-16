package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public class OptionsContent extends Content implements IContent{

    public OptionsContent() {
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
