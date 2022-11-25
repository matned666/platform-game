package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;

import java.util.Collections;
import java.util.List;

public class DesertBackground extends Element {


    public DesertBackground(CanvasModel canvasModel) {
        super(canvasModel, ElementType.BACKGROUND, null);
    }

    @Override
    public List<String> getFrames(MoveType moveType) {
        return Collections.singletonList("img/desert-background.jpg");
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
    public ElementType getType() {
        return ElementType.BACKGROUND;
    }

}
