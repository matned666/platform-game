package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;

public class QuitContent extends Content {

    public QuitContent() {
        super(ScreenManager.ScreenType.QUIT);
        initTitle();
        initDescription();
    }

    private void initTitle(){
        Label title = new Label();
        title.setText("QUIT SCREEN");
        title.getElement().setClassName("title");
        this.add(title);
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("Return some day");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }
}
