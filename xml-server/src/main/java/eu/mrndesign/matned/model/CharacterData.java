package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CharacterData extends BaseImageData {

    private boolean hostile = true;
    private int hp;
    private final List<ItemData> items =  new ArrayList<>();
    private final List<String> slots =  new ArrayList<>();
    private DialogData dialogData;

    @XmlElement(name = "hostile", defaultValue = "true")
    public boolean isHostile() {
        return hostile;
    }

    @XmlElement(name = "hp")
    public int getHp() {
        return hp;
    }

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<ItemData> getItems() {
        return items;
    }

    @XmlElement(name = "dialog")
    public DialogData getDialogData() {
        return dialogData;
    }

    @XmlElementWrapper(name = "slots")
    @XmlElement(name = "slot")
    public List<String> getSlots() {
        return slots;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDialogData(DialogData dialogData) {
        this.dialogData = dialogData;
    }

    @Override
    public String toString() {
        return "CharacterData{" +
                super.toString() +
                "hostile=" + hostile +
                ", hp=" + hp +
                ", slots=" + slots +
                ", items=" + items +
                ", dialogData=" + dialogData +
                '}';
    }
}
