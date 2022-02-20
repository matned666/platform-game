package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;

import java.util.*;

public class GameImpl implements GameModel {

    protected final String id = "Game-" + System.currentTimeMillis();

    private final Map<String, DrawingArea> mapIdToDrawingArea = new HashMap<>();
    private final Controller controller;
    private DrawingArea activeDrawingArea;

    public GameImpl(Controller controller) {
        this.controller = controller;
    }

    public void addNewDrawingArea(double width, double height) {
        DrawingArea drawingArea = new DrawingArea(width, height);
        mapIdToDrawingArea.put(drawingArea.id, drawingArea);
        activeDrawingArea = drawingArea;
    }

    @Override
    public DrawingArea getDrawingArea() {
        return activeDrawingArea;
    }

    @Override
    public List<GameElement> getNewValues(Set<String> keySet) {
        Map<String, GameElement> mapIdToGameElement = activeDrawingArea.getMapIdToGameElement();
        List<GameElement> newValues = new LinkedList<>();
        keySet.stream().filter(mapIdToGameElement::containsKey).forEach(key -> newValues.add(mapIdToGameElement.get(key)));
        return newValues;
    }

    @Override
    public List<String> getAllRemovedKeys(Set<String> keySet) {
        Map<String, GameElement> mapIdToGameElement = activeDrawingArea.getMapIdToGameElement();
        List<String> removedKeys = new LinkedList<>();
        keySet.stream().filter(mapIdToGameElement::containsKey).forEach(removedKeys::add);
        return removedKeys;
    }

    @Override
    public boolean gameObjectsStateIsActual(Set<String> keySet) {
        Map<String, GameElement> mapIdToGameElement = activeDrawingArea.getMapIdToGameElement();
        for (String key : keySet) {
            if (!mapIdToGameElement.containsKey(key)) {
                return false;
            }
            if (mapIdToGameElement.size() != keySet.size()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onCanvasMouseMove(int x, int y) {
        activeDrawingArea.mouseMoveEvent(x,y);
    }

    @Override
    public void onCanvasMouseDown(int x, int y) {
        activeDrawingArea.mouseDownEvent(x,y);
    }

    @Override
    public String getActiveBackgroundImage() {
        return activeDrawingArea.getBackgroundImage();
    }


}
