package eu.mrndesign.matned.client.view.screencontent.drawer.image;

import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Animation {
    private static final Logger logger = Logger.getLogger(Animation.class.getName());

    private final String key;
    private final List<ImageElement> animation = new ArrayList<>();

    private Animation(String key) {
        this.key = key;
    }

    public static Animation parse(ActionData action) {
        Animation animation = new Animation(action.getName());
        action.getImages().forEach(a ->{
            logger.info("img/"+a);
            animation.getAnimation().add(ImageElement.as(new Image("img/"+a).getElement()));
        });
        return animation;
    }

    public List<ImageElement> getAnimation() {
        return animation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animation)) return false;
        Animation that = (Animation) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "ActionImages{" +
                "key='" + key + '\'' +
                ", animation=" + animation +
                '}';
    }
}
