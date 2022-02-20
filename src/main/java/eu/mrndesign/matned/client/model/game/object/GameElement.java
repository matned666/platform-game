package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

public abstract class GameElement {

    private final Vector2D referenceVector = new Vector2D(0,-10);

    private final String id = "GameElement-" + System.currentTimeMillis();
    private GameElementType type;
    private double speed;
    private final Bounds2D bounds;
    private Vector2D vector;
    private final String name;
    private double actualAngle;

    public GameElement(String name, double speed, Vector2D vector, Bounds2D bounds) {
        this.name = name;
        this.speed = speed;
        this.vector = vector;
        this.bounds = bounds;
    }

    public GameElement(GameElement element) {
        this(element.name, element.speed, new Vector2D(element.vector), new Bounds2D(element.bounds));
    }

    public abstract String getUrl();

    public void moveTo(double x, double y){
        rotate(x,y);
        move();
    }

    public void rotate(double x, double y) {
        Vector2D newVector = new Vector2D(bounds.getCenter(), x, y);
        actualAngle = vector.angleTo(newVector);
        this.vector = newVector;
    }

    public void move() {
        bounds.getCenter().move(vector, speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getId() {
        return id;
    }

    public GameElementType getType() {
        return type;
    }

    public Bounds2D getBounds() {
        return bounds;
    }

    public Vector2D getVector() {
        return vector;
    }

    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

    public String getName() {
        return name;
    }

    public abstract void refresh(int x, int y);

    public abstract void action(int x, int y);

    public double getAngle() {
        return referenceVector.angleTo(vector);
    }
}
