package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;

public class GravityImpl implements Gravity {

    private static final double GRAVITY = 1;
    private static final double TERMINAL_VELOCITY = 300;

    private double verticalSpeed = 0;
    private boolean bounceAction;

    private final Game game;

    public GravityImpl(Game game, Element character) {
        this.game = game;
    }

    @Override
    public synchronized double calculate(Element element, double speed) {
//        bounceAction = verticalSpeed < 0;
        if (game.isOnBackgroundElement(element)) {
            verticalSpeed = 0;
            return 0;
        }
        return fall(speed, element.getBounds());
    }

    private double fall(double speed, Bounds2D bounds) {
        verticalSpeed = verticalSpeed + (bounceAction ? -GRAVITY : GRAVITY);
        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        Vector2D gravityVector = new Vector2D(0, 1).magnituded(verticalSpeed);
        bounds.getCenter().move(gravityVector);
        if (bounds.getCenter().getY() + bounds.getHeight() > PANEL_HEIGHT_INT) {
            bounds.getCenter().setY(PANEL_HEIGHT_INT - bounds.getHeight());
            speed = 0;
        }
        return speed;
    }

}
