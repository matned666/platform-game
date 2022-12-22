package eu.mrndesign.matned.client.view.screencontent.game;

import com.google.gwt.event.dom.client.KeyCodes;
import eu.mrndesign.matned.client.model.game.object.element.character.CharacterImpl;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public enum KeyMap {

    NONE(KeyCodes.KEY_SHIFT, KeyCodes.KEY_CTRL),
    ACTION(),
    JUMP(KeyCodes.KEY_W, KeyCodes.KEY_UP),
    FLY(KeyCodes.KEY_SPACE),
    MOVE_LEFT(KeyCodes.KEY_A, KeyCodes.KEY_LEFT),
    MOVE_RIGHT(KeyCodes.KEY_D, KeyCodes.KEY_RIGHT);

    protected static final Logger logger = Logger.getLogger(KeyMap.class.getName());

    public static final List<KeyMap> moveMaps = Arrays.asList(MOVE_LEFT, MOVE_RIGHT);

    private final int[] keys;

    KeyMap(int ... keys) {
        this.keys = keys;
    }

//    TODO More possibilities to hold more keys and return more Maps...
    public static KeyMap getEvent(int ... keyCodes) {
        for (KeyMap map: KeyMap.values()) {
            if (Arrays.stream(map.keys).anyMatch(k->Arrays.stream(keyCodes).anyMatch(k2->k == k2))) {
                return map;
            }
        }
        return NONE;
    }
}
