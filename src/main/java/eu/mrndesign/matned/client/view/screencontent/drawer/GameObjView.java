package eu.mrndesign.matned.client.view.screencontent.drawer;

import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.model.game.object.GameElement;

public class GameObjView extends Image {

    private final GameElement gameElement;
    private final String id;

    public GameObjView(GameElement gameElement) {
        this.gameElement = gameElement;
        this.id = gameElement.getId();
        setUrl(gameElement.getUrl());
        setStyleName("gameObject");
        getElement().setDraggable("DRAGGABLE_FALSE");
    }

    public GameElement getGameElement() {
        return gameElement;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return gameElement.getUrl();
    }

    public double getULCornerX() {
        return gameElement.getBounds().leftBorder();
    }

    public double getULCornerY() {
        return gameElement.getBounds().topBorder();
    }

    public double getRotationValue() {
        return gameElement.getAngle();
    }

    public double getCenterX() {
        return gameElement.getBounds().getCenter().getX();
    }

    public double getCenterY() {
        return gameElement.getBounds().getCenter().getY();
    }
}
