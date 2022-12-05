package eu.mrndesign.matned.client.view.screencontent.object;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.controller.TimeWrapper;
import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.view.screencontent.object.image.ImageHolder;
import eu.mrndesign.matned.client.view.screencontent.object.image.ImageHolderImpl;

import java.util.logging.Logger;

import static eu.mrndesign.matned.client.controller.Constants.ANIMATION_FRAME_RATE;

public class GameObjView extends Image {
    private static final Logger logger = Logger.getLogger(GameObjView.class.getName());

    private final Element element;
    private final String id;
    private long frameNo = 0;
    private final ImageHolder imageHolder;

    public GameObjView(Element element) {
        this.element = element;
        this.id = element.getId();
        this.imageHolder = ImageHolderImpl.parse(element.getActions());
        setStyleName("gameObject");
        getElement().setDraggable("DRAGGABLE_FALSE");
    }

    public String getId() {
        return id;
    }

    private ImageElement animationRun(ActionType action) {
        int frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        if (frame >= imageHolder.getAnimation(action).size()*ANIMATION_FRAME_RATE) {
            frameNo = TimeWrapper.getInstance().getFrameNo();
            frame = (int) (TimeWrapper.getInstance().getFrameNo() - frameNo) - 1;
        }
        return  imageHolder.getAnimation(action).get(frame/ANIMATION_FRAME_RATE);
    }

    public double getRotationValue() {
        return element.getAngle();
    }

    public double getCenterX() {
        return element.getBounds().getCenter().getX();
    }

    public double getCenterY() {
        return element.getBounds().getCenter().getY();
    }

    public ImageElement getImage() {
        return animationRun(ActionTypeHolder.getInstance().get(id));
    }

}
