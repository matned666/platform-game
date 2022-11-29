package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ModData implements Serializable {

    private String type = "COMMON";
    private String desc = "";
    private double value;

    @XmlElement(name = "type", defaultValue = "COMMON")
    public String getType() {
        return type;
    }

    @XmlElement(name = "desc")
    public String getDesc() {
        return desc;
    }

    @XmlElement(name = "value")
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
