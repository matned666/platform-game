package eu.mrndesign.matned.client.model.tools;

import java.util.HashMap;
import java.util.Map;

import static eu.mrndesign.matned.client.controller.Constants.PANEL_HEIGHT_INT;
import static eu.mrndesign.matned.client.controller.Constants.PANEL_WIDTH_INT;

public class Bounds2D {

    protected Vector2D vector;
    protected double width;
    protected double height;
    protected final Point2D center;

    public Bounds2D(Vector2D vector, double width, double height, Point2D center) {
        this.width = width;
        this.height = height;
        this.center = center;
        this.vector = vector;
    }

    public boolean isOutOfView(){
        return center.x < 0 || center.x > PANEL_WIDTH_INT || center.y < 0 || center.y > PANEL_HEIGHT_INT;
    }

    public boolean isIn(Bounds2D bounds2D) {
        return topBorder() > bounds2D.topBorder()
                && bottomBorder() < bounds2D.bottomBorder()
                && leftBorder() > bounds2D.leftBorder()
                && rightBorder() < bounds2D.rightBorder();
    }

    public boolean touchedBy(Bounds2D b) {
//        boolean inX = leftBorder() >= bounds2D.leftBorder() && leftBorder() <= bounds2D.rightBorder()
//                || rightBorder() >= bounds2D.leftBorder() && leftBorder() <= bounds2D.rightBorder()
//                || rightBorder() >= bounds2D.rightBorder() && leftBorder() <= bounds2D.leftBorder();
//        boolean inY = topBorder() >= bounds2D.topBorder() && topBorder() <= bounds2D.bottomBorder()
//                || bottomBorder() >= bounds2D.topBorder() && topBorder() <= bounds2D.bottomBorder()
//                || bottomBorder() >= bounds2D.bottomBorder() && topBorder() <= bounds2D.topBorder();
//        return inY && inX;

//v2
//        Vector2D aToBVector = new Vector2D(center, b.center);
//        Vector2D aPerpendicularVector = vector.rotated(90).newNormalized().magnituded(width/2);
//        Vector2D bPerpendicularVector = b.vector.rotated(90).newNormalized().magnituded(b.width/2);
//
//        Vector2D aToBNorm = aToBVector.newNormalized();
//
//        Vector2D aPerpMultiplyAToBNorm = aPerpendicularVector.multiplied(aToBNorm);
//        Vector2D bPerpMultiplyAToBNorm = bPerpendicularVector.multiplied(aToBNorm);
//        Vector2D aMultiplyAToBNorm = vector.multiplied(aToBNorm);
//        Vector2D bMultiplyAToBNorm = b.vector.multiplied(aToBNorm);
//
//        List<Double> results = new LinkedList<>();
//        results.add(aPerpMultiplyAToBNorm.magnitude() + bPerpMultiplyAToBNorm.magnitude());
//        results.add(aMultiplyAToBNorm.magnitude() + bMultiplyAToBNorm.magnitude());
//        results.add(aPerpMultiplyAToBNorm.magnitude() + aMultiplyAToBNorm.magnitude());
//        results.add(bPerpMultiplyAToBNorm.magnitude() + aMultiplyAToBNorm.magnitude());
//        results.add(aPerpMultiplyAToBNorm.magnitude() + bMultiplyAToBNorm.magnitude());
//        results.add(bPerpMultiplyAToBNorm.magnitude() + bMultiplyAToBNorm.magnitude());
//
//        return results.stream().anyMatch(r -> r <= aToBVector.magnitude());

        final double[] vLength = {0};
        Vector2D connectVector = new Vector2D(center, b.center);

        Map<Double, Vector2D> map = new HashMap<>();
        map.putAll(minAngleAndVector(connectVector, this));
        map.putAll(minAngleAndVector(connectVector, b));
        map.forEach((angle, vector) -> {
            vLength[0] += vector.magnitude() / Math.cos(angle);
        });

        return vLength[0] < connectVector.magnitude();

    }

    public Map<Double, Vector2D> minAngleAndVector(Vector2D connectVector, Bounds2D bounds) {

        Vector2D aV90 = bounds.vector.rotated(90);

        Map<Double, Vector2D> results = new HashMap<>();
        double a = bounds.vector.angleTo(connectVector);
        results.put(a, bounds.vector);
        double b = aV90.angleTo(connectVector);
        results.put(b, aV90);

        Map<Double, Vector2D> result = new HashMap<>();
        double min = Math.min(a, b);
        result.put(min, results.get(min));
        return result;
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

    public void setCenter(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    @Override
    public String toString() {
        return "Bounds2D{" +
                "width=" + width +
                ", height=" + height +
                '}';
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
