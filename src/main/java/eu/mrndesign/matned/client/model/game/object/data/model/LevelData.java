package eu.mrndesign.matned.client.model.game.object.data.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "level")
public class LevelData {

    private BaseImageData background;
    private CharacterData hero;
    private final List<GroundObjectData> grounds = new ArrayList<>();
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
    public List<GroundObjectData> getGrounds() {
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
