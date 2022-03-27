package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.game.object.element.Blow;
import eu.mrndesign.matned.client.model.game.object.element.Bullet;
import eu.mrndesign.matned.client.model.game.object.element.Putin;
import eu.mrndesign.matned.client.model.game.object.element.StarShip;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Math2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

public class GameElementsFactory {


    public static GameElement enemy(GameElement referenceElement, CanvasModel canvasModel, int hp, int hit) {
        return new Putin(Math2D.randomInt(1, 6), referenceElement, canvasModel, hp, hit);
    }

    public static GameElement hero(CanvasModel canvasModel) {
        return new StarShip(canvasModel);
    }


    public static GameElement bullet(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        Bounds2D bounds2D = new Bounds2D(vector, 20,30, new Point2D(bounds.getCenter()));
        return new Bullet(bounds2D, canvasModel);
    }

    public static GameElement blow(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        Vector2D v = new Vector2D(vector);
        Bounds2D bounds2D = new Bounds2D(v, 20,30, new Point2D(bounds.getCenter()));
        return new Blow(bounds2D, canvasModel);
    }



}
