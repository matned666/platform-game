package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;

import java.util.Map;
import java.util.TreeMap;

public class DrawingArea extends Bounds2D {

    protected final String id = "DrawingArea-" + System.currentTimeMillis();

    private final Game game;
    private final Map<String, GameElement> mapIdToGameElement = new TreeMap<>();

    public DrawingArea(double width, double height, Game game) {
        super(width, height, new Point2D(0,0));
        this.game = game;
    }

    public void add(GameElement gameElement) {
        mapIdToGameElement.put(gameElement.id, gameElement);
    }

    public void remove(String id) {
        mapIdToGameElement.remove(id);
    }

    public Map<String, GameElement> getMapIdToGameElement() {
        return mapIdToGameElement;
    }

    public Game getGame() {
        return game;
    }

    public String getId() {
        return id;
    }
}
