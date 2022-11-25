package eu.mrndesign.matned.client.model.tools;

import java.util.Objects;

public class Point2D {

    protected double x;
    protected double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D copy) {
        this(copy.x, copy.y);
    }

    public static Point2D zero() {
        return new Point2D(0, 0);
    }

    public static Point2D one() {
        return new Point2D(1,1);
    }

    public static Point2D randomPoint(int panelWidthInt, int panelHeightInt) {
        int x = (int) (Math.random() * panelWidthInt);
        int y = (int) (Math.random() * panelHeightInt);
        return new Point2D(x, y);
    }

    public static Point2D randomPointOnEdge(double widthInt, double panelWidthInt, double panelHeightInt) {
        int lottery = (int) (Math.random() * 3);
        int x = (int) (Math.random() * panelWidthInt);
        int y = (int) (Math.random() * panelHeightInt);
        switch (lottery) {
            case 0:
                return new Point2D(widthInt, y);
            case 1:
                return new Point2D(panelWidthInt - widthInt, y);
            case 2:
                return new Point2D(x, panelHeightInt - widthInt);
            default:
                return new Point2D(x, widthInt);
        }
    }

    /**
     * distance between points
     *
     * @param point second point
     * @return distance double value
     */
    public double distanceFrom(Point2D point) {
        return distanceFrom(point.x, point.y);
    }

    /**
     * angle between points on center point
     *
     * @param center reference point
     * @param point  second pt
     * @return angle degree value
     */
    public double angle(Point2D center, Point2D point) {
        Vector2D v1 = new Vector2D(center, this);
        Vector2D v2 = new Vector2D(center, point);
        return v1.angleTo(v2);
    }

    public void move(Vector2D v) {
        x += v.getX();
        y += v.getY();
    }

    public Point2D move(Vector2D v, double d) {
        v.normalize();
        x += v.getX() * d;
        y += v.getY() * d;
        return this;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 && Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public void copy(Point2D b) {
        x = b.x;
        y = b.y;
    }

    public double distanceFrom(double x, double y) {
        return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }

    public Vector2D moved(Vector2D vector, double v) {
        return new Vector2D(new Point2D(0,0).move(new Vector2D(vector), v));
    }
}
