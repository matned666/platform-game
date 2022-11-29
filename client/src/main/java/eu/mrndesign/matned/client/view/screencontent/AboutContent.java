package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.view.ScreenManager;

public class AboutContent extends Content implements IContent {

    private static volatile AboutContent instance;

    public static AboutContent getInstance(){
        if (instance == null) {
            synchronized (AboutContent.class){
                if (instance == null) {
                    instance = new AboutContent();
                }
            }
        }
        return instance;
    }

    private AboutContent() {
        super(ScreenManager.ScreenType.ABOUT);
        initDescription();
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

    @Override
    public Widget getWidget() {
        return this;
    }
}
