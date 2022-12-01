package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CharacterData extends BaseImageData{
    private static final Logger logger = Logger.getLogger(CharacterData.class.getName());

    public static CharacterData parse(JSONObject character) {
        CharacterData characterData = new CharacterData();
        BaseImageData.parseBaseData(character, characterData);
        characterData.setHp((int) character.get("hp").isNumber().doubleValue());
        characterData.setHostile(character.get("hostile").isBoolean().booleanValue());
        JSONArray items = character.get("items").isArray();
        for (int i = 0; i < items.size(); i++) {
            characterData.getItems().add(ItemData.parse(items.get(i).isObject()));
        }
        JSONArray slots = character.get("slots").isArray();
        for (int i = 0; i < slots.size(); i++) {
            characterData.getSlots().add(slots.get(i).isString().stringValue());
        }
//        characterData.setDialogData(generateDialogData(character.get("dialogData").isObject()));
        return characterData;
    }


    private boolean hostile = true;
    private int hp;
    private final List<ItemData> items = new ArrayList<>();
    private final List<String> slots =  new ArrayList<>();

//    private DialogData dialogData;

    public boolean isHostile() {
        return hostile;
    }

    public int getHp() {
        return hp;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public List<String> getSlots() {
        return slots;
    }


//    public DialogData getDialogData() {
//        return dialogData;
//    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

//    public void setDialogData(DialogData dialogData) {
//        this.dialogData = dialogData;
//    }

    @Override
    public String toString() {
        return "CharacterData{" +
                super.toString() +
                "hostile=" + hostile +
                ", hp=" + hp +
                ", items=" + items +
//                ", dialogData=" + dialogData +
                '}';
    }
}
