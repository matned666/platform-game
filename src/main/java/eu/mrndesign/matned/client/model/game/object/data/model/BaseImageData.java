package eu.mrndesign.matned.client.model.game.object.data.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseImageData {

    private String name = "";
    private double width;
    private double height;
    private int startXPos;
    private int startYPos;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "width")
    public double getWidth() {
        return width;
    }

    @XmlElement(name = "height")
    public double getHeight() {
        return height;
    }

    @XmlElement(name = "startXPos")
    public int getStartXPos() {
        return startXPos;
    }

    @XmlElement(name = "startYPos")
    public int getStartYPos() {
        return startYPos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setStartXPos(int startXPos) {
        this.startXPos = startXPos;
    }

    public void setStartYPos(int startYPos) {
        this.startYPos = startYPos;
    }

    @Override
    public String toString() {
        return "BaseImageData{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", startXPos=" + startXPos +
                ", startYPos=" + startYPos +
                '}';
    }
}
