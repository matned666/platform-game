package eu.mrndesign.matned.client.controller;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameModel;
import eu.mrndesign.matned.client.model.game.object.GameImpl;
import eu.mrndesign.matned.client.model.game.object.GameElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerImpl implements Controller {

    Logger logger = Logger.getLogger("Controller:");

    private final GameModel game;

    public ControllerImpl() {
        this.game = new GameImpl(this);
    }


    @Override
    public void addNewDrawingArea(double width, double height) {
        game.addNewDrawingArea(width, height);
    }

    @Override
    public String getActiveBackGroundImage() {
        return game.getActiveBackgroundImage();
    }

    @Override
    public List<GameElement> getGameElement() {
        CanvasModel canvasModel = game.getDrawingArea();
        return new ArrayList<>(canvasModel.getMapIdToGameElement().values());
    }
    @Override
    public List<GameElement> getNewValues(Set<String> keySet) {
        return game.getNewValues(keySet);
    }

    @Override
    public List<String> getRemovedKeys(Set<String> keySet) {
        return game.getAllRemovedKeys(keySet);
    }

    @Override
    public boolean gameObjectsStateIsActual(Set<String> keySet) {
        return game.gameObjectsStateIsActual(keySet);
    }

    @Override
    public void onCanvasRefresh() {
        game.onCanvasRefresh();
    }

    @Override
    public void onCanvasMouseMove(int x, int y) {
        game.onCanvasMouseMove(x, y);
    }

    @Override
    public void onCanvasMouseDown(int x, int y) {
        game.onCanvasMouseDown(x, y);
    }

    @Override
    public void onKeyPressed(int keyCode) {
        game.onKeyPressed(keyCode);
    }
}
