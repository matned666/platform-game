package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.Boundable;
import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.element.character.CharacterImpl;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Math2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Gravity;
import eu.mrndesign.matned.client.model.tool.phisic.GravityImpl;
import eu.mrndesign.matned.client.view.screencontent.object.ActionTypeHolder;

import java.util.logging.Logger;

public abstract class BaseElement implements Element {
    protected static final Logger logger = Logger.getLogger(BaseElement.class.getName());

    private final String id;
    private final Bounds2D bounds;

    protected final Game game;
    protected final Gravity gravity;
    private final Boundable boundable;

    private boolean toRemove;

    private final Move move;

    protected BaseElement(Game game, String type, Boundable boundable) {
        this.game = game;
        this.id = type + System.currentTimeMillis() + Math2D.randomInt(0, 10000);
        this.gravity = new GravityImpl(game, this);
        this.boundable = boundable;
        this.bounds = Bounds2D.generate(boundable);
        this.move = new Move(this, gravity);
        ActionTypeHolder.getInstance().put(id, ActionType.STAND);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setDirection(int x, int y) {
        bounds.setVector(new Vector2D(bounds.getCenter(), new Point2D(x, y)));
    }

    @Override
    public void setVisual(Vector2D vector, double initSpeed, ActionType actionType) {
        ActionTypeHolder.getInstance().put(id, actionType);
    }

    @Override
    public void refresh() {
        move.run();
//        logger.info(move.toString());
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
        return -getBounds().getVector().angleTo(1, 0);
    }

    @Override
    public void action(ActionType actionType, boolean shiftDown, boolean ctrlDown) {
        if (actionType == null) {
            move.fly = false;
            move.gravitySpeed = 0;
            ActionTypeHolder.getInstance().put(id, move.actionType);
            return;
        }
        ActionData action = boundable.getAction(actionType, shiftDown, ctrlDown);
        switch (actionType){
            case JUMP:
                if (move.gravitySpeed != 0) return;
                move.gravitySpeed = action.getForce();
                ActionTypeHolder.getInstance().put(id, actionType);
                break;
            case FLY:

                break;
        }
    }

    @Override
    public void move(ActionType actionType, boolean shiftDown, boolean ctrlDown) {
        ActionData action = boundable.getAction(actionType, shiftDown, ctrlDown);
        Vector2D vector = new Vector2D(action.getVectorX(), action.getVectorY());
        setVisual(vector, action.getForce(), actionType);
        move.gravitySpeed = 0;
        move.fly = false;
        move.force = action.getForce() * (shiftDown? 3 : 1);
        move.actionType = actionType;
        if (action.getVectorX() == 0 && action.getVectorY() == 0) {
//            this check is must have before setting a direction Vector
//            otherwise operations on Vector2D(0,0) may throw NaN values
            return;
        }
        if (ctrlDown) {
            move.fly = true;
            move.gravitySpeed = action.getForce();
            ActionTypeHolder.getInstance().put(id, actionType);
        }
        move.vector.setY(action.getVectorY());
        move.vector.setX(action.getVectorX());
    }

    private static class Move {

        private final Vector2D vector = new Vector2D(1, 0);
        private double force;
        private double gravitySpeed = 0;
        private boolean fly;
        private ActionType actionType;

        private final Element element;
        private final Gravity gravity;

        private Move(Element element, Gravity gravity) {
            this.element = element;
            this.gravity = gravity;
        }

        private void run() {
            element.getBounds().getCenter().move(vector, force);
            gravity.calculate(element, gravitySpeed, fly);
        }

        @Override
        public String toString() {
            return "Move{" +
                    "vector=" + vector +
                    ", force=" + force +
                    ", gravitySpeed=" + gravitySpeed +
                    ", element=" + element +
                    ", gravity=" + gravity +
                    '}';
        }
    }

}
