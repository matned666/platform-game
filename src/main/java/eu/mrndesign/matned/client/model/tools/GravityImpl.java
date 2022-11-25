package eu.mrndesign.matned.client.model.tools;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.GameElement;

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
    public void calculate(GameElement gameElement) {
        if (game.isOnBackgroundElement(gameElement)) {
            return;
        }
        fall(gameElement.getActualSpeed(), gameElement.getBounds());
    }

    private void fall(double force, Bounds2D bounds) {
//        TODO set gravity working with force and bounds vector
//        this.verticalSpeed = this.verticalSpeed + (!bounceAction ? GRAVITY : -GRAVITY);
//        if (this.verticalSpeed > TERMINAL_VELOCITY) {
//            this.verticalSpeed = TERMINAL_VELOCITY;
//        }
//        double verticalForce = 0;
//        double horizontalForce = bounds.center.x;
//        if (bounds.getCenter().getY() + bounds.height >= PANEL_HEIGHT_INT) {
//            verticalForce = PANEL_HEIGHT_INT - bounds.height;
//            verticalSpeed = GRAVITY;
//            bounceAction = true;
//        } else {
//            verticalForce = bounds.getCenter().getY() + (!bounceAction ? this.verticalSpeed : -verticalSpeed);
//            if (verticalForce + bounds.height >= PANEL_HEIGHT_INT) {
//                verticalForce = PANEL_HEIGHT_INT - bounds.height;
//            }
//            horizontalForce = getForceVector(force, bounds);
//            if (verticalSpeed <= 0 && bounceAction) bounceAction = false;
//        }
//        bounds.getCenter().
//
//                setX(horizontalForce);
//        bounds.getCenter().
//                setY(verticalForce);
    }

    private double getForceVector(double speed, Bounds2D bounds) {
        Point2D p1 = new Point2D(bounds.center).move(bounds.vector, speed * 4);
        return p1.x;
    }
}
