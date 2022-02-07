package eu.mrndesign.matned.client.model.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Bounds2DTest {

    @Test
    void isSquareInBounds(){
        Bounds2D bounds1 = new Bounds2D(5,5, new Point2D(0,0));
        Bounds2D bounds2 = new Bounds2D(2,2, new Point2D(1,1));

        assertTrue(bounds2.isIn(bounds1));
    }

    @Test
    void isSquareInBounds2(){
        Bounds2D bounds1 = new Bounds2D(5,5, new Point2D(0,0));
        Bounds2D bounds2 = new Bounds2D(2,2, new Point2D(-1,1));

        assertTrue(bounds2.isIn(bounds1));
    }

    @Test
    void isTouched(){
        Bounds2D box = new Bounds2D(10, 10, new Point2D(0, 0));
        Bounds2D touch = new Bounds2D(4, 4, new Point2D(5, 0));
        assertTrue(box.touchedBy(touch), "try 1");

        touch.setCenter(4,-5);
                assertTrue(box.touchedBy(touch), "try 1");




    }




}