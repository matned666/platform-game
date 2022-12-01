package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.Boundable;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Math2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Gravity;
import eu.mrndesign.matned.client.model.tool.phisic.GravityImpl;

public abstract class BaseElement implements Element {

    private final String id;
    private final Bounds2D bounds;

    protected final Game game;
    protected final Gravity gravity;

    private boolean toRemove;

    protected BaseElement(Game game, String type, Boundable boundable) {
        this.game = game;
        this.id = type + System.currentTimeMillis() + Math2D.randomInt(0, 10000);
        this.gravity = new GravityImpl(game, this);
        this.bounds = Bounds2D.generate(boundable);
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
    public double getAngle() {
        return getBounds().getVector().angleTo(0, -1);
    }

}
