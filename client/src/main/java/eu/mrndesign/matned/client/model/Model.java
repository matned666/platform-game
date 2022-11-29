package eu.mrndesign.matned.client.model;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.view.screencontent.game.KeyMap;

import java.util.List;
import java.util.Set;

public interface Model {

    void addNewDrawingArea(double width, double height);

    CanvasModel getDrawingArea();

    List<Element> getNewValues(Set<String> keySet);

    List<String> getAllRemovedKeys(Set<String> keySet);

    boolean gameObjectsStateIsActual(Set<String> keySet);

    void onCanvasMouseMove(int x, int y);

    void onCanvasMouseDown(int x, int y);

    String getActiveBackgroundImage();

    void onCanvasRefresh();

    void onKeyPressed(KeyMap keyCode, boolean mod1, boolean mod2);

}
