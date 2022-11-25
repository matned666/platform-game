package eu.mrndesign.matned.client.model.game.object;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public enum GameElementType  implements Serializable, IsSerializable {
    HERO,
    ENEMY,
    BULLET,
    BACKGROUND,
    BLOW,
    PICTURE
}
