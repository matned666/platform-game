package eu.mrndesign.matned.client.model.game.object.element.character;

import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.ActionData;
import eu.mrndesign.matned.client.model.game.object.data.model.CharacterData;
import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;
import eu.mrndesign.matned.client.model.game.object.element.BaseElement;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.element.item.ItemImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CharacterImpl extends BaseElement implements Character {
    protected static final Logger logger = Logger.getLogger(CharacterImpl.class.getName());

    private final CharacterData characterData;

    private final List<Element> equipment = new ArrayList<>();

    public CharacterImpl(Game game, CharacterData characterData) {
        super(game, "Character", characterData);
        this.characterData = characterData;
        initEquipment();
    }

    private void initEquipment() {
        List<ItemData> itemDataList = characterData.getItems();
        itemDataList.forEach(itemData -> equipment.add(new ItemImpl(game, itemData)));
    }

    @Override
    public List<Element> getEquipment() {
        return equipment;
    }

    @Override
    public CharacterData getCharacterData() {
        return characterData;
    }

    @Override
    public List<ActionData> getActions() {
        return characterData.getActions();
    }


}
