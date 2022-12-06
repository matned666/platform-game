package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.element.character.CharacterImpl;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.view.screencontent.game.KeyMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CanvasModel extends Bounds2D {
    protected static final Logger logger = Logger.getLogger(CharacterImpl.class.getName());

    private final Game game;

    public CanvasModel(double width, double height, Model model, Controller controller) {
        super(new Vector2D(0, 1), width, height, new Point2D(0, 0));
        this.game = new Game(this, controller);
    }

    public Map<String, Element> getMapIdToGameElement() {
        return game.getMapIdToElement();
    }

    public void mouseDownEvent(int x, int y) {
//        game.getMapIdToElement().values().forEach(gameElement -> gameElement.move(x, y));
    }

    public void mouseMoveEvent(int x, int y) {
        game.setDirection(x, y);
    }

    public String getBackgroundImage() {
        return game.getBackground();
    }

    public void canvasRefresh() {
        game.refresh();
    }

    public List<String> getRemovedGameElements() {
        return game.getRemovedGameElements();
    }

    public void onKeyPressed(KeyMap keyMap, boolean shiftDown, boolean ctrlDown) {
        switch (keyMap) {
            case ACTION:
                game.action(ActionType.ACTION, shiftDown, ctrlDown);
                break;
            case MOVE_LEFT:
                game.move(ActionType.MOVE_LEFT, shiftDown, ctrlDown);
                break;
            case MOVE_RIGHT:
                game.move(ActionType.MOVE_RIGHT, shiftDown, ctrlDown);
                break;
            case JUMP:
                game.action(ActionType.JUMP, shiftDown, ctrlDown);
                break;
            case FLY:
                game.action(ActionType.FLY, shiftDown, ctrlDown);
                break;
            default:
        }
    }

    public void onKeyReleased(KeyMap keyMap){
        if (KeyMap.moveMaps.contains(keyMap)) {
            game.move(ActionType.STAND, false, false);
        } else {
            game.action(null, false, false);

        }
    }

    public Game getGame() {
        return game;
    }

    public void clearRemoved() {
        game.clearRemoved();
    }

}
