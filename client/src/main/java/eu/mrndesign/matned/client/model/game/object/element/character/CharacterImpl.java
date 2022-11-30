package eu.mrndesign.matned.client.model.game.object.element.character;

import eu.mrndesign.matned.client.model.game.object.Game;
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
import eu.mrndesign.matned.client.model.tool.phisic.GravityImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CharacterImpl extends BaseElement implements Character {
    protected static final Logger logger = Logger.getLogger(CharacterImpl.class.getName());

    private final FrameHolder frameHolder;
    private final CharacterData characterData;

    private final List<Element> equipment = new ArrayList<>();

    private double actualSpeed;


    public CharacterImpl(Game game, CharacterData characterData) {
        super(game, "Character");
        this.characterData = characterData;
        this.frameHolder = FrameHolderFactory.generate(characterData.getName());
        bounds = Bounds2D.generate(characterData);
        initEquipment();
    }

    private void initEquipment() {
        List<ItemData> itemDataList = characterData.getItems();
        itemDataList.forEach(itemData -> equipment.add(new ItemImpl(game, itemData)));
    }

    public void refresh() {
        gravity.calculate(this, actualSpeed);
    }

    public void move(Vector2D v, double initSpeed) {
        actualSpeed = initSpeed;
        logger.info(getBounds().getCenter().toString());
//        if (Math.signum(v.getX()) != Math.signum(bounds.getVector().getX())) {
//            bounds.getVector().setX(bounds.getVector().getX() * -1);
//            return;
//        }
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
