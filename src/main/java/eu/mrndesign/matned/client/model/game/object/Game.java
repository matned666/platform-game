package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;

import java.util.Map;
import java.util.TreeMap;

public class Game {

    protected final String id = "Game-" + System.currentTimeMillis();

    private final Map<String, DrawingArea> mapIdToDrawingArea = new TreeMap<>();
    private final Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
    }

    public void add(double width, double height) {
        DrawingArea drawingArea = new DrawingArea(width, height, this);
        mapIdToDrawingArea.put(drawingArea.id, drawingArea);
    }

    public void remove(String id) {
        mapIdToDrawingArea.remove(id);
    }

    public String getId() {
        return id;
    }

    public Map<String, DrawingArea> getMapIdToDrawingArea() {
        return mapIdToDrawingArea;
    }
}
