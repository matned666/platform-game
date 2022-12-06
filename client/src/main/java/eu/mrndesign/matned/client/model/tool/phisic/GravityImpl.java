package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.element.background.SceneElementImpl;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;

public class GravityImpl implements Gravity {

    private static final double GRAVITY = 9;
    private static final double TERMINAL_VELOCITY = 30;
    private static final double TERMINAL_COUNTER_VELOCITY = -10;

    private double verticalSpeed = 0;

    private final Game game;

    public GravityImpl(Game game, Element character) {
        this.game = game;
    }

    @Override
    public synchronized boolean calculate(Element element, double speed, boolean fly) {
        if (game.isOnBackgroundElement(element) && !fly && speed == 0 || element instanceof SceneElementImpl) {
            verticalSpeed = 0;
            return false;
        }
        return fall(speed, element.getBounds(), fly);
    }

    private boolean fall(double speed, Bounds2D bounds, boolean fly) {
        if (verticalSpeed < 0 && speed == 0 && !fly) verticalSpeed /= 2;
        verticalSpeed = verticalSpeed + GRAVITY - (verticalSpeed == 0 || fly? speed : 0);
        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        if (verticalSpeed < TERMINAL_COUNTER_VELOCITY && fly) {
            verticalSpeed = TERMINAL_COUNTER_VELOCITY;
        }
        Vector2D gravityVector = new Vector2D(0, 1).magnituded(verticalSpeed);
        bounds.getCenter().move(gravityVector);
        if (bounds.getCenter().getY() + bounds.getHeight() > PANEL_HEIGHT_INT) {
            bounds.getCenter().setY(PANEL_HEIGHT_INT - bounds.getHeight());
            verticalSpeed = 0;
        }
        return verticalSpeed > 0;
    }

}
