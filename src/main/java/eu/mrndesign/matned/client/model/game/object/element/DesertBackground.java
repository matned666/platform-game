package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.MoveType;

import java.util.Collections;
import java.util.List;

public class DesertBackground extends GameElement {


    public DesertBackground(CanvasModel canvasModel) {
        super(canvasModel, GameElementType.BACKGROUND);
    }

    @Override
    public List<String> frames() {
        return Collections.singletonList("img/desert-background.jpg");
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

    @Override
    public GameElementType getType() {
        return GameElementType.BACKGROUND;
    }

}
