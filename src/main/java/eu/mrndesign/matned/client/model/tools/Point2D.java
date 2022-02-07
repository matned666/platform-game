package eu.mrndesign.matned.client.model.tools;

import java.util.Objects;

public class Point2D {

    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D copy) {
        this(copy.x, copy.y);
    }

    /**
     * distance between points
     * @param point second point
     * @return distance double value
     */
    public double distanceFrom(Point2D point){
        return Math.abs(Math.sqrt((point.getX() - x)*(point.getX() - x) + (point.getY() - y)*(point.getY() - y)) );
    }

    /**
     * angle between points on center point
     * @param center reference point
     * @param point second pt
     * @return angle degree value
     */
    public double angle(Point2D center, Point2D point){
        Vector2D v1 = new Vector2D(center, this);
        Vector2D v2 = new Vector2D(center, point);
        return v1.angleTo(v2);
    }

    public void move(Vector2D v, double d) {
        v.normalize();
        x += v.getX()*d;
        y += v.getY()*d;
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
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
