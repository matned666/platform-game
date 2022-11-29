package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static eu.mrndesign.matned.client.model.game.object.data.model.DialogData.generateDialogData;
import static eu.mrndesign.matned.client.model.game.object.data.model.ItemData.generateItemData;

public class CharacterData extends BaseImageData{
    private static final Logger logger = Logger.getLogger(CharacterData.class.getName());

    public static CharacterData generateCharacterData(JSONObject character) {
        CharacterData characterData = new CharacterData();
        BaseImageData.updateFromJSONObject(character, characterData);
        characterData.setHp((int) character.get("hp").isNumber().doubleValue());
        characterData.setHostile(character.get("hostile").isBoolean().booleanValue());
        JSONArray items = character.get("items").isArray();
        for (int i = 0; i < items.size(); i++) {
            characterData.getItems().add(generateItemData(items.get(i).isObject()));
        }
//        characterData.setDialogData(generateDialogData(character.get("dialogData").isObject()));
        return characterData;
    }


    private boolean hostile = true;
    private int hp;
    private final List<ItemData> items = new ArrayList<>();
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
