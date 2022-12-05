package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.Boundable;
import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Math2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Gravity;
import eu.mrndesign.matned.client.model.tool.phisic.GravityImpl;
import eu.mrndesign.matned.client.view.screencontent.object.ActionTypeHolder;

public abstract class BaseElement implements Element {

    private final String id;
    private final Bounds2D bounds;

    protected final Game game;
    protected final Gravity gravity;
    private final Boundable boundable;

    private boolean toRemove;

    private Runnable actualAction = () -> {};

    protected BaseElement(Game game, String type, Boundable boundable) {
        this.game = game;
        this.id = type + System.currentTimeMillis() + Math2D.randomInt(0, 10000);
        this.gravity = new GravityImpl(game, this);
        this.boundable = boundable;
        this.bounds = Bounds2D.generate(boundable);
        ActionTypeHolder.getInstance().put(id, ActionType.STAND);
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
    public void setVisual(Vector2D vector, double initSpeed, ActionType actionType){
        ActionTypeHolder.getInstance().put(id, actionType);
    }

    @Override
    public void refresh() {
        actualAction.run();
        gravity.calculate(this, 10);
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
        return -getBounds().getVector().angleTo(0, -1);
    }

    @Override
    public void action(ActionType actionType, boolean shiftDown, boolean ctrlDown){
        ActionData action = boundable.getAction(actionType, shiftDown, ctrlDown);
        Vector2D vector = new Vector2D(action.getVectorX(), action.getVectorY());
        setVisual(vector, action.getForce(), actionType);
        switch (actionType) {
            case MOVE_LEFT:
            case MOVE_RIGHT:
                actualAction = () -> {
                    bounds.getCenter().move(vector, action.getForce());
                };
                break;
            case STAND:
                actualAction = () -> {};
                break;
        }
    }

}
