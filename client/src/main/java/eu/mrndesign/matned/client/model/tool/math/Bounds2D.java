package eu.mrndesign.matned.client.model.tool.math;

import eu.mrndesign.matned.client.model.game.object.data.model.BoundsData;

import java.util.Arrays;
import java.util.logging.Logger;

public class Bounds2D {
    protected static final Logger logger = Logger.getLogger(Bounds2D.class.getName());

    public static Bounds2D generateFrom(BoundsData data){
            final Bounds2D bounds;
            Point2D center = new Point2D(data.getStartXPos(), data.getStartYPos());
            Vector2D vector = new Vector2D(data.getDirectionX(), data.getDirectionY());
            bounds = new Bounds2D(vector, data.getWidth(), data.getHeight(), center);
            return bounds;
    }

    private final Vector2D vector;
    private final double width;
    private final double height;
    private final Point2D center;

    public Bounds2D(Vector2D vector, double width, double height, Point2D center) {
        this.width = width;
        this.height = height;
        this.center = center;
        this.vector = vector;
    }

    /**
     * <br> Collision check.
     * <br> Checks if there is any gap on shadows dropped by both figures on each figure each side
     * <br> if there is a gap found than touched by returns false result
     * @param b collider
     * @return boolean result
     */
    public boolean touchedBy(Bounds2D b) {
        return isNoGapBetweenBounds(b) && b.isNoGapBetweenBounds(this);
    }

    private boolean isNoGapBetweenBounds(Bounds2D b) {
        Point2D thisBottomLeft = getCorner(CornerType.BOTTOM_LEFT);
        Point2D thisTopLeft = getCorner(CornerType.TOP_LEFT);
        Point2D thisTopRight = getCorner(CornerType.TOP_RIGHT);
        Point2D thisBottomRight = getCorner(CornerType.BOTTOM_RIGHT);

        return isNoGapBetweenBoundsOnVector(thisTopLeft, thisTopRight, b) &&
                isNoGapBetweenBoundsOnVector(thisBottomLeft, thisTopLeft, b) &&
                isNoGapBetweenBoundsOnVector(thisTopRight, thisBottomRight, b) &&
                isNoGapBetweenBoundsOnVector(thisBottomRight, thisBottomLeft, b);
    }

    private boolean isNoGapBetweenBoundsOnVector(Point2D origin, Point2D secondary, Bounds2D b) {
        Vector2D vector2D = new Vector2D(origin, secondary);
        vector2D.normalize();
        double dotOrigin = vector2D.realDot(origin);
        double dotSecondary = vector2D.realDot(secondary);
        return Arrays.stream(CornerType.values()).anyMatch(cornerType -> {
            double dot1 = vector2D.realDot(b.getCorner(cornerType));
            return dot1 >= dotOrigin && dot1 <= dotSecondary || dot1 >= dotSecondary && dot1 <= dotOrigin;
        }) || Arrays.stream(b.borders()).anyMatch(border ->{
            double dot1 = vector2D.realDot(border.p1);
            double dot2 = vector2D.realDot(border.p2);
            boolean bool1 = dotOrigin >= dot1 &&  dotOrigin <= dot2 && dotSecondary >= dot1 &&  dotSecondary <= dot2;
            boolean bool2 = dotOrigin >= dot2 &&  dotOrigin <= dot1 && dotSecondary >= dot2 &&  dotSecondary <= dot1;
            return bool1 || bool2;
        });
    }

    public Border[] borders(){
        return new Border[]{left(),right(), top(),bottom()};
    }

    public Point2D getCorner(CornerType cornerType) {
        Vector2D vPerp = vector.getPerpVector();
        return new Point2D(center).move(vPerp, cornerType.xMod * width/2).move(vector, cornerType.yMod * height/2);
    }

    private Border right() {
        return new Border(getCorner(CornerType.BOTTOM_RIGHT), getCorner(CornerType.TOP_RIGHT));
    }

    private Border left() {
        return new Border(getCorner(CornerType.TOP_LEFT), getCorner(CornerType.BOTTOM_LEFT));
    }

    private Border top() {
        return new Border(getCorner(CornerType.TOP_LEFT), getCorner(CornerType.TOP_RIGHT));
    }

    private Border bottom() {
        return new Border(getCorner(CornerType.BOTTOM_LEFT), getCorner(CornerType.BOTTOM_RIGHT));
    }

    private static class Border{
        private final Point2D p1;
        private final Point2D p2;

        public Border(Point2D p1, Point2D p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public enum CornerType {
        BOTTOM_LEFT(1, -1),
        BOTTOM_RIGHT(-1, -1),
        TOP_LEFT(1, 1),
        TOP_RIGHT(-1, 1);

        private final int xMod;
        private final int yMod;

        CornerType(int xMod, int yMod) {
            this.xMod = xMod;
            this.yMod = yMod;
        }
    }

    public Point2D getCenter() {
        return center;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setCenter(double x, double y) {
        center.setX(x);
        center.setY(y);
    }

    @Override
    public String toString() {
        return "Bounds: c:"+center + ", v:" + vector + ", w:" +width + ", h:"+height;
    }

    public Vector2D getVector() {
        return vector;
    }

    public void setVector(Vector2D vector) {
        this.vector.copy(vector);
    }

}
