package eu.mrndesign.matned.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gwt.dom.client.NativeEvent;
import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.ModelImpl;
import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.view.ScreenInterface;
import eu.mrndesign.matned.client.view.screencontent.game.DrawingCanvas;

public class ControllerImpl implements Controller {

    private final Model game;
    private final ScreenInterface screen;
    private DrawingCanvas drawingCanvas;

    public ControllerImpl(ScreenInterface screen) {
        this.game = new ModelImpl(this);
        this.screen = screen;
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
    public List<Element> getGameElement() {
        CanvasModel canvasModel = game.getDrawingArea();
        return new ArrayList<>(canvasModel.getMapIdToGameElement().values());
    }
    @Override
    public List<Element> getNewValues(Set<String> keySet) {
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
    public void onKeyPressed(NativeEvent nativeElement) {
        game.onKeyPressed(nativeElement);
    }

    @Override
    public void setDrawingCanvas(DrawingCanvas drawingCanvas) {
        this.drawingCanvas = drawingCanvas;
    }

    @Override
    public void pause(boolean pause) {
        drawingCanvas.breakAction(pause);
    }
}
