package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class BaseImageData implements Serializable {

    private String name = "";
    private double startXPos;
    private double startYPos;
    private double width;
    private double height;
    private double directionX;
    private double directionY = -1;
    private final List<ActionData> actions = new ArrayList<>();


    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElementWrapper(name = "actions")
    @XmlElement(name = "action")
    public List<ActionData> getActions() {
        return actions;
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
    public double getStartXPos() {
        return startXPos;
    }

    @XmlElement(name = "startYPos")
    public double getStartYPos() {
        return startYPos;
    }

    @XmlElement(name = "vectorX", defaultValue = "0")
    public double getDirectionX() {
        return directionX;
    }

    @XmlElement(name = "vectorY", defaultValue = "-1")
    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
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

    public void setStartXPos(double startXPos) {
        this.startXPos = startXPos;
    }

    public void setStartYPos(double startYPos) {
        this.startYPos = startYPos;
    }

    @Override
    public String toString() {
        return "BaseImageData{" +
                "name='" + name + '\'' +
                ", actions=" + actions +
                ", width=" + width +
                ", height=" + height +
                ", startXPos=" + startXPos +
                ", startYPos=" + startYPos +
                ", directionX=" + directionX +
                ", directionY=" + directionY +
                '}';
    }
}
