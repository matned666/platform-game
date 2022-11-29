package eu.mrndesign.matned.client.model.game.object.data.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GameStructureData {

    public static GameStructureData generateGameStructureData(JSONObject game) {
        GameStructureData gameStructureData = new GameStructureData();
        JSONArray lvls = game.get("levels").isArray();
        for (int i = 0; i < lvls.size(); i++) {
            gameStructureData.getLevels().add((int) lvls.get(i).isNumber().doubleValue());
        }
        return gameStructureData;
    }


    private final List<Integer> levels = new ArrayList<>();

    public List<Integer> getLevels() {
        return levels;
    }

}
