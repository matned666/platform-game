package eu.mrndesign.matned.client.model.game.object.element.item;

import eu.mrndesign.matned.client.model.game.object.data.model.ItemData;

public interface Item {
    boolean isEquipped();

    void setEquipped(boolean equipped);

    ItemData getItemData();
}
