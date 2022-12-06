package eu.mrndesign.matned.client.controller;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.view.screencontent.game.DrawingCanvas;
import eu.mrndesign.matned.client.view.screencontent.game.KeyMap;

import java.util.List;
import java.util.Set;

public interface Controller {

    void addNewDrawingArea(double width, double height);

    String getActiveBackGroundImage();

    List<Element> getGameElement();
    List<Element> getNewValues(Set<String> keySet);

    List<String> getRemovedKeys(Set<String> keySet);

    boolean gameObjectsStateIsActual(Set<String> keySet);

    void onCanvasRefresh();

    void onCanvasMouseMove(int x, int y);

    void onCanvasMouseDown(int x, int y);

    void onKeyPressed(KeyMap keyCode, boolean mod1, boolean mod2);

    void onKeyReleased(KeyMap event);

    void setDrawingCanvas(DrawingCanvas widgets);

    void pause(boolean pause);

    CanvasModel getCanvasModel();

}
