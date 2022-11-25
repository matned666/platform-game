package eu.mrndesign.matned.client.model.tools;

public enum MoveType {

    WALK(2),
    RUN(5),
    JUMP(5),
    SNEAK(1);

    private final int speed;

    MoveType(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}
