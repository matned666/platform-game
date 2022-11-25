package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;

import java.util.Collections;
import java.util.List;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class BreakBear extends Element {

    private static final double HEIGHT = 300;
    private static final double WIDTH = 400;

    public BreakBear(CanvasModel canvasModel) {
        super(canvasModel, ElementType.PICTURE, null);
        bounds.getCenter().setX(PANEL_WIDTH_INT/2);
        bounds.getCenter().setY(PANEL_HEIGHT_INT-HEIGHT/2);
        bounds.getVector().setX(0);
        bounds.getVector().setY(-1);
        bounds.setWidth(WIDTH);
        bounds.setHeight(HEIGHT);
    }

    @Override
    public List<String> getFrames(MoveType moveType) {
        return Collections.singletonList("img/break-bear.png");
    }

    @Override
    public boolean isRotateImageToVector() {
        return false;
    }

    @Override
    public boolean isAnimation() {
        return false;
    }

}
