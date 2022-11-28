package eu.mrndesign.matned.client.model.game.object.data.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class CharacterData extends BaseImageData{

    private boolean hostile = true;
    private double hp;
    private final List<ItemData> items = new ArrayList<>();
    private DialogData dialogData;

    @XmlElement(name = "hostile", defaultValue = "true")
    public boolean isHostile() {
        return hostile;
    }

    @XmlElement(name = "hp")
    public double getHp() {
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

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public void setHp(double hp) {
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
                ", items=" + items +
                ", dialogData=" + dialogData +
                '}';
    }
}
