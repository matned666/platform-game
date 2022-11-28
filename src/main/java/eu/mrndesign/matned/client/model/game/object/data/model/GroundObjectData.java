package eu.mrndesign.matned.client.model.game.object.data.model;

import javax.xml.bind.annotation.XmlElement;

public class GroundObjectData extends BaseImageData{

    private boolean destructible;
    private double hp = 1;
    private String horizontalPos = "CENTER";
    private String verticalPos = "CENTER";

    @XmlElement(name = "destructible")
    public boolean isDestructible() {
        return destructible;
    }

    @XmlElement(name = "hp", defaultValue = "1")
    public double getHp() {
        return hp;
    }

    @XmlElement(name = "hPos", defaultValue = "CENTER")
    public String getHorizontalPos() {
        return horizontalPos;
    }

    @XmlElement(name = "vPos", defaultValue = "CENTER")
    public String getVerticalPos() {
        return verticalPos;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setHorizontalPos(String horizontalPos) {
        this.horizontalPos = horizontalPos;
    }

    public void setVerticalPos(String verticalPos) {
        this.verticalPos = verticalPos;
    }

    @Override
    public String toString() {
        return "GroundObjectData{" +
                super.toString() +
                ", destructible=" + destructible +
                ", hp=" + hp +
                ", horizontalPos='" + horizontalPos + '\'' +
                ", verticalPos='" + verticalPos + '\'' +
                '}';
    }
}
