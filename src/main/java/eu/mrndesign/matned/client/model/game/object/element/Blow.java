package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.controller.TimeWrapper;
import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.Arrays;
import java.util.List;

import static eu.mrndesign.matned.client.view.screencontent.drawer.GameObjView.ANIMATION_FRAME_RATE;

public class Blow extends GameElement {

    private List<String> frames;

    public Blow(Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        super("Blow", 0, vector, bounds, null, canvasModel);
        frames = Arrays.asList("img/blow1.png", "img/blow2.png", "img/blow3.png", "img/blow4.png", "img/blow5.png", "img/blow6.png");
    }

    @Override
    public List<String> frames() {
        return frames;
    }

    @Override
    public void refresh() {
        move();
    }

    @Override
    public void mouseMove(int x, int y) {

    }

    @Override
    public void action(int x, int y) {

    }

    @Override
    public GameElementType getType() {
        return GameElementType.BLOW;
    }

    @Override
    public boolean isToRemove() {
        return (TimeWrapper.getInstance().getFrameNo() - startFrame)/ ANIMATION_FRAME_RATE> frames.size() || toRemove;
    }




}
