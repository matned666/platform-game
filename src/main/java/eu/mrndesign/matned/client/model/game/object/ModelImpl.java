package eu.mrndesign.matned.client.model.game.object;

import com.google.gwt.dom.client.NativeEvent;
import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.Model;

import java.util.*;

public class ModelImpl implements Model {

    private final Controller controller;
    private CanvasModel activeCanvasModel;

    public ModelImpl(Controller controller) {
        this.controller = controller;
    }

    public void addNewDrawingArea(double width, double height) {
        activeCanvasModel = new CanvasModel(width, height);
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
    public void onKeyPressed(NativeEvent nativeEvent) {
        activeCanvasModel.onKeyPressed(nativeEvent);
    }


}
