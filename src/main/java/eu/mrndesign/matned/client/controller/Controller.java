package eu.mrndesign.matned.client.controller;

import eu.mrndesign.matned.client.model.game.object.GameElement;

import java.util.List;
import java.util.Set;

public interface Controller {

    void addNewDrawingArea(double width, double height);

    String getActiveBackGroundImage();

    List<GameElement> getGameElement();
    List<GameElement> getNewValues(Set<String> keySet);

    List<String> getRemovedKeys(Set<String> keySet);

    boolean gameObjectsStateIsActual(Set<String> keySet);

    void onCanvasRefresh();

    void onCanvasMouseMove(int x, int y);

    void onCanvasMouseDown(int x, int y);
}
