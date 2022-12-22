package eu.mrndesign.matned.client.model.tool.phisic;

import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.element.background.SceneElementImpl;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

import java.util.logging.Logger;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;

public class PhysicsImpl implements Physics {
    protected static final Logger logger = Logger.getLogger(PhysicsImpl.class.getName());

    private static final double GRAVITY = 5;
    private static final double TERMINAL_VELOCITY = 80;
    private static final double TERMINAL_COUNTER_VELOCITY = -50;
    private final Element element;
    private final Point2D p = new Point2D(0, 0);

    private double verticalSpeed = 0;

    private final Game game;

    public PhysicsImpl(Game game, Element element) {
        this.game = game;
        this.element = element;
    }

    @Override
    public synchronized void calculate(Vector2D moveVector, double moveForce) {
        if (element instanceof SceneElementImpl) {
            return;
        }
        Element collider = game.collideBackgroundElement(element);
        if (collider == null) {
            p.copy(element.getBounds().getCenter());
        } else {
            verticalSpeed = 0;
        }
        Vector2D fallVector = getFallVector();
        logger.info(fallVector+" - fall - " + verticalSpeed);
        move(fallVector);
        Vector2D realMoveVector = moveVector.magnituded(moveForce);
        logger.info(realMoveVector+" - move");
        move(realMoveVector);
        doNotFallBelowScene();
    }

    @Override
    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    @Override
    public void setGravityMod(double value) {
        verticalSpeed = value;
    }

    private void move(Vector2D moveVector) {
        if (!Vector2D.ZERO.equals(moveVector)) {
            element.move(moveVector, moveVector.magnitude());
            Element collider = game.collideBackgroundElement(element);
            if (collider != null) {
                verticalSpeed = 0;
                rollBack(moveVector.newNormalized(), collider.getBounds());
            }
        }
    }

    private void doNotFallBelowScene() {
        Bounds2D bounds = element.getBounds();
        if (bounds.getCenter().getY() + bounds.getWidth() > PANEL_HEIGHT_INT) {
            bounds.getCenter().setY(PANEL_HEIGHT_INT - bounds.getWidth());
            verticalSpeed = 0;
        }
    }

    private void rollBack(Vector2D rollBackV, Bounds2D colliderBounds) {
        element.move(rollBackV, -1);
        if (element.getBounds().touchedBy(colliderBounds)) {
            rollBack(rollBackV, colliderBounds);
        }
    }

    private Vector2D getFallVector() {
        boolean jumpStop = verticalSpeed < 0;
        verticalSpeed = verticalSpeed + GRAVITY;
        if (jumpStop && verticalSpeed == 0) {
            verticalSpeed = 1;
        }
        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        if (verticalSpeed < TERMINAL_COUNTER_VELOCITY) {
            verticalSpeed = TERMINAL_COUNTER_VELOCITY;
        }
        return new Vector2D(0, 1).magnituded(verticalSpeed);
    }

}
