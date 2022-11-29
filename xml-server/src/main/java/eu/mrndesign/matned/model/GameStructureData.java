package eu.mrndesign.matned.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "gameStructure")
public class GameStructureData implements Serializable {

    private final List<Integer> levels = new ArrayList<>();

    @XmlElementWrapper(name = "levels")
    @XmlElement(name = "id")
    public List<Integer> getLevels() {
        return levels;
    }

}
