package eu.mrndesign.matned.client.model.tool.math;

import eu.mrndesign.matned.client.model.game.object.data.model.Boundable;
import eu.mrndesign.matned.client.model.tool.position.PositionResolver;

import java.util.*;

import static eu.mrndesign.matned.client.controller.Constants.*;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_SQUARES;

public class Bounds2D {

    public static Bounds2D generate(Boundable boundable){
            final Bounds2D bounds;
            final PositionResolver positionResolver = new PositionResolver(PANEL_WIDTH_INT, PANEL_HEIGHT_INT, PANEL_WIDTH_SQUARES, PANEL_HEIGHT_SQUARES);
            Point2D center = positionResolver.resolve(boundable);
            Vector2D vector = new Vector2D(boundable.getDirectionX(), boundable.getDirectionY());
            bounds = new Bounds2D(vector, boundable.getWidth(), boundable.getHeight(), center);
            return bounds;
    }

    protected Vector2D vector;
    protected double width;
    protected double height;
    protected final Point2D center;

    public Bounds2D() {
        this(new Vector2D(1,0), 1,1,new Point2D(0,0));
    }

    public Bounds2D(Vector2D vector, double width, double height, Point2D center) {
        this.width = width;
        this.height = height;
        this.center = center;
        this.vector = vector;
    }

    public boolean isOutOfView() {
        return center.x < 0 || center.x > PANEL_WIDTH_INT || center.y < 0 || center.y > PANEL_HEIGHT_INT;
    }

    public boolean isIn(Bounds2D bounds2D) {
        return topBorder() > bounds2D.topBorder()
                && bottomBorder() < bounds2D.bottomBorder()
                && leftBorder() > bounds2D.leftBorder()
                && rightBorder() < bounds2D.rightBorder();
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
        System.out.println();
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
        return new Point2D(center).move(vPerp, cornerType.wMod * width*3/5).move(vector, cornerType.hMod * height*4/5);
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

    public boolean isOn(Bounds2D bounds) {
        return touchedBy(bounds) && bounds.topBorder() <= bottomBorder();
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
        BOTTOM_LEFT(-1, -1),
        BOTTOM_RIGHT(1, -1),
        TOP_LEFT(-1, 1),
        TOP_RIGHT(1, 1);

        private final int wMod;
        private final int hMod;

        CornerType(int wMod, int hMod) {
            this.wMod = wMod;
            this.hMod = hMod;
        }
    }


    public double leftBorder() {
        return center.getX() - width / 2;
    }

    public double rightBorder() {
        return center.getX() + width / 2;
    }

    public double topBorder() {
        return center.getY() - height / 2;
    }

    public double bottomBorder() {
        return center.getY() + height / 2;
    }

    public Point2D getCenter() {
        return center;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public void setCenter(Point2D p) {
        setCenter(p.x, p.y);
    }

    public void setCenter(double x, double y) {
        center.setX(x);
        center.setY(y);
    }

    @Override
    public String toString() {
        return "Bounds: "+center + ", " + vector.moved(vector, height / 2) + ", " + vector.moved(vector, height / 2).getPerpVector();
    }

    public Vector2D getVector() {
        return vector;
    }

    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

    public void rotate(double x, double y) {
        this.vector = new Vector2D(center, x, y);
    }

}
