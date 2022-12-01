package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ActionData {

    private String name = "";
    private final List<Integer> keyCodes = new ArrayList<>();
    private String startTask = "";
    private String endTask = "";
    private double vectorX;
    private double vectorY;
    private double force;
    private final List<String> conditions = new ArrayList<>();
    private final List<String> images = new ArrayList<>();
    private final List<String> slotsUse = new ArrayList<>();

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "keyCodes")
    @XmlElement(name = "keyCode")
    public List<Integer> getKeyCodes() {
        return keyCodes;
    }

    @XmlElement(name = "startTask")
    public String getStartTask() {
        return startTask;
    }

    public void setStartTask(String startTask) {
        this.startTask = startTask;
    }

    @XmlElement(name = "endTask")
    public String getEndTask() {
        return endTask;
    }

    public void setEndTask(String endTask) {
        this.endTask = endTask;
    }

    @XmlElement(name = "vectorX")
    public double getVectorX() {
        return vectorX;
    }

    public void setVectorX(double vectorX) {
        this.vectorX = vectorX;
    }

    @XmlElement(name = "vectorY")
    public double getVectorY() {
        return vectorY;
    }

    public void setVectorY(double vectorY) {
        this.vectorY = vectorY;
    }

    @XmlElement(name = "force")
    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    public List<String> getImages() {
        return images;
    }

    @XmlElementWrapper(name = "conditions")
    @XmlElement(name = "condition")
    public List<String> getConditions() {
        return conditions;
    }

    @XmlElementWrapper(name = "slotsUse")
    @XmlElement(name = "slot")
    public List<String> getSlotsUse() {
        return slotsUse;
    }

    @Override
    public String toString() {
        return "ActionData{" +
                "name='" + name + '\'' +
                ", keyCodes=" + keyCodes +
                ", startTask='" + startTask + '\'' +
                ", endTask='" + endTask + '\'' +
                ", vectorX=" + vectorX +
                ", vectorY=" + vectorY +
                ", force=" + force +
                ", conditions=" + conditions +
                ", images=" + images +
                ", slotsUse=" + slotsUse +
                '}';
    }
}
