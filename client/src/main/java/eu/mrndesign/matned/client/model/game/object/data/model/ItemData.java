package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemData extends BaseImageData{

    public static ItemData generateItemData(JSONObject item) {
        ItemData itemData = new ItemData();
        BaseImageData.updateFromJSONObject(item, itemData);
        itemData.setType(item.get("type").isString().stringValue());
        itemData.setValue(item.get("value").isNumber().doubleValue());
        itemData.setEquipped(item.get("equipped").isBoolean().booleanValue());
        JSONArray mods = item.get("modDataTypes").isArray();
        for (int i = 0; i < mods.size(); i++) {
            itemData.getModDataTypes().add(ModData.generateModType(mods.get(i).isObject()));
        }
        return itemData;
    }

    private String type = "COMMON";
    private final List<ModData> modDataTypes = new ArrayList<>();
    private double value;
    private boolean equipped;

    public String getType() {
        return type;
    }

    public List<ModData> getModDataTypes() {
        return modDataTypes;
    }

    public double getValue() {
        return value;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                super.toString() +
                "type='" + type + '\'' +
                ", modDataTypes=" + modDataTypes +
                ", value=" + value +
                ", equipped=" + equipped +
                '}';
    }

}
