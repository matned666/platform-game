package eu.mrndesign.matned.client.model.request;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import eu.mrndesign.matned.client.model.game.object.Game;
import eu.mrndesign.matned.client.model.game.object.data.model.GameStructureData;
import eu.mrndesign.matned.client.model.game.object.data.model.LevelData;

import java.util.logging.Logger;

public class HttpRequester implements Requester {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private final Game game;

    public HttpRequester(Game game) {
        this.game = game;
    }

    @Override
    public void requestGameStructure(String fileName) {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, "http://localhost:8080/game/" + fileName +                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ".xml");
        requestBuilder.setHeader("Content-Type", "application/json; charset=utf8");
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Access-Control-Allow-Origin", "*");
        try {
            requestBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    JSONValue value = JSONParser.parseStrict(response.getText());
                    JSONObject obj = value.isObject();
                    GameStructureData gameStructureData = GameStructureData.parse(obj);
                    game.onGameStructureReceive(gameStructureData);
                }

                @Override
                public void onError(Request request, Throwable exception) {
//               TODO     model.onServerError("Get all candidates error");
                }
            });
        } catch (RequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void requestLevelStructure(String fileName) {
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, "http://localhost:8080/level/"+fileName+".xml");
        requestBuilder.setHeader("Content-Type", "application/json; charset=utf8");
        requestBuilder.setHeader("Accept", "application/json");
        requestBuilder.setHeader("Access-Control-Allow-Origin", "*");
        requestBuilder.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authortization");
        requestBuilder.setHeader("Acces-Control-Allow-Methods", "GET, POST, PATCH, DELETE");
        try {
            logger.info("Sending request");
            requestBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    JSONValue value = JSONParser.parseStrict(response.getText());
                    JSONObject level = value.isObject();
                    logger.info("Request received");
                    LevelData levelData = LevelData.parse(level);
                    game.onLevelRequestCallBack(levelData);
                }

                @Override
                public void onError(Request request, Throwable exception) {
//              TODO      model.onServerError("Get all candidates error");
                }
            });
        } catch (RequestException e) {
            throw new RuntimeException(e);
        }
    }

}
