package eu.mrndesign.matned.client.model.game.object.element;

public enum MoveType {

    STAND(0),
    WALK(2),
    RUN(5),
    JUMP(10),
    SNEAK(1);

    private final int speed;

    MoveType(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}
