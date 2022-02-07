package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;

public class GameContent extends Content {

    public GameContent() {
        super(ScreenManager.ScreenType.NEW_GAME);
        initTitle();
        initDescription();
    }

    private void initTitle(){
        Label title = new Label();
        title.setText("GAME SCREEN");
        title.getElement().setClassName("title");
        this.add(title);
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("<br>" +
                "<p>WE WILL PLAY OUR GAME HERE !!!!</p> <br>" +
                "<br>" +
                "<p></p> <br>" +
                "");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }
}
