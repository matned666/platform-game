package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONObject;

public class SceneElementData extends BaseImageData{

    public static SceneElementData parse(JSONObject ground) {
        SceneElementData sceneElementData = new SceneElementData();
        BaseImageData.parseBaseData(ground, sceneElementData);
        sceneElementData.setDestructible(ground.get("destructible").isBoolean().booleanValue());
        sceneElementData.setHp(ground.get("hp").isNumber().doubleValue());
        return sceneElementData;
    }

    private boolean destructible;
    private double hp = 1;

    public boolean isDestructible() {
        return destructible;
    }

    public double getHp() {
        return hp;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "SceneElementData{" +
                super.toString() +
                ", destructible=" + destructible +
                ", hp=" + hp +
                '}';
    }
}
