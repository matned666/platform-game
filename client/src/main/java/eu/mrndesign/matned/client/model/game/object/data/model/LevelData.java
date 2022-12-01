package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LevelData {
    private static final Logger logger = Logger.getLogger(LevelData.class.getName());

    public static LevelData parse(JSONObject level) {
        LevelData levelData = new LevelData();
        levelData.setWidthSquares((int) level.get("widthSquares").isNumber().doubleValue());
        levelData.setHeightSquares((int) level.get("heightSquares").isNumber().doubleValue());
        levelData.setBackground(BaseImageData.parseBase(level.get("background").isObject()));
        levelData.setHero(CharacterData.parse(level.get("hero").isObject()));
        JSONArray items = level.get("items").isArray();
        for (int i = 0; i < items.size(); i++) {
            levelData.getItems().add(ItemData.parse(items.get(i).isObject()));
        }
        JSONArray characters = level.get("characters").isArray();
        for (int i = 0; i < characters.size(); i++) {
            levelData.getCharacters().add(CharacterData.parse(characters.get(i).isObject()));
        }
        JSONArray grounds = level.get("grounds").isArray();
        for (int i = 0; i < grounds.size(); i++) {
            levelData.getGrounds().add(SceneElementData.parse(grounds.get(i).isObject()));
        }
        return levelData;
    }

    private BaseImageData background;
    private CharacterData hero;
    private int widthSquares;
    private int heightSquares;
    private final List<SceneElementData> grounds = new ArrayList<>();
    private final List<ItemData> items = new ArrayList<>();
    private final List<CharacterData> characters = new ArrayList<>();

    public BaseImageData getBackground() {
        return background;
    }

    public CharacterData getHero() {
        return hero;
    }

    public List<SceneElementData> getGrounds() {
        return grounds;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public List<CharacterData> getCharacters() {
        return characters;
    }

    public int getWidthSquares() {
        return widthSquares;
    }

    public int getHeightSquares() {
        return heightSquares;
    }

    public void setWidthSquares(int widthSquares) {
        this.widthSquares = widthSquares;
    }

    public void setHeightSquares(int heightSquares) {
        this.heightSquares = heightSquares;
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
