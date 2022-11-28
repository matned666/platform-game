package eu.mrndesign.matned.client.model.game.object.data.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class ItemData extends BaseImageData{

    private String type = "COMMON";
    private final List<ModData> modDataTypes = new ArrayList<>();
    private double value;
    private boolean equipped;

    @XmlElement(name = "type", defaultValue = "COMMON")
    public String getType() {
        return type;
    }

    @XmlElementWrapper(name = "modTypes")
    @XmlElement(name = "modType")
    public List<ModData> getModDataType() {
        return modDataTypes;
    }

    @XmlElement(name = "type")
    public double getValue() {
        return value;
    }

    @XmlElement(name = "equipped")
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
