package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import eu.mrndesign.matned.client.model.game.object.ActionType;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ActionData {
    private static final Logger logger = Logger.getLogger(ActionData.class.getName());

    public static ActionData parse(JSONObject action) {
        ActionData actionData = new ActionData();
        actionData.setActionType(ActionType.getFrom(action.get("name").isString().stringValue()));
        JSONArray keyCodes = action.get("keyCodes").isArray();
        for (int i = 0; i < keyCodes.size(); i++) {
            actionData.keyCodes.add((int) keyCodes.get(i).isNumber().doubleValue());
        }
        actionData.setStartTask(action.get("startTask").isString().stringValue());
        actionData.setEndTask(action.get("endTask").isString().stringValue());
        actionData.setVectorX(action.get("vectorX").isNumber().doubleValue());
        actionData.setVectorY(action.get("vectorY").isNumber().doubleValue());
        actionData.setForce(action.get("force").isNumber().doubleValue());
        JSONArray conditions = action.get("conditions").isArray();
        for (int i = 0; i < conditions.size(); i++) {
            actionData.conditions.add(conditions.get(i).isString().stringValue());
        }
        JSONArray images = action.get("images").isArray();
        for (int i = 0; i < images.size(); i++) {
            actionData.images.add(images.get(i).isString().stringValue());
        }
        JSONArray slotsUse = action.get("slotsUse").isArray();
        for (int i = 0; i < slotsUse.size(); i++) {
            actionData.slotsUse.add(slotsUse.get(i).isString().stringValue());
        }
        return actionData;
    }

    private ActionType actionType;
    private final List<Integer> keyCodes = new ArrayList<>();
    private String startTask;
    private String endTask;
    private double vectorX;
    private double vectorY;
    private double force;
    private final List<String> conditions = new ArrayList<>();
    private final List<String> images = new ArrayList<>();
    private final List<String> slotsUse = new ArrayList<>();

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public List<Integer> getKeyCodes() {
        return keyCodes;
    }

    public List<String> getImages() {
        return images;
    }

    public String getStartTask() {
        return startTask;
    }

    public void setStartTask(String startTask) {
        this.startTask = startTask;
    }

    public String getEndTask() {
        return endTask;
    }

    public void setEndTask(String endTask) {
        this.endTask = endTask;
    }

    public double getVectorX() {
        return vectorX;
    }

    public void setVectorX(double vectorX) {
        this.vectorX = vectorX;
    }

    public double getVectorY() {
        return vectorY;
    }

    public void setVectorY(double vectorY) {
        this.vectorY = vectorY;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public List<String> getSlotsUse() {
        return slotsUse;
    }

    @Override
    public String toString() {
        return "ActionData{" +
                "name='" + actionType + '\'' +
                ", keyCodes=" + keyCodes +
                ", startTask='" + startTask + '\'' +
                ", endTask='" + endTask + '\'' +
                ", vectorX=" + vectorX +
                ", vectorY=" + vectorY +
                ", force=" + force +
                ", conditions=" + conditions +
                ", images=" + images +
                ", slotsUse=" + slotsUse +
                '}';
    }
}
