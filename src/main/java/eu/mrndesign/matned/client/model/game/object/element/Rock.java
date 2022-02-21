package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.CanvasModel;
import eu.mrndesign.matned.client.model.game.object.GameElement;
import eu.mrndesign.matned.client.model.game.object.GameElementType;
import eu.mrndesign.matned.client.model.tools.Bounds2D;
import eu.mrndesign.matned.client.model.tools.Point2D;
import eu.mrndesign.matned.client.model.tools.Vector2D;

import java.util.logging.Level;

public class Rock extends GameElement {

    public Rock(String name, double speed, Vector2D vector, Bounds2D bounds, GameElement referenceElement, CanvasModel canvasModel) {
        super(name, 2, vector, bounds, referenceElement, canvasModel);
    }

    @Override
    public String getUrl() {
        return "img/stone1.png";
    }

    @Override
    public void refresh() {
        if (!isInBounds(referenceElement)) {
            Point2D referencedElementCenter = referenceElement.getBounds().getCenter();
            setVector(new Vector2D(getBounds().getCenter(), referencedElementCenter));
            moveTo(referencedElementCenter.getX(), referencedElementCenter.getY());
        }
    }

    @Override
    public void mouseMove(int x, int y) {

    }

    @Override
    public void action(int x, int y) {

    }

    @Override
    public GameElementType getType() {
        return GameElementType.ROCK;
    }

    @Override
    public boolean isToRemove() {
        return false;
    }
}
