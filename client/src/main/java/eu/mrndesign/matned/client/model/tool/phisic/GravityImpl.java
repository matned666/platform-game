package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;

public class GravityImpl implements Gravity {

    private final static double GRAVITY = 9.8;

    private static final double TERMINAL_VELOCITY = 300;

    private double verticalSpeed = 0;
    private boolean bounceAction;

    private final Game game;

    public GravityImpl(Game game) {
        this.game = game;
    }

    @Override
    public void calculate(Element element, double speed) {
        if (game.isOnBackgroundElement(element)) {
            return;
        }
        fall(speed, element.getBounds());
    }

    private void fall(double speed, Bounds2D bounds) {
//        TODO set gravity working with force and bounds vector ---> MAKE IT BETTER - MORE NATURAL
        this.verticalSpeed = this.verticalSpeed + (!bounceAction ? GRAVITY : -GRAVITY);
        if (this.verticalSpeed > TERMINAL_VELOCITY) {
            this.verticalSpeed = TERMINAL_VELOCITY;
        }
        double verticalForce = 0;
        double horizontalForce = bounds.getCenter().getX();
        if (bounds.getCenter().getY() + bounds.getHeight() >= PANEL_HEIGHT_INT) {
            verticalForce = PANEL_HEIGHT_INT - bounds.getHeight();
            verticalSpeed = GRAVITY;
            bounceAction = true;
        } else {
            verticalForce = bounds.getCenter().getY() + (!bounceAction ? this.verticalSpeed : -verticalSpeed);
            if (verticalForce + bounds.getHeight() >= PANEL_HEIGHT_INT) {
                verticalForce = PANEL_HEIGHT_INT - bounds.getHeight();
            }
            horizontalForce = getForceVector(speed, bounds);
            if (verticalSpeed <= 0 && bounceAction) bounceAction = false;
        }
        bounds.getCenter().

                setX(horizontalForce);
        bounds.getCenter().
                setY(verticalForce);
    }

    private double getForceVector(double speed, Bounds2D bounds) {
        Point2D p1 = new Point2D(bounds.getCenter()).move(bounds.getVector(), speed * 4);
        return p1.getX();
    }
}
