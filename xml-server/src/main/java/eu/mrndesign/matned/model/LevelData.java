package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "level")
public class LevelData implements Serializable {

    private BaseImageData background;
    private CharacterData hero;
    private double width;
    private double height;
    private final List<SceneElementData> grounds = new ArrayList<>();
    private final List<ItemData> items = new ArrayList<>();
    private final List<CharacterData> characters = new ArrayList<>();

    @XmlElement
    public BaseImageData getBackground() {
        return background;
    }

    @XmlElement(name = "hero")
    public CharacterData getHero() {
        return hero;
    }

    @XmlElementWrapper(name = "grounds")
    @XmlElement(name = "ground")
    public List<SceneElementData> getGrounds() {
        return grounds;
    }

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<ItemData> getItems() {
        return items;
    }

    @XmlElementWrapper(name = "characters")
    @XmlElement(name = "character")
    public List<CharacterData> getCharacters() {
        return characters;
    }

    @XmlElement(name = "width")
    public double getWidth() {
        return width;
    }

    @XmlElement(name = "height")
    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBackground(BaseImageData background) {
        this.background = background;
    }

    public void setHero(CharacterData hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "LevelData{" +
                "background=" + background +
                ", hero=" + hero +
                ", grounds=" + grounds +
                ", items=" + items +
                ", characters=" + characters +
                '}';
    }
}
