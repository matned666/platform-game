package eu.mrndesign.matned.client.model.game.object.element.character;

import eu.mrndesign.matned.client.model.game.object.element.BaseElement;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.data.model.CharacterData;
import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;
import eu.mrndesign.matned.client.model.game.object.element.item.ItemImpl;
import eu.mrndesign.matned.client.model.game.object.frame.MoveType;
import eu.mrndesign.matned.client.model.game.object.frame.FrameHolder;
import eu.mrndesign.matned.client.model.game.object.frame.FrameHolderFactory;
import eu.mrndesign.matned.client.model.tool.math.Bounds2D;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.model.tool.phisic.Gravity;

import java.util.ArrayList;
import java.util.List;

public class CharacterImpl extends BaseElement implements Character {

    private final Gravity gravity;
    private final FrameHolder frameHolder;
    private final CharacterData characterData;

    private final List<Element> equipment = new ArrayList<>();

    private double actualSpeed;

    public CharacterImpl(Gravity gravity, CharacterData characterData) {
        super("Character");
        this.gravity = gravity;
        this.characterData = characterData;
        this.frameHolder = FrameHolderFactory.generate(characterData.getName());
        bounds = Bounds2D.generate(characterData);
        initEquipment();
    }

    private void initEquipment() {
        List<ItemData> itemDataList = characterData.getItems();
        itemDataList.forEach(itemData -> equipment.add(new ItemImpl(itemData)));
    }

    public void refresh() {
        gravity.calculate(this, actualSpeed);
    }

    public void move(Vector2D v, double initSpeed) {
        actualSpeed = initSpeed;
        if (Math.signum(v.getX()) != Math.signum(bounds.getVector().getX())) {
            bounds.getVector().setX(bounds.getVector().getX() * -1);
            return;
        }
        bounds.getCenter().move(v, initSpeed);
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
    public List<String> getFrames(MoveType moveType) {
        return frameHolder.getFrames(moveType);
    }


}
