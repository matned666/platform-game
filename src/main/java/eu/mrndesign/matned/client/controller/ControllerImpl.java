package eu.mrndesign.matned.client.controller;

import eu.mrndesign.matned.client.model.game.object.DrawingArea;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.GameElement;

public class ControllerImpl implements Controller{

    private Game game;
    private String activeDrawingAreaId;

    public ControllerImpl() {
        this.game = new Game(this);
    }

    private DrawingArea getActiveDrawingArea() {
        return game.getMapIdToDrawingArea().get(activeDrawingAreaId);
    }

    @Override
    public void move(String id, double x, double y) {
        GameElement gameElement = getActiveDrawingArea().getMapIdToGameElement().get(id);
        gameElement.moveTo(x, y);
    }

    @Override
    public void rotate(String id, double x, double y) {
        GameElement gameElement = getActiveDrawingArea().getMapIdToGameElement().get(id);
        gameElement.rotate(x, y);
    }

    @Override
    public String getActiveDrawingAreaId() {
        return activeDrawingAreaId;
    }

    @Override
    public void setActiveDrawingAreaId(String id) {
        this.activeDrawingAreaId = id;
    }

    @Override
    public void addNewDrawingArea(double width, double height) {
        game.add(width, height);
    }

    @Override
    public void removeDrawingArea(String id) {
        game.remove(id);
    }
}
