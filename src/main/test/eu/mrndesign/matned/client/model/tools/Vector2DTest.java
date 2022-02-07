package eu.mrndesign.matned.client.model.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {

    @Test
    void angleBetweenVectorsShouldBe45 (){
        Vector2D v1 = new Vector2D(5,5);
        Vector2D v2 = new Vector2D(0,5);
        assertEquals(45, v1.angleTo(v2), 0.001);
    }

    @Test
    void angleBetweenVectorsShouldBe135 (){
        Vector2D v1 = new Vector2D(0,-5);
        Vector2D v2 = new Vector2D(5,5);
        assertEquals(135, v1.angleTo(v2), 0.001);
    }

    @Test
    void angleBetweenVectorsShouldBe315 (){
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(5,5);
        assertEquals(315, v1.angleTo(v2), 0.001);
    }

    @Test
    void angleBetweenVectorsShouldBe90 (){
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(5,0);
        assertEquals(90, v2.angleTo(v1), 0.001);
    }

    @Test
    void angleBetweenVectorsShouldBe180 (){
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(0,-5);
        assertEquals(180, v2.angleTo(v1), 0.001);
    }

    @Test
    void rotateVectorBy_90Degree (){
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(v1);

        v1.rotate(90);

        assertEquals(90, v1.angleTo(v2), 0.001);
    }

    @Test
    void rotateVectorBy_159Degree () {
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(v1);

        v1.rotate(159);

        assertEquals(159, v1.angleTo(v2), 0.001);
    }


    @Test
    void rotateVectorBy_182Degree () {
        Vector2D v1 = new Vector2D(0,5);
        Vector2D v2 = new Vector2D(v1);

        v1.rotate(288);

        assertEquals(288, v1.angleTo(v2), 0.001);
    }

    @Test
    void rotateVectorBy_182Degree_differentCheck () {
        Vector2D v1 = new Vector2D(0,5);

        v1.rotate(288);

        assertEquals(288, v1.angleTo(0, 5), 0.001);
    }











}