package eu.mrndesign.matned.client.model.game.object.background;

import eu.mrndesign.matned.client.model.tool.Bounds2D;

public interface SceneElement extends Scene {

    Bounds2D getBounds();

    boolean isIndestructible();

}
