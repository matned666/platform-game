package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class Putin extends GameElement {

    private List<String> frames;

    public Putin(double speed, GameElement referenceElement, CanvasModel canvasModel, int hp, int hit) {
        super("Putin", speed, referenceElement, canvasModel, hp, hit);
        frames = Arrays.asList("img/stone1.png", "img/stone2.png", "img/stone3.png", "img/stone4.png", "img/stone5.png", "img/stone4.png", "img/stone3.png", "img/stone2.png");
        Point2D point2D = Point2D.randomPointOnEdge(30, PANEL_WIDTH_INT, PANEL_HEIGHT_INT);
        Vector2D v = new Vector2D(point2D, Point2D.zero());
        bounds = new Bounds2D(v, 30, 80, point2D);
    }

    @Override
    public List<String> frames() {
        return frames;
    }

    @Override
    public void refresh() {
        if (!isInBounds(referenceElement)) {
            Point2D referencedElementCenter = referenceElement.getBounds().getCenter();
            setVector(new Vector2D(getBounds().getCenter(), referencedElementCenter));
            moveTo(referencedElementCenter.getX(), referencedElementCenter.getY());
        }
    }

    @Override
    public void mouseMove(int x, int y) {

    }

    @Override
    public void action(int x, int y) {

    }

    @Override
    public GameElementType getType() {
        return GameElementType.ROCK;
    }

    @Override
    public boolean isToRemove() {
        return toRemove;
    }

    @Override
    public boolean isAnimation(){
        return true;
    }
}
