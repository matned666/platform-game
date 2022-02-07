package eu.mrndesign.matned.client.view.screenmanager.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.view.screenmanager.ScreenManager;
import eu.mrndesign.matned.client.view.screenmanager.screencontent.Content;

public class AboutContent extends Content {

    public AboutContent() {
        super(ScreenManager.ScreenType.ABOUT);
        initTitle();
        initDescription();
    }

    private void initTitle(){
        Label title = new Label();
        title.setText("ABOUT SCREEN");
        title.getElement().setClassName("title");
        this.add(title);
    }

    private void initDescription(){
        HTML html = new HTML();
        html.setHTML("<br>" +
                "<p>Developer matned666</p> " +
                "<p>Sample archetype for menu based programs</p>" +
                "<p>VERSION: 0.01</p>" +
                "<br>" +
                "<p></p> <br>" +
                "<p>Developer address and contact</p> " +
                "<p>+48 666 666 666</p>" +
                "<p>info@info-mail.com</p>" +
                "<p>Wrocław</p> <br>" +
                "");
        html.getElement().setClassName("simple-centered-text");
        this.add(html);
    }
}
