package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.logging.Level;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class GameElementsFactory {


    public static GameElement addNewEnemy(GameElement referenceElement) {
        Point2D point2D = new Point2D(50, 50);
        Bounds2D bounds = new Bounds2D(30, 30, point2D);
        Vector2D v = new Vector2D(point2D, new Point2D(PANEL_WIDTH_INT/2, PANEL_HEIGHT_INT/2));
        return new GameElement("Rock 1", 2, v, bounds, referenceElement) {
            @Override
            public String getUrl() {
                return "img/stone1.png";
            }

            @Override
            public void refresh() {
                if (!isInBounds(referenceElement)) {
                    Point2D referencedElementCenter = referenceElement.getBounds().getCenter();
                    setVector(new Vector2D(getBounds().getCenter(), referencedElementCenter));
                    moveTo(referencedElementCenter.getX(), referencedElementCenter.getY());
                } else {
                    logger.log(Level.SEVERE, "Shit, was hit!");
                }
            }

            @Override
            public void mouseMove(int x, int y) {

            }

            @Override
            public void action(int x, int y) {

            }
        };
    }

    public static GameElement addHero() {
        return new StarShip();
    }


}
