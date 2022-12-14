package eu.mrndesign.matned.client.model.game.object.element.background;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.SceneElementData;
import eu.mrndesign.matned.client.model.game.object.element.BaseElement;

import java.util.List;

public class SceneElementImpl extends BaseElement implements SceneElement {

    private final SceneElementData sceneElementData;

    public SceneElementImpl(Game game, SceneElementData sceneElementData) {
        super(game, "Scene", sceneElementData);
        this.sceneElementData = sceneElementData;
    }

    @Override
    public boolean isIndestructible() {
        return true;
    }

    @Override
    public List<ActionData> getActions() {
        return sceneElementData.getActions();
    }

    @Override
    public SceneElementData getSceneElementData() {
        return sceneElementData;
    }

}
