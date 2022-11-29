package eu.mrndesign.matned.client.model.tool;

import eu.mrndesign.matned.client.model.tool.math.Line;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void intersectPointCheck1() {
        Line l1 = new Line(new Point2D(2,3), new Point2D(11,12));
        Line l2 = new Line(new Point2D(15,3), new Point2D(6,12));

        Point2D intersectionPoint = l1.lineLineIntersection(l2);

        Point2D shouldBe = new Point2D(8.5, 9.5);

        assertEquals(shouldBe, intersectionPoint);
    }

    @Test
    void intersectPointCheck2_whenSegmentsDontCross() {
        Line l1 = new Line(new Point2D(0,0), new Point2D(11,0));
        Line l2 = new Line(new Point2D(8,3), new Point2D(18,7));

        Point2D intersectionPoint = l1.lineLineIntersection(l2);

        Point2D shouldBe = new Point2D(0.5, 0);

        assertEquals(shouldBe, intersectionPoint);
    }

    @Test
    void intersectPointCheck3_whenLinesParallel_shouldBeNull() {
        Line l1 = new Line(new Point2D(0,0), new Point2D(11,0));
        Line l2 = new Line(new Point2D(0,7), new Point2D(11,7));

        Point2D intersectionPoint = l1.lineLineIntersection(l2);

        assertNull(intersectionPoint);
    }

    @Test
    void intersectPointCheck3_whenLinesEqual_shouldBeNull() {
        Line l1 = new Line(new Point2D(0,0), new Point2D(11,0));
        Line l2 = new Line(new Point2D(2,0), new Point2D(110,0));

        Point2D intersectionPoint = l1.lineLineIntersection(l2);

        assertNull(intersectionPoint);
    }







}