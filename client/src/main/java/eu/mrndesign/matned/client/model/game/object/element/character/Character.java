package eu.mrndesign.matned.client.model.game.object.element.character;

import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.data.model.CharacterData;

import java.util.List;

public interface Character {

    List<Element> getEquipment();

    CharacterData getCharacterData();
}
