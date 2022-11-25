package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.MoveType;

import java.util.Collections;
import java.util.List;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class BreakBear extends GameElement {

    private static final double HEIGHT = 300;
    private static final double WIDTH = 400;

    public BreakBear() {
        super(null, GameElementType.PICTURE);
        bounds.getCenter().setX(PANEL_WIDTH_INT/2);
        bounds.getCenter().setY(PANEL_HEIGHT_INT-HEIGHT/2);
        bounds.getVector().setX(0);
        bounds.getVector().setY(-1);
        bounds.setWidth(WIDTH);
        bounds.setHeight(HEIGHT);
    }

    @Override
    public List<String> frames() {
        return Collections.singletonList("img/break-bear.png");
    }

    @Override
    public void refresh() {

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
        return false;
    }

    @Override
    public boolean isAnimation() {
        return false;
    }

}
