package eu.mrndesign.matned.client.view.screenmanager;

import eu.mrndesign.matned.client.view.screenmanager.screencontent.Content;

public interface ScreenInterface {

    void show();

    void hide();

    void setContent(Content content);

}
