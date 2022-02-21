package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.game.object.element.Blow;
import eu.mrndesign.matned.client.model.game.object.element.Bullet;
import eu.mrndesign.matned.client.model.game.object.element.Rock;
import eu.mrndesign.matned.client.model.game.object.element.StarShip;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Math2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class GameElementsFactory {


    public static GameElement enemy(int count, GameElement referenceElement, CanvasModel canvasModel) {
        Point2D point2D = Point2D.randomPointOnEdge(30, PANEL_WIDTH_INT, PANEL_HEIGHT_INT);
        Bounds2D bounds = new Bounds2D(30, 30, point2D);
        Vector2D v = new Vector2D(point2D, Point2D.zero());
        return new Rock("Rock"+count, Math2D.randomInt(1, 6), v, bounds, referenceElement, canvasModel);
    }

    public static GameElement hero(CanvasModel canvasModel) {
        return new StarShip(canvasModel);
    }


    public static GameElement bullet(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        Bounds2D bounds2D = new Bounds2D(20,30, new Point2D(bounds.getCenter()));
        Vector2D v = new Vector2D(vector);
        return new Bullet(v, bounds2D, canvasModel);
    }

    public static GameElement blow(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        Bounds2D bounds2D = new Bounds2D(20,30, new Point2D(bounds.getCenter()));
        Vector2D v = new Vector2D(vector);
        return new Blow(v, bounds2D, canvasModel);
    }



}
