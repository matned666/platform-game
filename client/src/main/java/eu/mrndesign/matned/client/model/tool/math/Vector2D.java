package eu.mrndesign.matned.client.model.tool.math;

public class Vector2D extends Point2D{

    public static Vector2D ZERO = new Vector2D(0,0);

    public Vector2D(double x, double y) {
        super(x,y);
        this.x = x;
        this.y = y;
    }

    public Vector2D(Point2D start, Point2D end) {
        this(end.getX() - start.getX(), end.getY() - start.getY());
    }

    public Vector2D(Vector2D copy) {
        this(copy.x, copy.y);
    }

    public Vector2D(Point2D end) {
        super(end.x, end.y);
    }

    public double angleTo(Vector2D v) {
        return angleTo(v.x, v.y);
    }

    public double angleTo(double x1, double y1) {
        double dot = x*x1 + y*y1;
        double det = x*y1 - y*x1;
        double result = Math.toDegrees(Math.atan2(det, dot));
        if (result >= 0) {
            return result;
        } else {
            return 360 + result;
        }
    }

    public void normalize(){
        double length = Math.abs(Math.sqrt(x*x + y*y));
        x /= length;
        y /= length;
    }

    public static Vector2D normalized(Vector2D v){
        Vector2D result = new Vector2D(v);
        double magnitude = v.magnitude();
        result.x /= magnitude;
        result.y /= magnitude;
        return result;
    }

    public void rotate(double angleDegrees){
        double oldX = x;
        x = (oldX * Math.cos(Math.toRadians(angleDegrees)) + y * Math.sin(Math.toRadians(angleDegrees)));
        y = (oldX * Math.sin(Math.toRadians(angleDegrees)) + y * Math.cos(Math.toRadians(angleDegrees)));
    }

    public Vector2D rotated(double angleDegrees){
        Vector2D v = new Vector2D(this);
        v.rotate(angleDegrees);
        return v;
    }

    public void add(Vector2D v) {
        x += v.x;
        y += v.y;
    }

    public void subtract(Vector2D v) {
        x -= v.x;
        y -= v.y;
    }

    public void multiply(Vector2D v) {
        x *= v.x;
        y *= v.y;
    }

    public double realDot(Vector2D v) {
        double magnitude = magnitude();
        return v.x * x / magnitude + v.y * y / magnitude;
    }

    public double realDot(Point2D v) {
        double magnitude = magnitude();
        return v.x * x / magnitude + v.y * y / magnitude;
    }

    public double dot(Vector2D v) {
        double magnitude = magnitude();
        return Math.abs(v.x * x / magnitude + v.y * y / magnitude);
    }

    public double magnitude(){
        return Math.sqrt(x*x + y*y);
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
    public String toString() {
        return x + "," + y;
    }

    public Vector2D withLength(double length) {
        normalize();
        Point2D end = zero();
        end.move(this, length);
        return new Vector2D(end);
    }

    public Vector2D added(Vector2D added) {
        Vector2D result = new Vector2D(this);
        result.add(added);
        return result;
    }

    public Vector2D newNormalized() {
        Vector2D result = new Vector2D(this);
        result.normalize();
        return result;
    }

    public Vector2D magnituded(double v) {
        Point2D point = zero();
        point.move(this, v);
        return new Vector2D(point);
    }

    public Vector2D multiplied(Vector2D vNorm) {
        Vector2D v = new Vector2D(this);
        v.multiply(vNorm);
        return v;
    }

    public Vector2D getPerpVector() {
        return new Vector2D(y, -x);
    }

    public void paste(Vector2D v){
        x = v.x;
        y = v.y;
    }

    public Vector2D opposite() {
        Vector2D result = new Vector2D(this);
        result.x *= -1;
        result.y *= -1;
        return result;
    }
}
