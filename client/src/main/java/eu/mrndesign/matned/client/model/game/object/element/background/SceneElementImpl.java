package eu.mrndesign.matned.client.model.game.object.element.background;

import eu.mrndesign.matned.client.model.game.object.element.BaseElement;
import eu.mrndesign.matned.client.model.game.object.data.model.SceneElementData;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

public class SceneElementImpl extends BaseElement implements SceneElement{

    private final SceneElementData sceneElementData;

    public SceneElementImpl(SceneElementData sceneElementData) {
        super("Scene");
        this.sceneElementData = sceneElementData;
        bounds = Bounds2D.generate(sceneElementData);
    }

    @Override
    public boolean isIndestructible() {
        return true;
    }

    @Override
    public void refresh() {
//        TODO
    }

    @Override
    public void move(Vector2D v, double initSpeed) {
//        TODO
    }

    @Override
    public SceneElementData getSceneElementData() {
        return sceneElementData;
    }
}
