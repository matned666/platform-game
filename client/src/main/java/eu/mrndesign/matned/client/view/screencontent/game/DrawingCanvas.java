package eu.mrndesign.matned.client.view.screencontent.game;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.controller.TimeWrapper;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.view.screencontent.object.GameObjView;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static eu.mrndesign.matned.client.controller.Constants.*;

public class DrawingCanvas extends AbsolutePanel {
    private static final Logger logger = Logger.getLogger("DrawingCanvas:");

    private final Canvas drawingCanvas;

    private final Context2d drawingCanvasContext;
    private final Controller controller;

    private final Map<String, GameObjView> mapIdToGameObjects = new HashMap<>();
    private final Label mousePosLabel;
    private final Label additionalLabel;

    private int actualX;
    private int actualY;

    private boolean dragging;

    private final Subject<Boolean> pauseSubject = PublishSubject.create();

    public DrawingCanvas(Controller controller) {
        this.controller = controller;
        controller.setDrawingCanvas(this);
        drawingCanvas = Canvas.createIfSupported();
        String activeBackGroundImage = controller.getActiveBackGroundImage();
        Image background = new Image(activeBackGroundImage);
        background.setHeight(PANEL_HEIGHT);
        background.setWidth(PANEL_WIDTH);
        add(background, 0, 0);
        getElement().setClassName("drawingArea");
        setWidth(PANEL_WIDTH);
        setHeight(PANEL_HEIGHT);
        drawingCanvasContext = drawingCanvas.getContext2d();
        drawingCanvas.setStyleName("gameObject");
        createDrawingCanvas();
        addGameObjects();
        mousePosLabel = new Label();
        Label mouseActionPosLabel = new Label();
        additionalLabel = new Label();
        mousePosLabel.setStyleName("infoLabel");
        mouseActionPosLabel.setStyleName("infoLabel");
        additionalLabel.setStyleName("infoLabel");
        add(mousePosLabel, PANEL_WIDTH_INT / 4, 0);
        add(mouseActionPosLabel, PANEL_WIDTH_INT * 2 / 4, 0);
        add(additionalLabel, PANEL_WIDTH_INT * 3 / 4, 0);
        initListeners();
        setTimer();
    }

    private void initListeners() {
        drawingCanvas.addMouseMoveHandler(event -> {
            controller.onCanvasMouseMove(event.getX(), event.getY());
            mousePosLabel.setText("mouseMove->x:" + event.getX() + ",y:" + event.getY());
            actualX = event.getX();
            actualY = event.getY();
        });
        drawingCanvas.addMouseDownHandler(e -> dragging=true);
        drawingCanvas.addMouseUpHandler(e -> dragging=false);
        drawingCanvas.addMouseOutHandler(e -> dragging=false);
        drawingCanvas.addMouseOverHandler(e -> dragging=false);
        drawingCanvas.addKeyDownHandler(this::onKeyDown);
        drawingCanvas.addKeyUpHandler(this::onKeyUp);
        pauseSubject.map(pause -> {
            boolean b = TimeWrapper.getInstance().startStop();
            breakAction(b);
            return b;
        }).subscribe();
    }
    
    private void onKeyDown(KeyDownEvent event) {
        switch (event.getNativeKeyCode()) {
            case KeyCodes.KEY_P:
                pauseSubject.onNext(true);
                break;
            default:
                controller.onKeyPressed(KeyMap.getEvent(event.getNativeKeyCode()), event.isShiftKeyDown(), event.isControlKeyDown());
                controller.onCanvasMouseMove(actualX, actualY);
        }
    }

    private void onKeyUp(KeyUpEvent event){
        switch (event.getNativeKeyCode()) {
            case KeyCodes.KEY_P:
                break;
            default:
                controller.onKeyReleased(KeyMap.getEvent(event.getNativeKeyCode()));
        }
    }

    public void breakAction(boolean pause) {
        if (pause) {

        }
    }

    private void addGameObjects() {
        List<Element> allValues = controller.getGameElement();
        manageGameObjectsMap(allValues, new ArrayList<>());
    }

    public void createDrawingCanvas() {
        drawingCanvas.setWidth(PANEL_WIDTH);
        drawingCanvas.setCoordinateSpaceWidth(PANEL_WIDTH_INT);
        drawingCanvas.setHeight(PANEL_HEIGHT);
        drawingCanvas.setCoordinateSpaceHeight(PANEL_HEIGHT_INT);
        CssColor color = CssColor.make("rgba(" + 255 + ", " + 255 + "," + 255 + ", " + 0 + ")");
        drawingCanvasContext.setFillStyle(color);
        add(drawingCanvas, 0, 0);
    }

    private void setTimer() {
        TimeWrapper timeWrapper = TimeWrapper.getInstance();
        timeWrapper.setTimer(new Timer() {
            @Override
            public void run() {
                refreshDrawingCanvas();
            }
        });
    }

    public void refreshDrawingCanvas() {
        List<String> removedKeys = controller.getRemovedKeys(mapIdToGameObjects.keySet());
        controller.onCanvasRefresh();
        if (dragging) {
            controller.onCanvasMouseDown(actualX, actualY);
        }
        additionalLabel.setText("timer->" + TimeWrapper.getInstance().getFrameNo());
        drawingCanvasContext.clearRect(0, 0, PANEL_WIDTH_INT, PANEL_HEIGHT_INT);
        if (controller.gameObjectsStateIsActual(mapIdToGameObjects.keySet())) {
            List<Element> newValues = controller.getNewValues(mapIdToGameObjects.keySet());
            manageGameObjectsMap(newValues, removedKeys);
        }
        addAllMappedToCanvas();
        TimeWrapper.getInstance().nextFrame();
    }

    private void addAllMappedToCanvas() {
        mapIdToGameObjects.values().forEach(this::drawImageElement);
    }

    private void drawImageElement(GameObjView value) {
        double actualAngle = Math.toRadians(value.getRotationValue());
        double rx = value.getCenterX();
        double ry = value.getCenterY();
        ImageElement img = value.getImage();
        drawingCanvasContext.translate(rx, ry);
        drawingCanvasContext.rotate(actualAngle);
        drawingCanvasContext.drawImage(img, (double)-img.getWidth() / 2, (double)-img.getHeight() / 2, img.getWidth(), img.getHeight());
        drawingCanvasContext.rotate(-actualAngle);
        drawingCanvasContext.translate(-rx, -ry);
    }

    private void manageGameObjectsMap(List<Element> newValues, List<String> removedKeys) {
        if (removedKeys.size() > 0) {
            removeGameObjects(removedKeys);
        }
        if (newValues.size() > 0) {
            addNewGameObjects(newValues);
        }
    }

    private void removeGameObjects(List<String> removedKeys) {
        if (removedKeys.size() > 0) {
            removedKeys.forEach(mapIdToGameObjects::remove);
        }
    }

    private void addNewGameObjects(List<Element> newValues) {
        newValues.forEach(gameElement -> {
            GameObjView obj = new GameObjView(gameElement);
            mapIdToGameObjects.put(obj.getId(), obj);
        });
    }


}
