package eu.mrndesign.matned.client.view.screencontent.drawer.image;

import com.google.gwt.dom.client.ImageElement;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.view.screencontent.drawer.GameObjView;

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
            imageHolder.mapKeyToAnimation.put(action.getName(), Animation.parse(action));
        });
        return imageHolder;
    }

    private final Map<String, Animation> mapKeyToAnimation = new TreeMap<>();

    private ImageHolderImpl() {
    }

    @Override
    public List<ImageElement> getAnimation(String actionKey) {
        Animation animation = mapKeyToAnimation.get(actionKey);
        return animation != null ? animation.getAnimation() : new ArrayList<>();
    }
}
