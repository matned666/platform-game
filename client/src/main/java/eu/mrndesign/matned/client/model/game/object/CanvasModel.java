package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.view.screencontent.game.KeyMap;

import java.util.List;
import java.util.Map;

public class CanvasModel extends Bounds2D {

    private final Game game;

    public CanvasModel(double width, double height, Model model, Controller controller) {
        super(new Vector2D(0, 1), width, height, new Point2D(0, 0));
        this.game = new Game(this, model, controller);
    }

    public Map<String, Element> getMapIdToGameElement() {
        return game.getMapIdToElement();
    }

    public void mouseDownEvent(int x, int y) {
//        game.getMapIdToElement().values().forEach(gameElement -> gameElement.move(x, y));
    }

    public void mouseMoveEvent(int x, int y) {
        game.getHero().setDirection(x, y);
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

    public void onKeyPressed(KeyMap keyMap, boolean run, boolean sneak) {
        Vector2D v;
        double speed = 5;
        switch (keyMap) {
            case ACTION:
                game.action();
                break;
            case MOVE_LEFT:
                v = new Vector2D(-1, 0);
                if (run) {
                    speed *= 2;
                } else if (sneak) {
                    speed /= 2;
                }
                game.move(v, speed);
                break;
            case MOVE_RIGHT:
                v = new Vector2D(1, 0);
                if (run) {
                    speed *= 2;
                } else if (sneak) {
                    speed /= 2;
                }
                game.move(v, speed);
                break;
            case JUMP:
                game.move(1, speed * 3);
        }
    }

    public Game getGame() {
        return game;
    }

    public void clearRemoved() {
        game.clearRemoved();
    }

}
