package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Game {

    protected final String id = "Game-" + System.currentTimeMillis();

    private final List<DrawingArea> drawingAreas = new LinkedList<>();
    private final Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
    }

    public void add(double width, double height) {
        DrawingArea drawingArea = new DrawingArea(width, height, this);
        drawingAreas.add(drawingArea);
    }

    public void remove(String id) {
        drawingAreas.remove(drawingAreas.stream().filter(da->da.id.equals(id)).findFirst().orElse(null));
    }

    public String getId() {
        return id;
    }

    public List<DrawingArea> getDrawingAreas() {
        return drawingAreas;
    }
}
