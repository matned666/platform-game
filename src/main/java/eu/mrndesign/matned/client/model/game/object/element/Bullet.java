package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

public class Bullet extends GameElement {

    public Bullet(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        super("Bullet", 10, vector, bounds, null, canvasModel);
    }

    @Override
    public String getUrl() {
        return "img/bullet1.png";
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
