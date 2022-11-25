package eu.mrndesign.matned.client.model.game.object;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import eu.mrndesign.matned.client.model.game.object.element.DesertBackground;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.game.object.element.MoveType;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.List;
import java.util.Map;

public class CanvasModel extends Bounds2D {

    private final Element background;
    private final Game game;

    public CanvasModel(double width, double height) {
        super(new Vector2D(0, 1), width, height, new Point2D(0, 0));
        this.game = new Game(this);
        background = new DesertBackground(this);
    }

    public Map<String, Element> getMapIdToGameElement() {
        return game.getMapIdToGameElement();
    }

    public void mouseDownEvent(int x, int y) {
        game.getMapIdToGameElement().values().forEach(gameElement -> gameElement.action(x, y));
    }

    public void mouseMoveEvent(int x, int y) {
        game.getMapIdToGameElement().values().forEach(gameElement -> gameElement.mouseMove(x, y));
    }

    public String getBackgroundImage() {
        return background.getFrames(MoveType.STAND).get(0);
    }

    public void canvasRefresh() {
        game.refresh();
    }

    public List<String> getRemovedGameElements() {
        return game.getRemovedGameElements();
    }

    public void onKeyPressed(NativeEvent nativeEvent) {
        switch (nativeEvent.getKeyCode()) {
            case KeyCodes.KEY_SPACE:
                game.fire();
                break;
            case KeyCodes.KEY_A:
                game.move(-1, nativeEvent.getShiftKey());
                break;
            case KeyCodes.KEY_D:
                game.move(1, nativeEvent.getShiftKey());
                break;
                case KeyCodes.KEY_W:
                    game.jump(nativeEvent.getShiftKey());
        }
    }

    public Game getGame() {
        return game;
    }

    public void clearRemoved() {
        game.clearRemoved();
    }

}
