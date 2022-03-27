package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.Collections;
import java.util.List;

public class Bullet extends GameElement {

    public Bullet(Bounds2D bounds, CanvasModel canvasModel) {
        super("Bullet", 10, bounds, null, canvasModel, 10, 1);
    }

    @Override
    public List<String> frames() {
        return Collections.singletonList("img/bullet1.png");
    }

    @Override
    public void refresh() {
        move();
    }

    @Override
    public void mouseMove(int x, int y) {

    }

    @Override
    public void action(int x, int y) {

    }

    @Override
    public GameElementType getType() {
        return GameElementType.BULLET;
    }

    @Override
    public boolean isToRemove() {
        return bounds.isOutOfView() || toRemove;
    }



}
