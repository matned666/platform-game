package eu.mrndesign.matned.client.model.game.object;

import java.util.Arrays;

public enum ActionType {
    STAND,
    MOVE_LEFT,
    MOVE_RIGHT,
    RUN_LEFT,
    RUN_RIGHT,
    JUMP,
    SNEAK,
    DEATH,
    ATTACK;

    public boolean is(String name) {
        return name().equalsIgnoreCase(name);
    }

    public static ActionType getFrom(String name) {
        return Arrays.stream(values())
                .filter(actionType -> actionType.is(name))
                .findFirst()
                .orElseThrow(()-> new UnrecognizedActionTypeException(name));
    }
}
