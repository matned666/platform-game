package eu.mrndesign.matned.client.model.tool.position;

import eu.mrndesign.matned.client.model.game.object.data.model.BoundsData;
import eu.mrndesign.matned.client.model.tool.math.Point2D;

public class PositionResolver {

    private final int panelWidthPx;
    private final int panelHeightPx;
    private final int widthRatio;
    private final int heightRatio;

    public PositionResolver(int panelWidthPx, int panelHeightPx, int widthRatio, int heightRatio) {
        this.panelWidthPx = panelWidthPx;
        this.panelHeightPx = panelHeightPx;
        this.widthRatio = widthRatio;
        this.heightRatio = heightRatio;
    }

    public Point2D resolve(BoundsData boundsData) {
        double squareWidth = (double) panelWidthPx / widthRatio;
        double x = squareWidth * getPosModifier(boundsData.getVerticalPos());
        double squareHeight = (double) panelHeightPx / heightRatio + 5;
        double y = squareHeight * getPosModifier(boundsData.getVerticalPos());
        x += squareWidth * boundsData.getStartXPos();
        y += squareHeight * boundsData.getStartYPos();
        return new Point2D(x,y);
    }

    private double getPosModifier(String pos) {
        switch (pos) {
            case "CENTER": return 0.5;
            case "LEFT":
            case "TOP": return 0;
            case "RIGHT":
            case "BOTTOM": return 1;
        }
        return 0.5;
    }

}
