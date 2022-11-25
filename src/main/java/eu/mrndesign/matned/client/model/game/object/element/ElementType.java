package eu.mrndesign.matned.client.model.game.object.element;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public enum ElementType implements Serializable, IsSerializable {
    HERO,
    ENEMY,
    BULLET,
    BACKGROUND,
    BLOW,
    PICTURE
}
