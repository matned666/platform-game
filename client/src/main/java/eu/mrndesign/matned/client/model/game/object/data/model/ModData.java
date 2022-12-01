package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONObject;

public class ModData {

    public static ModData parse(JSONObject mod) {
        ModData modData = new ModData();
        modData.setType(mod.get("type").isString().stringValue());
        modData.setDesc(mod.get("desc").isString().stringValue());
        modData.setValue(mod.get("value").isNumber().doubleValue());
        return modData;
    }

    private String type = "COMMON";
    private String desc = "";
    private double value;

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public double getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ModData{" +
                "type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", value=" + value +
                '}';
    }
}
