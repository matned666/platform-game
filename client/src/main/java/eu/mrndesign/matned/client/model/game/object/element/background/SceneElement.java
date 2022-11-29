package eu.mrndesign.matned.client.model.game.object.element.background;

import eu.mrndesign.matned.client.model.game.object.data.model.SceneElementData;
import eu.mrndesign.matned.client.model.game.object.element.Element;

public interface SceneElement extends Element {

    boolean isIndestructible();

    SceneElementData getSceneElementData();
}
