package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.MoveType;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.Arrays;
import java.util.List;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class Putin extends GameElement {

    private final List<String> frames  = Arrays.asList(
            "img/stone1.png", "img/stone2.png", "img/stone3.png", "img/stone4.png",
            "img/stone5.png", "img/stone4.png", "img/stone3.png", "img/stone2.png");;
    private final GameElement referenceElement;

    public Putin(CanvasModel canvasModel, GameElement referenceElement) {
        super(canvasModel, GameElementType.ENEMY);
        this.referenceElement = referenceElement;
        Point2D startCenter = Point2D.randomPointOnEdge(30, PANEL_WIDTH_INT, PANEL_HEIGHT_INT);
        Vector2D startVector = new Vector2D(startCenter, Point2D.zero());
        bounds.setVector(startVector);
        bounds.setCenter(startCenter);
        bounds.setWidth(30);
        bounds.setHeight(80);
    }

    @Override
    public List<String> frames() {
        return frames;
    }

    @Override
    public void refresh() {
        if (!bounds.isIn(referenceElement.getBounds())) {
            Point2D referencedElementCenter = referenceElement.getBounds().getCenter();
            getBounds().setVector(new Vector2D(getBounds().getCenter(), referencedElementCenter));
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
    public void move(MoveType moveType) {

    }

    @Override
    public boolean isRotateImageToVector() {
        return true;
    }

    @Override
    public boolean isAnimation(){
        return true;
    }
}
