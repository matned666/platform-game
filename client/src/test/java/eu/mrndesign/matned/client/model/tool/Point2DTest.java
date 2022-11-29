package eu.mrndesign.matned.client.model.tool;

import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Point2DTest {

    @Test
    void angleBetweenPointsShouldBe135Degree () {
        Point2D p1 = new Point2D(0,-5);
        Point2D p2 = new Point2D(5,5);
        Point2D center = new Point2D(0,0);

        assertEquals(135, p1.angle(center, p2), 0.001);
    }

    @Test
    void distanceBetweenPointsShouldBe5(){
        Point2D p1 = new Point2D(0,-5);
        Point2D p2 = new Point2D(0,0);

        assertEquals(5, p1.distanceFrom(p2));
        assertEquals(5, p2.distanceFrom(p1));
    }

    @Test
    void distanceBetweenPointsShouldBeAccordingToFormula(){
        Point2D p1 = new Point2D(5,5);
        Point2D p2 = new Point2D(0,0);

        assertEquals(Math.sqrt(50), p1.distanceFrom(p2), 0.01);
    }

    @Test
    void givenPoints_DistanceShouldBeProper(){
        Point2D p1 = new Point2D(5,5);
        Point2D p2 = new Point2D(0,0);

        assertEquals(7.0710678, p1.distanceFrom(p2), 0.000001);
    }

    @Test
    void movePointByVector(){
        Point2D p = new Point2D(2, 2);
        Vector2D v = new Vector2D(3,2);
        p.move(v);
        assertEquals(new Point2D(5,4), p);
    }


    @Test
    void movingPoint() {
        Point2D p = new Point2D(2, 2);
        Vector2D v = new Vector2D(5,0);
        double moveDist = 4;
        p.move(v, moveDist);
        assertEquals(new Point2D(6,2), p);
    }

    @Test
    void movingPoint2() {
        Point2D p = new Point2D(2, 2);
        Vector2D v = new Vector2D(0,-120);
        double moveDist = 4;
        p.move(v, moveDist);
        assertEquals(new Point2D(2,-2), p);
    }


}