package eu.mrndesign.matned.client.controller;

import com.google.gwt.dom.client.NativeEvent;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.view.screencontent.game.DrawingCanvas;

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

    void onKeyPressed(NativeEvent keyCode);

    void setDrawingCanvas(DrawingCanvas widgets);

    void pause(boolean pause);
}
