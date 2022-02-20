package eu.mrndesign.matned.client.model.tools;

public class Bounds2D {

    protected double width;
    protected double height;
    protected final Point2D center;

    public Bounds2D(double width, double height, Point2D point2D) {
        this.width = width;
        this.height = height;
        center = point2D;
    }

    public Bounds2D(Bounds2D bounds2D) {
        width = bounds2D.width;
        height = bounds2D.height;
        center = new Point2D(bounds2D.center);
    }

    public boolean isIn(Bounds2D bounds2D) {
        return topBorder() > bounds2D.topBorder()
                && bottomBorder() < bounds2D.bottomBorder()
                && leftBorder() > bounds2D.leftBorder()
                && rightBorder() < bounds2D.rightBorder();
    }

    public boolean touchedBy(Bounds2D bounds2D) {
        boolean inX = leftBorder() >= bounds2D.leftBorder() && leftBorder() <= bounds2D.rightBorder()
                || rightBorder() >= bounds2D.leftBorder() && leftBorder() <= bounds2D.rightBorder()
                || rightBorder() >= bounds2D.rightBorder() && leftBorder() <= bounds2D.leftBorder();
        boolean inY = topBorder() >= bounds2D.topBorder() && topBorder() <= bounds2D.bottomBorder()
                || bottomBorder() >= bounds2D.topBorder() && topBorder() <= bounds2D.bottomBorder()
                || bottomBorder() >= bounds2D.bottomBorder() && topBorder() <= bounds2D.topBorder();
        return inY && inX;
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
}
