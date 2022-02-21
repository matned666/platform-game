package eu.mrndesign.matned.client.view.screencontent.drawer;

import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.controller.TimeWrapper;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.tools.Log;

import java.util.List;

public class GameObjView extends Image {

    public static final int ANIMATION_FRAME_RATE = 2;

    private final GameElement gameElement;
    private final String id;
    private long frameNo = 0;
    private final List<String> frames;

    public GameObjView(GameElement gameElement) {
        this.gameElement = gameElement;
        this.id = gameElement.getId();
        frames = gameElement.frames();
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
        if (gameElement.frames().isEmpty()) {
            return gameElement.getUrl();
        } else {
            return animationRun();
        }
    }

    private String animationRun() {
        int frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        if (frame >= frames.size()*ANIMATION_FRAME_RATE) {
            frameNo = TimeWrapper.getInstance().getFrameNo();
            frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        }
        return  frames.get(frame/ANIMATION_FRAME_RATE);
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
