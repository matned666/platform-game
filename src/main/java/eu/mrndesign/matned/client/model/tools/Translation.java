package eu.mrndesign.matned.client.model.tools;

public class Translation {

    public static double[] set(Point2D point, Bounds2D drawingArea) {
        double x = point.getX() - drawingArea.getWidth()/2;
        double y = point.getY() - drawingArea.getHeight()/2;
        return new double[] { x, y };
    }

}
