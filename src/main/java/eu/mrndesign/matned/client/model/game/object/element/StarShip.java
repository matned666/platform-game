package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.tools.FrameHolder;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class StarShip extends Element {

    private boolean launched;

    public StarShip(CanvasModel canvasModel) {
        super(canvasModel, ElementType.HERO, new FrameHolder.FrameHolderBuilder("img/starship.png", "img/starship-fly.png").build());
        Point2D startCenter = new Point2D(PANEL_WIDTH_INT / 2, PANEL_HEIGHT_INT / 2);
        Vector2D startVector = new Vector2D(0, 1);
        bounds.setVector(startVector);
        bounds.setCenter(startCenter);
        bounds.setWidth(50);
        bounds.setHeight(80);
    }

    @Override
    public void refresh() {

    }

    @Override
    public void mouseMove(int x, int y) {
        launched = false;
        rotate(x, y);
    }

    @Override
    public void action(int x, int y) {
        if (getBounds().getCenter().distanceFrom(x, y) > getBounds().getHeight() / 2) {
            launched = true;
            moveTo(x, y);
        }
    }

    @Override
    public void move(MoveType moveType) {

    }

    @Override
    public boolean isRotateImageToVector() {
        return false;
    }

    @Override
    public boolean isAnimation() {
        return true;
    }

    @Override
    public ElementType getType() {
        return ElementType.HERO;
    }

    @Override
    public boolean isToRemove() {
        return toRemove;
    }


}
