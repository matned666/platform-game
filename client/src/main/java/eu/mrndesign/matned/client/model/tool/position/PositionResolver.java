package eu.mrndesign.matned.client.model.tool.position;

import eu.mrndesign.matned.client.model.game.object.data.model.Boundable;
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

    public Point2D resolve(Boundable boundable) {
        double squareWidth = (double) panelWidthPx / widthRatio;
        double x = squareWidth * getPosModifier(boundable.getVerticalPos());
        double squareHeight = (double) panelHeightPx / heightRatio;
        double y = squareHeight * getPosModifier(boundable.getVerticalPos());
        x += squareWidth * boundable.getStartXPos();
        y += squareHeight * boundable.getStartYPos();
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
