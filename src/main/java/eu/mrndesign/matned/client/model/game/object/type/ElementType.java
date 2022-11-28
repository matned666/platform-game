package eu.mrndesign.matned.client.model.game.object.type;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public enum ElementType implements Serializable, IsSerializable {
    HERO,
    NPC,
    BULLET,
    BACKGROUND,
    BLOW,
    PICTURE
}
