package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;

public class StartContent extends Content {

    public StartContent() {
        super(ScreenManager.ScreenType.START_SCREEN);
        initTitle();
        initDescription();
    }

    private void initTitle(){
        Label title = new Label();
        title.setText("START SCREEN");
        title.getElement().setClassName("title");
        this.add(title);
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("<br>" +
                "");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }
}
