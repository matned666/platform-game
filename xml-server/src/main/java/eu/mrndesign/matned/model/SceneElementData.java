package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;

public class SceneElementData extends BaseImageData {

    private boolean destructible;
    private double hp = 1;

    @XmlElement(name = "destructible")
    public boolean isDestructible() {
        return destructible;
    }

    @XmlElement(name = "hp", defaultValue = "1")
    public double getHp() {
        return hp;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "SceneElementData{" +
                super.toString() +
                ", destructible=" + destructible +
                ", hp=" + hp +
                '}';
    }
}
