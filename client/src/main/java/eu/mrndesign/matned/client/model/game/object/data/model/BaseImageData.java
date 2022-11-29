package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONObject;

public class BaseImageData implements Boundable{

    private String name = "";
    private double width;
    private double height;
    private int startXPos;
    private int startYPos;
    private double directionX = 1;
    private double directionY;
    private String horizontalPos = "CENTER";
    private String verticalPos = "CENTER";

    public static BaseImageData generateBaseImageData(JSONObject image) {
        BaseImageData baseImageData = new BaseImageData();
        updateFromJSONObject(image,baseImageData);
        return baseImageData;
    }

    public static void updateFromJSONObject(JSONObject image, BaseImageData baseImageData){
        baseImageData.setName(image.get("name").isString().stringValue());
        baseImageData.setHorizontalPos(image.get("horizontalPos").isString().stringValue());
        baseImageData.setVerticalPos(image.get("verticalPos").isString().stringValue());
        baseImageData.setWidth(image.get("width").isNumber().doubleValue());
        baseImageData.setHeight(image.get("height").isNumber().doubleValue());
        baseImageData.setDirectionX(image.get("directionX").isNumber().doubleValue());
        baseImageData.setDirectionY(image.get("directionY").isNumber().doubleValue());
        baseImageData.setStartXPos((int) image.get("startXPos").isNumber().doubleValue());
        baseImageData.setStartYPos((int) image.get("startYPos").isNumber().doubleValue());
    }

    public String getName() {
        return name;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public int getStartXPos() {
        return startXPos;
    }

    @Override
    public int getStartYPos() {
        return startYPos;
    }

    @Override
    public String getHorizontalPos() {
        return horizontalPos;
    }

    @Override
    public String getVerticalPos() {
        return verticalPos;
    }

    @Override
    public double getDirectionX() {
        return directionX;
    }

    @Override
    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
    }

    public void setHorizontalPos(String horizontalPos) {
        this.horizontalPos = horizontalPos;
    }

    public void setVerticalPos(String verticalPos) {
        this.verticalPos = verticalPos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setStartXPos(int startXPos) {
        this.startXPos = startXPos;
    }

    public void setStartYPos(int startYPos) {
        this.startYPos = startYPos;
    }

    @Override
    public String toString() {
        return "BaseImageData{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", startXPos=" + startXPos +
                ", startYPos=" + startYPos +
                ", directionX=" + directionX +
                ", directionY=" + directionY +
                ", horizontalPos='" + horizontalPos + '\'' +
                ", verticalPos='" + verticalPos + '\'' +
                '}';
    }
}
