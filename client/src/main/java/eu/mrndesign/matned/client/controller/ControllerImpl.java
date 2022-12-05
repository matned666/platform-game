package eu.mrndesign.matned.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.ModelImpl;
import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.view.ScreenInterface;
import eu.mrndesign.matned.client.view.screencontent.game.DrawingCanvas;
import eu.mrndesign.matned.client.view.screencontent.game.KeyMap;

public class ControllerImpl implements Controller {

    private final Model model;
    private final ScreenInterface screen;
    private DrawingCanvas drawingCanvas;

    public ControllerImpl(ScreenInterface screen) {
        this.model = new ModelImpl(this);
        this.screen = screen;
    }


    @Override
    public void addNewDrawingArea(double width, double height) {
        model.addNewDrawingArea(width, height);
    }

    @Override
    public String getActiveBackGroundImage() {
        return model.getActiveBackgroundImage();
    }

    @Override
    public List<Element> getGameElement() {
        CanvasModel canvasModel = model.getDrawingArea();
        return new ArrayList<>(canvasModel.getMapIdToGameElement().values());
    }
    @Override
    public List<Element> getNewValues(Set<String> keySet) {
        return model.getNewValues(keySet);
    }

    @Override
    public List<String> getRemovedKeys(Set<String> keySet) {
        return model.getAllRemovedKeys(keySet);
    }

    @Override
    public boolean gameObjectsStateIsActual(Set<String> keySet) {
        return model.gameObjectsStateIsActual(keySet);
    }

    @Override
    public void onCanvasRefresh() {
        model.onCanvasRefresh();
    }

    @Override
    public void onCanvasMouseMove(int x, int y) {
        model.onCanvasMouseMove(x, y);
    }

    @Override
    public void onCanvasMouseDown(int x, int y) {
        model.onCanvasMouseDown(x, y);
    }

    @Override
    public void onKeyPressed(KeyMap key, boolean mod1, boolean mod2) {
        model.onKeyPressed(key, mod1, mod2);
    }

    @Override
    public void onKeyReleased() {
        model.onKeyReleased();
    }

    @Override
    public void setDrawingCanvas(DrawingCanvas drawingCanvas) {
        this.drawingCanvas = drawingCanvas;
    }

    @Override
    public void pause(boolean pause) {
        drawingCanvas.breakAction(pause);
    }

    @Override
    public CanvasModel getCanvasModel() {
        return model.getDrawingArea();
    }
}
