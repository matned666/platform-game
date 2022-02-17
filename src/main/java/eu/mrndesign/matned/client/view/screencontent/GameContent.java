package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;
import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.game.object.DrawingArea;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.StarShip;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;
import eu.mrndesign.matned.client.view.ScreenManager;
import eu.mrndesign.matned.client.view.screencontent.drawer.GameObj;

public class GameContent extends Content implements IContent {


    private static volatile GameContent instance;

    public static GameContent getInstance(Controller controller) {
        if (instance == null) {
            synchronized (GameContent.class) {
                if (instance == null) {
                    instance = new GameContent(controller);
                }
            }
        }
        return instance;
    }

    private AbsolutePanel absolutePanel;
    private GameObj gameObj;
    private final Controller controller;

    private GameContent(Controller controller) {
        super(ScreenManager.ScreenType.NEW_GAME);
        this.controller = controller;
        init();
    }

    private void init() {

        setWidth("100%");
        setHeight("100%");
        Label lag = new Label("GAME");
        add(lag);
        absolutePanel = new AbsolutePanel();
        absolutePanel.getElement().setClassName("drawingArea");
        absolutePanel.setWidth("1000px");
        absolutePanel.setHeight("500px");

        controller.addNewDrawingArea(1000, 500);
//
        DrawingArea drawingArea = controller.getActiveDrawingArea();

        StarShip starShip = new StarShip("SuperShip", 5, new Vector2D(100, 100), new Bounds2D(50, 80, new Point2D(500, 250)));
        drawingArea.add(
                starShip);
        gameObj = new GameObj(starShip);
        absolutePanel.add(gameObj, 500, 250);

        Label hoverLabel = new Label();
        Label downLabel = new Label();

        MouseDownHandler cHandler = event -> {
            downLabel.setText(event.toDebugString() + "x:" + event.getX()+",y:" + event.getY());

        };
        MouseMoveHandler mdHandler = event -> {
            double degree = starShip.rotate(event.getX(), event.getY());
            gameObj.getElement().getStyle().setProperty("transform", "rotate("+ degree +"deg)");
            hoverLabel.setText(event.toDebugString() + "x:" + event.getX()+",y:" + event.getY() + ",deg:" + degree);
        };
        absolutePanel.addDomHandler(cHandler, MouseDownEvent.getType());
        absolutePanel.addDomHandler(mdHandler, MouseMoveEvent.getType());


        add(absolutePanel);
        add(hoverLabel);
        add(downLabel);
    }


    @Override
    public Widget getWidget() {
        return this;
    }

    @Override
    public ScreenManager.ScreenType getScreenType() {
        return screenType;
    }
}
