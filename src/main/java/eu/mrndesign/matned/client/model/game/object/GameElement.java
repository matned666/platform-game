package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Gravity;
import eu.mrndesign.matned.client.model.tools.MoveType;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.List;

/**
 * Any object that is visible on the stage is a GameElement
 */
public abstract class GameElement {
    protected final Vector2D referenceVector = new Vector2D(0, -1);

    protected final String id;
    protected final CanvasModel canvasModel;
    protected final Bounds2D bounds = new Bounds2D();
    protected final GameElementType gameElementType;
    protected boolean toRemove = false;
    protected final Gravity gravity;

    protected double actualSpeed = 0;

    public GameElement(CanvasModel canvasModel, GameElementType gameElementType) {
        this.canvasModel = canvasModel;
        this.gameElementType = gameElementType;
        this.gravity = canvasModel.getGame().getGravity();
        id = gameElementType.name() + System.currentTimeMillis();
    }

    /**
     * @return sorted List of images for element animation
     */
    public abstract List<String> frames();

    /**
     * on frame refresh
     */
    public abstract void refresh();

    /**
     * on mouse move
     * @param x horizontal
     * @param y vertical
     */
    public abstract void mouseMove(int x, int y);

    /**
     * on mouse action
     * @param x horizontal
     * @param y vertical
     */
    public abstract void action(int x, int y);

    /**
     * Move according to MoveType and bounds vector
     * @param moveType move style
     */
    public abstract void move(MoveType moveType);

    /**
     * If false - the image will should be flipped
     * @return is the image rotated up to the actual bounds vector
     */
    public abstract boolean isRotateImageToVector();

    /**
     * @return if the element has animation frames list
     */
    public abstract boolean isAnimation();

    public GameElementType getType() {
        return gameElementType;
    }

    /**
     * @return Element angle
     */
    public double getAngle() {
        return referenceVector.angleTo(bounds.getVector());
    }

    public String getId() {
        return id;
    }

    public Bounds2D getBounds() {
        return bounds;
    }

    /**
     * @return if the element has to be removed from maps
     */
    public boolean isToRemove() {
        return toRemove;
    }

    /**
     * Marks element as to remove from game maps on the next refresh frame
     */
    public void setToRemove(){
        toRemove = true;
    }

    /**
     * @return actual force
     */
    public double getActualSpeed() {
        return actualSpeed;
    }

    protected void moveTo(double x, double y) {
        rotate(x, y);
        bounds.getCenter().move(bounds.getVector(), actualSpeed);
    }

    protected void rotate(double x, double y) {
        bounds.rotate(x,y);
    }


}
