package eu.mrndesign.matned.client.view.screencontent.game;

import com.google.gwt.event.dom.client.KeyCodes;

import java.util.Arrays;

public enum KeyMap {

    NONE,
    ACTION(KeyCodes.KEY_SPACE, KeyCodes.KEY_Z),
    JUMP(KeyCodes.KEY_W, KeyCodes.KEY_UP),
    MOVE_LEFT(KeyCodes.KEY_A, KeyCodes.KEY_LEFT),
    MOVE_RIGHT(KeyCodes.KEY_D, KeyCodes.KEY_RIGHT);

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
