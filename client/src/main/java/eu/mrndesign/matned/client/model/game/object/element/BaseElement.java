package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.frame.MoveType;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Math2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Gravity;
import eu.mrndesign.matned.client.model.tool.phisic.GravityImpl;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement implements Element {

    private final Vector2D referenceVector = new Vector2D(0, -1);

    protected final String id;

    protected final List<String> animationImages = new ArrayList<>();

    protected Bounds2D bounds;

    protected boolean toRemove;

    protected final Game game;
    protected final Gravity gravity;

    protected BaseElement(Game game, String type) {
        this.game = game;
        this.id = type + System.currentTimeMillis() + Math2D.randomInt(0, 10000);
        this.gravity = new GravityImpl(game, this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setDirection(int x, int y) {
        bounds.setVector(new Vector2D(bounds.getCenter(), new Point2D(x,y)));
    }

    @Override
    public Bounds2D getBounds() {
        return bounds;
    }

    @Override
    public boolean isToRemove() {
        return toRemove;
    }

    @Override
    public void setToRemove() {
        toRemove = true;
    }

    @Override
    public List<String> getFrames(MoveType moveType) {
        return animationImages;
    }

    @Override
    public double getAngle() {
        return referenceVector.angleTo(getBounds().getVector());
    }
}
