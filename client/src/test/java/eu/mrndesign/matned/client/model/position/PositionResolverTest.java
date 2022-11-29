package eu.mrndesign.matned.client.model.position;

import eu.mrndesign.matned.client.model.game.object.data.model.BaseImageData;
import eu.mrndesign.matned.client.model.tool.math.Point2D;
import eu.mrndesign.matned.client.model.tool.position.PositionResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

class PositionResolverTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1000, 500, 10, 5, CENTER, CENTER, 50, 50",
            "4, 11, 1000, 500, 10, 5, CENTER, CENTER, 450, 1150",
            "0, 0, 1000, 600, 10, 5, CENTER, CENTER, 50, 60"
    })
    void ShouldReturnExpectedPositionPoint_WhenXAndYIndexesGiven(int xIndex, int yIndex,
                                                                 int panelWidthPx, int panelHeightPx,
                                                                 int widthRatio, int heightRatio,
                                                                 double xDir, double yDir,
                                                                 String xPos, String yPos,
                                                                 double expectedX, double expectedY){
        BaseImageData baseImageData = new BaseImageData();
        baseImageData.setStartXPos(xIndex);
        baseImageData.setStartYPos(yIndex);
        baseImageData.setDirectionX(xDir);
        baseImageData.setDirectionY(yDir);
        baseImageData.setHorizontalPos(xPos);
        baseImageData.setVerticalPos(yPos);

        PositionResolver positionResolver = new PositionResolver(panelWidthPx, panelHeightPx, widthRatio, heightRatio);

        Point2D actual = positionResolver.resolve(baseImageData);
        Point2D expected = new Point2D(expectedX, expectedY);

        assertEquals(expected, actual);
    }

}