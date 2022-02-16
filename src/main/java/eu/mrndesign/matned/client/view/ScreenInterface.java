package eu.mrndesign.matned.client.view;

import eu.mrndesign.matned.client.view.screencontent.Content;
import eu.mrndesign.matned.client.view.screencontent.IContent;

public interface ScreenInterface {

    void show();

    void hide();

    void setContent(IContent content);

}
