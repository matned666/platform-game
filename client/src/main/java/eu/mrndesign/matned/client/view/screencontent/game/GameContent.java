package eu.mrndesign.matned.client.view.screencontent.game;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.controller.Constants;
import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.view.ScreenManager;
import eu.mrndesign.matned.client.view.screencontent.Content;
import eu.mrndesign.matned.client.view.screencontent.IContent;

import java.util.logging.Logger;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class GameContent extends Content implements IContent {
    protected static final Logger logger = Logger.getLogger(GameContent.class.getName());


    private static volatile GameContent instance;
    private DrawingCanvas canvas;

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

    private final Controller controller;

    private GameContent(Controller controller) {
        super(ScreenManager.ScreenType.NEW_GAME);
        this.controller = controller;
        setWidth(Constants.FULL_PERCENTAGE);
        setHeight(Constants.FULL_PERCENTAGE);
        Label label = new Label("GAME");
        add(label);
        controller.addNewDrawingArea(PANEL_WIDTH_INT, PANEL_HEIGHT_INT);
    }

    public void initCanvas() {
        logger.info("starting to draw a canvas");
        canvas = new DrawingCanvas(controller);
        add(canvas);
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
