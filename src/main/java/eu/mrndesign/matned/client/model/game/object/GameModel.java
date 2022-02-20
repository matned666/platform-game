package eu.mrndesign.matned.client.model.game.object;

import java.util.List;
import java.util.Set;

public interface GameModel {

    void addNewDrawingArea(double width, double height);

    DrawingArea getDrawingArea();

    List<GameElement> getNewValues(Set<String> keySet);

    List<String> getAllRemovedKeys(Set<String> keySet);

    boolean gameObjectsStateIsActual(Set<String> keySet);

    void onCanvasMouseMove(int x, int y);

    void onCanvasMouseDown(int x, int y);

    String getActiveBackgroundImage();

    void onCanvasRefresh();
}
