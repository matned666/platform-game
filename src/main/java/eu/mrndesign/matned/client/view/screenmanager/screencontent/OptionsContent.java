package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;

public class OptionsContent extends Content {

    public OptionsContent() {
        super(ScreenManager.ScreenType.OPTIONS);
        initTitle();
        initDescription();
    }

    private void initTitle(){
        Label title = new Label();
        title.setText("OPTIONS SCREEN");
        title.getElement().setClassName("title");
        this.add(title);
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
}
