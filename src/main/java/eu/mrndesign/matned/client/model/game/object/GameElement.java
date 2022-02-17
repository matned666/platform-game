package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

public abstract class GameElement {

    protected final String id = "GameElement-" + System.currentTimeMillis();

    protected double speed;
    protected final Bounds2D bounds;
    protected final Vector2D vector;
    protected final String name;

    public GameElement(String name, double speed, Vector2D vector, Bounds2D bounds) {
        this.name = name;
        this.speed = speed;
        this.vector = vector;
        this.bounds = bounds;
    }

    public GameElement(GameElement element) {
        this(element.name, element.speed, new Vector2D(element.vector), new Bounds2D(element.bounds));
    }

    public void moveTo(double x, double y){
        rotate(x,y);
        move(speed);
    }

    public double rotate(double x, double y) {
        Vector2D v = new Vector2D(bounds.getCenter(), new Point2D(x,y));
        vector.normalize();
        v.normalize();
        double angleDegrees = vector.angleTo(v);
        vector.rotate(angleDegrees);
        return angleDegrees;
    }

    public void move(double dist) {
        bounds.getCenter().move(vector, dist);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
