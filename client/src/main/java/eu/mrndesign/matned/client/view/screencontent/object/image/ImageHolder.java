package eu.mrndesign.matned.client.view.screencontent.object.image;

import com.google.gwt.dom.client.ImageElement;
import eu.mrndesign.matned.client.model.game.object.ActionType;

import java.util.List;

public interface ImageHolder {

    List<ImageElement> getAnimation(ActionType actionKey);

}
