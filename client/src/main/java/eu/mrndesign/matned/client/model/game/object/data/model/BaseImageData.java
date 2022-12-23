package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import eu.mrndesign.matned.client.model.exception.ActionNotFoundException;
import eu.mrndesign.matned.client.model.game.object.ActionType;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseImageData implements BoundsData {
    private static final Logger logger = Logger.getLogger(BaseImageData.class.getName());

    private String name = "";
    private final List<ActionData> actions = new ArrayList<>();
    private double width;
    private double height;
    private double startXPos;
    private double startYPos;
    private double directionX = 0;
    private double directionY = -1;

    public static BaseImageData parseBase(JSONObject image) {
        BaseImageData baseImageData = new BaseImageData();
        parseBaseData(image,baseImageData);
        return baseImageData;
    }

    public static void parseBaseData(JSONObject image, BaseImageData baseImageData){
        baseImageData.setName(image.get("name").isString().stringValue());
        JSONArray actions = image.get("actions").isArray();
        for (int i = 0; i < actions.size(); i++) {
            baseImageData.getActions().add(ActionData.parse(actions.get(i).isObject()));
        }
        baseImageData.setWidth(image.get("width").isNumber().doubleValue());
        baseImageData.setHeight(image.get("height").isNumber().doubleValue());
        baseImageData.setDirectionX(image.get("directionX").isNumber().doubleValue());
        baseImageData.setDirectionY(image.get("directionY").isNumber().doubleValue());
        baseImageData.setStartXPos(image.get("startXPos").isNumber().doubleValue());
        baseImageData.setStartYPos(image.get("startYPos").isNumber().doubleValue());
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
    public double getStartXPos() {
        return startXPos;
    }

    @Override
    public double getStartYPos() {
        return startYPos;
    }

    @Override
    public ActionData getAction(ActionType actionType, boolean shiftDown, boolean ctrlDown) {
        return actions.stream()
                .filter(a -> a.getActionType() == actionType)
                .findFirst()
                .orElseThrow(()->new ActionNotFoundException("BaseImageData", actionType));
    }

    @Override
    public double getDirectionX() {
        return directionX;
    }

    @Override
    public double getDirectionY() {
        return directionY;
    }

    public List<ActionData> getActions() {
        return actions;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
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

    public void setStartXPos(double startXPos) {
        this.startXPos = startXPos;
    }

    public void setStartYPos(double startYPos) {
        this.startYPos = startYPos;
    }

    @Override
    public String toString() {
        return "BaseImageData{" +
                "name='" + name + '\'' +
                ", actions=" + actions +
                ", width=" + width +
                ", height=" + height +
                ", startXPos=" + startXPos +
                ", startYPos=" + startYPos +
                ", directionX=" + directionX +
                ", directionY=" + directionY +
                '}';
    }
}
