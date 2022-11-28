package eu.mrndesign.matned.client.model.tool;

public class CubicCurve2D {

    private final Point2D start;
    private final Point2D ctrl1;
    private final Point2D ctrl2;
    private final Point2D end;

    public CubicCurve2D(Point2D start, Point2D ctrl1, Point2D ctrl2, Point2D end) {
        this.start = start;
        this.ctrl1 = ctrl1;
        this.ctrl2 = ctrl2;
        this.end = end;
    }

    public Point2D getStart() {
        return start;
    }

    public Point2D getCtrl1() {
        return ctrl1;
    }

    public Point2D getCtrl2() {
        return ctrl2;
    }

    public Point2D getEnd() {
        return end;
    }

    private double[] spanLengths;
    private Vector2D[] vectors;
    private int samples;
    private Point2D[] startCopy;
    private Point2D[] ctrl2Copy;

    private Line l1;
    private Line l2;

    private Point2D intersPt1;
    private Point2D intersPt2;

    public double calculateLength(int samples) {
        if (samples <= 0) {
            return 0;
        }
        if (samples <= 2){
            l1 = new Line(start, ctrl2);
            l2 = new Line(end, ctrl1);
            Point2D intersectionPt = l1.lineLineIntersection(l2);
            return start.distanceFrom(intersectionPt) + end.distanceFrom(intersectionPt);
        }
        return lengthCalculator(samples);
    }

    private double lengthCalculator(int samples) {
        this.samples = samples;
        startCopy = new Point2D[]{new Point2D(start), new Point2D(start)};
        ctrl2Copy = new Point2D[]{new Point2D(ctrl2), new Point2D(ctrl2)};
        intersPt1 = new Point2D(start);
        intersPt2 = new Point2D(start);
        l1 = new Line(startCopy[0], ctrl2Copy[0]);
        l2 = new Line(startCopy[1], ctrl2Copy[1]);
        spanLengths = new double[]{start.distanceFrom(ctrl1) / this.samples, end.distanceFrom(ctrl2) / this.samples};
        vectors = new Vector2D[]{new Vector2D(start, ctrl1), new Vector2D(ctrl2, end)};
        moveLines(0);
        return recurveLengthCalculator(0, 0);
    }

    private double recurveLengthCalculator(int actualRound, double result) {
        if (actualRound <= samples) {
            intersPt2 = l1.lineLineIntersection(l2);
            result += intersPt2 != null ? intersPt2.distanceFrom(intersPt1) : 0;
            moveLines(1);
            intersPt1.copy(intersPt2 != null ? intersPt2 : intersPt1);
            moveLines(0);
            return recurveLengthCalculator(++actualRound, result);
        }
        result += intersPt2.distanceFrom(end);
        return result;
    }

    private void moveLines(int index) {
        startCopy[index].move(vectors[0], spanLengths[0]);
        ctrl2Copy[index].move(vectors[1], spanLengths[1]);
    }


}
