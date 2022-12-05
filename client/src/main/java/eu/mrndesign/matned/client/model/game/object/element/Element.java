package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;

import java.util.List;

public interface Element {

    /**
     * @return element's id
     */
    String getId();

    /**
     * on frame set refresh
     */
    void refresh();

    /**
     * sets Character {@link Bounds2D} vector direction
     * @param x horizontal
     * @param y vertical
     */
    void setDirection(int x, int y);

    /**
     * Moves Element in x,y direction by the given speed
     * @param vector movement direction
     */
    void setVisual(Vector2D vector, double initSpeed, ActionType actionType);

    /**
     * @return {@link Bounds2D} object of the Element
     */
    Bounds2D getBounds();

    /**
     * @return if the element has been marked as to removed
     */
    boolean isToRemove();

    /**
     * Marks element as to remove from game maps on the next refresh frame
     */
    void setToRemove();

    /**
     * @return Element angle to the reference Vector
     */
    double getAngle();

    /**
     * @return List of {@link ActionData} fot the Element
     */
    List<ActionData> getActions();

    /**
     *
     * @param actionType
     * @param shiftDown
     * @param ctrlDown
     */
    void action(ActionType actionType, boolean shiftDown, boolean ctrlDown);

}
