package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ItemData extends BaseImageData{
    private static final Logger logger = Logger.getLogger(ItemData.class.getName());

    public static ItemData parse(JSONObject item) {
        ItemData itemData = new ItemData();
        BaseImageData.parseBaseData(item, itemData);
        itemData.setType(item.get("type").isString().stringValue());
        itemData.setValue(item.get("value").isNumber().doubleValue());
        itemData.setSlot(item.get("slot").isString().stringValue());
        JSONArray mods = item.get("modDataTypes").isArray();
        for (int i = 0; i < mods.size(); i++) {
            itemData.getModDataTypes().add(ModData.parse(mods.get(i).isObject()));
        }
        return itemData;
    }

    private String type = "COMMON";
    private final List<ModData> modDataTypes = new ArrayList<>();
    private double value;
    private String slot;


    public String getType() {
        return type;
    }

    public List<ModData> getModDataTypes() {
        return modDataTypes;
    }

    public double getValue() {
        return value;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ItemData{" +
                super.toString() +
                "type='" + type + '\'' +
                ", modDataTypes=" + modDataTypes +
                ", value=" + value +
                ", slot=" + slot +
                '}';
    }

}
