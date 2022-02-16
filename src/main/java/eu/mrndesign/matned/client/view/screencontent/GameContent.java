package eu.mrndesign.matned.client.view.screencontent;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;
import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.game.object.DrawingArea;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.StarShip;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;
import eu.mrndesign.matned.client.view.ScreenManager;
import eu.mrndesign.matned.client.view.screencontent.drawer.GameObj;

public class GameContent extends Content implements IContent{


    private AbsolutePanel absolutePanel;
    private GameObj gameObj;
    private final Controller controller;

    public GameContent(Controller controller) {
        super(ScreenManager.ScreenType.NEW_GAME);
        this.controller = controller;
        init();
    }

    private void init(){

        setWidth("100%");
        setHeight("100%");
        Label lag = new Label("GAME");
        add(lag);
        absolutePanel = new AbsolutePanel();
        absolutePanel.getElement().setClassName("drawingArea");
        absolutePanel.setWidth("1000px");
        absolutePanel.setHeight("500px");
        add(absolutePanel);

        controller.addNewDrawingArea(1000, 500);

        DrawingArea drawingArea = controller.getActiveDrawingArea();

drawingArea.add(new StarShip("SuperShip", 5, new Vector2D(100,100), new Bounds2D(50,80,new Point2D(0,0))) {
});
        gameObj = new GameObj();
        absolutePanel.add(gameObj, 100,100);
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
