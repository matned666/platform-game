package eu.mrndesign.matned.client.view.screencontent.drawer;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.controller.TimeWrapper;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.frame.MoveType;

import java.util.ArrayList;
import java.util.List;

import static eu.mrndesign.matned.client.controller.Constants.ANIMATION_FRAME_RATE;

public class GameObjView extends Image {

    private final Element character;
    private final String id;
    private long frameNo = 0;
    private final List<ImageElement> frames = new ArrayList<>();

    public GameObjView(Element element) {
        this.character = element;
        this.id = element.getId();
        setStyleName("gameObject");
        getElement().setDraggable("DRAGGABLE_FALSE");
        List<String> frames = element.getFrames(MoveType.STAND);
        setUrl(frames.get(0));
        frames.forEach(url -> this.frames.add(ImageElement.as(new Image(url).getElement())));
    }

    public String getId() {
        return id;
    }

    private ImageElement animationRun() {
        int frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        if (frame >= frames.size()*ANIMATION_FRAME_RATE) {
            frameNo = TimeWrapper.getInstance().getFrameNo();
            frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        }
        return  frames.get(frame/ANIMATION_FRAME_RATE);
    }

    public double getRotationValue() {
        return character.getAngle();
    }

    public double getCenterX() {
        return character.getBounds().getCenter().getX();
    }

    public double getCenterY() {
        return character.getBounds().getCenter().getY();
    }

    public ImageElement getImage() {
        if (character.getFrames(MoveType.STAND).size()>1) {
            return animationRun();
        } else {
            return frames.get(0);
        }
    }
}
