package eu.mrndesign.matned.client.model.game.object.element;

import eu.mrndesign.matned.client.model.game.object.ActionType;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.BoundsData;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Math2D;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Physics;
import eu.mrndesign.matned.client.model.tool.phisic.PhysicsImpl;
import eu.mrndesign.matned.client.view.screencontent.object.ActionTypeHolder;

import java.util.logging.Logger;

public abstract class BaseElement implements Element {
    protected static final Logger logger = Logger.getLogger(BaseElement.class.getName());

    private final String id;
    private final Bounds2D bounds;

    protected final Game game;
    protected final Physics physics;
    private final BoundsData boundsData;

    private boolean toRemove;

    private final Move move;

    private final String type;

    protected BaseElement(Game game, String type, BoundsData boundsData) {
        this.game = game;
        this.type = type;
        this.id = type + System.currentTimeMillis() + Math2D.randomInt(0, 10000);
        this.physics = new PhysicsImpl(game, this);
        this.boundsData = boundsData;
        this.bounds = Bounds2D.generateFrom(boundsData);
        this.move = new Move(this, physics);
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
    public void refresh() {
        move.run();
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
    public void move(Vector2D moveVector, double moveForce) {
        bounds.getCenter().move(moveVector, moveForce);
    }

    @Override
    public void action(ActionType actionType, boolean shiftDown, boolean ctrlDown) {
        if (actionType == null) {
            move.vector.setY(0);
            ActionTypeHolder.getInstance().put(id, move.getAction());
            return;
        }
        ActionData action = boundsData.getAction(actionType, shiftDown, ctrlDown);
        ActionTypeHolder.getInstance().put(id, actionType);
        switch (actionType){
            case STAND:
                move.force = 0;
                break;
            case JUMP:
                if (physics.getVerticalSpeed() != 0d) return;
                physics.setGravityMod(action.getForce());
                move.vector.setY(action.getVectorY());
                move.vector.setX(move.vector.getX()*2);
                break;
            case MOVE_LEFT:
            case MOVE_RIGHT:
                setMoveAction(action, shiftDown);
                break;


        }
    }

    private void setMoveAction(ActionData action, boolean shiftDown) {
        move.force = action.getForce() * (shiftDown? 3 : 1);
        if (action.getVectorX() == 0 && action.getVectorY() == 0) {
//            this check is must have before setting a direction Vector
//            otherwise operations on Vector2D(0,0) may throw NaN values
//            and the application will throw unexpected exceptions
            return;
        }
        move.vector.setY(action.getVectorY());
        move.vector.setX(action.getVectorX());
    }

    private static class Move {

        private final Vector2D vector = new Vector2D(1, 0);
        private double force = 0;

        private final Element element;
        private final Physics physics;

        private Move(Element element, Physics physics) {
            this.element = element;
            this.physics = physics;
        }

        private void run() {
            if ( "scene".equalsIgnoreCase(((BaseElement)element).type)) return;
            physics.calculate(vector, force);
        }

        @Override
        public String toString() {
            return "Move{" +
                    "vector=" + vector +
                    ", force=" + force +
                    '}';
        }

        public ActionType getAction() {
            if (force == 0) return ActionType.STAND;
            if (vector.getX() > 0) return ActionType.MOVE_RIGHT;
            if (vector.getX() < 0) return ActionType.MOVE_LEFT;
            return ActionType.STAND;
        }
    }

    @Override
    public String toString() {
        return "BaseElement{" +
                "id='" + id + '\'' +
                ", bounds=" + bounds.toString() +
                '}';
    }
}
