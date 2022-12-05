package eu.mrndesign.matned.client.view.screencontent.object.image;

import com.google.gwt.dom.client.ImageElement;
import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class ImageHolderImpl implements ImageHolder{
    private static final Logger logger = Logger.getLogger(ImageHolderImpl.class.getName());

    public static ImageHolder parse(List<ActionData> actions) {
        ImageHolderImpl imageHolder = new ImageHolderImpl();
        actions.forEach(action -> {
            imageHolder.mapKeyToAnimation.put(action.getActionType(), Animation.parse(action));
        });
        return imageHolder;
    }

    private final Map<ActionType, Animation> mapKeyToAnimation = new TreeMap<>();

    private ImageHolderImpl() {
    }

    @Override
    public List<ImageElement> getAnimation(ActionType actionKey) {
        Animation animation = mapKeyToAnimation.get(actionKey);
        return animation != null ? animation.getAnimation() : new ArrayList<>();
    }
}
