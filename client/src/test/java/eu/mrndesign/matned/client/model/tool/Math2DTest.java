package eu.mrndesign.matned.client.model.tool;

import eu.mrndesign.matned.client.model.tool.math.Math2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Math2DTest {

    @Test
    public void randomNumberDoesntGoOutOfRangeIn1000Tries(){
        boolean result = true;
        int start = 0;
        int end = 10;
        int highestNum = start;
        int lowestNum = end;
        for (int i = 0; i < 1000; i++) {
            int number = Math2D.randomInt(start, end);
            if (number < start || number > end) result = false;
            if (number > highestNum) highestNum = number;
            if (number < lowestNum) lowestNum = number;
        }

        assertTrue(result);
        assertEquals(highestNum, end);
        assertEquals(lowestNum, start);
    }


}