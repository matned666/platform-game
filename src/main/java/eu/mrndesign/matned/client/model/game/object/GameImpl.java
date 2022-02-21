package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;

import java.util.*;

public class GameImpl implements GameModel {

    protected final String id = "Game-" + System.currentTimeMillis();

    private final Map<String, CanvasModel> mapIdToDrawingArea = new HashMap<>();
    private final Controller controller;
    private CanvasModel activeCanvasModel;

    public GameImpl(Controller controller) {
        this.controller = controller;
    }

    public void addNewDrawingArea(double width, double height) {
        CanvasModel canvasModel = new CanvasModel(width, height, this);
        mapIdToDrawingArea.put(canvasModel.id, canvasModel);
        activeCanvasModel = canvasModel;
    }

    @Override
    public CanvasModel getDrawingArea() {
        return activeCanvasModel;
    }

    @Override
    public List<GameElement> getNewValues(Set<String> keySet) {
        Map<String, GameElement> mapIdToGameElement = activeCanvasModel.getMapIdToGameElement();
        List<GameElement> newValues = new LinkedList<>();
        mapIdToGameElement.keySet().stream().filter(key -> !keySet.contains(key)).forEach(key -> newValues.add(mapIdToGameElement.get(key)));
        return newValues;
    }

    @Override
    public List<String> getAllRemovedKeys(Set<String> keySet) {
        return activeCanvasModel.getRemovedGameElements();
    }

    @Override
    public boolean gameObjectsStateIsActual(Set<String> keySet) {
        Map<String, GameElement> mapIdToGameElement = activeCanvasModel.getMapIdToGameElement();
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
        activeCanvasModel.mouseMoveEvent(x,y);
    }

    @Override
    public void onCanvasMouseDown(int x, int y) {
        activeCanvasModel.mouseDownEvent(x,y);
    }

    @Override
    public String getActiveBackgroundImage() {
        return activeCanvasModel.getBackgroundImage();
    }

    @Override
    public void onCanvasRefresh() {
        activeCanvasModel.canvasRefresh();
        activeCanvasModel.clearRemoved();
    }

    @Override
    public void onKeyPressed(int keyCode) {
        activeCanvasModel.onKeyPressed(keyCode);
    }


}
