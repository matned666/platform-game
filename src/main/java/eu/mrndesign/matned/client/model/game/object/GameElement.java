package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class GameElement {

    protected final Logger logger;

    protected final Vector2D referenceVector = new Vector2D(0, -10);

    protected String id;
    protected final CanvasModel canvasModel;
    protected final Bounds2D bounds;
    protected final String name;
    protected boolean toRemove = false;

    private double speed;
    protected Vector2D vector;
    protected GameElement referenceElement;

    public GameElement(String name, double speed, Vector2D vector, Bounds2D bounds, CanvasModel canvasModel) {
        this.name = name;
        this.speed = speed;
        this.vector = vector;
        this.bounds = bounds;
        this.canvasModel = canvasModel;
        logger = Logger.getLogger(name);
        id = generateId();
    }

    private String generateId(){
        return  name + System.currentTimeMillis();
    }

    public GameElement(String name, double speed, Vector2D vector, Bounds2D bounds, GameElement referenceElement, CanvasModel canvasModel) {
        this(name, speed, vector, bounds, canvasModel);
        this.referenceElement = referenceElement;
    }

    public GameElement(GameElement element) {
        this(element.name, element.speed, new Vector2D(element.vector), new Bounds2D(element.bounds), element.canvasModel);
    }

    public abstract String getUrl();

    public void moveTo(double x, double y) {
        rotate(x, y);
        move();
    }

    public void rotate(double x, double y) {
        this.vector = new Vector2D(bounds.getCenter(), x, y);
    }

    protected boolean isInBounds(GameElement gameElement) {
        return bounds.touchedBy(gameElement.bounds);
    }

    public void move() {
        bounds.getCenter().move(vector, speed);
    }

    public Vector2D getVector() {
        return vector;
    }

    public String getId() {
        return id;
    }

    public Bounds2D getBounds() {
        return bounds;
    }

    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

    public List<String> frames() {
        return Collections.emptyList();
    }

    public abstract void refresh();

    public abstract void mouseMove(int x, int y);

    public abstract void action(int x, int y);

    public double getAngle() {
        return referenceVector.angleTo(vector);
    }

    public abstract GameElementType getType();

    public abstract boolean isToRemove();

    public void setToRemove(){
        toRemove = true;
    }



}
