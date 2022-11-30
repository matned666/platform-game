package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.Controller;
import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.model.game.object.data.model.CharacterData;
import eu.mrndesign.matned.client.model.game.object.data.model.*;
import eu.mrndesign.matned.client.model.game.object.element.Element;
import eu.mrndesign.matned.client.model.game.object.element.background.SceneElementImpl;
import eu.mrndesign.matned.client.model.game.object.element.character.CharacterImpl;
import eu.mrndesign.matned.client.model.game.object.element.item.ItemImpl;
import eu.mrndesign.matned.client.model.request.HttpRequester;
import eu.mrndesign.matned.client.model.request.Requester;
import eu.mrndesign.matned.client.model.tool.math.Vector2D;
import eu.mrndesign.matned.client.view.screencontent.game.GameContent;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Game {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private final Map<String, Element> mapIdToElement = new HashMap<>();

    private final Map<String, Element> mapIdToBullet = new HashMap<>();
    private final Map<String, Element> mapIdToEnemy = new HashMap<>();
    private final Map<String, Element> mapIdToSceneElement = new HashMap<>();

    private final List<String> removedGameElements = new LinkedList<>();

    private final CanvasModel canvasModel;
    private final Requester requester;

    private Element hero;

    private final Subject<Boolean> refreshSubject = PublishSubject.create();
    private final Subject<Boolean> bulletsRefreshSubject = PublishSubject.create();
    private final Subject<Boolean> removedSubject = PublishSubject.create();
    private final Subject<Element> blowSubject = PublishSubject.create();

    private final Controller controller;
    private LevelData levelData;

    public Game(CanvasModel canvasModel, Controller controller) {
        this.canvasModel = canvasModel;
        this.controller = controller;
        requester = new HttpRequester(this);
        initDataElements();
        initRefreshSubscriptionSubscription();
        initBulletRefreshSubscriptionSubscription();
        initRemoveSubscriptionSubscription();
    }

    private void initDataElements() {
        requester.requestLevelStructure("level1");
    }

    public void onGameStructureReceive(GameStructureData gameStructureData) {
//        TODO support for more levels - set LevelData field to List<LevelData>
    }

    public void onLevelDataReceived(LevelData levelData) {
        this.levelData = levelData;
        GameContent.getInstance(controller).initCanvas();
        updateGameElements();
    }

    private void initRefreshSubscriptionSubscription() {
        refreshSubject.map(next -> {
            mapIdToElement.forEach((key, gameElement) -> {
                gameElement.refresh();
                if ((gameElement.isToRemove())) {
                    removeElement(gameElement.getId());
                }
            });
            return next;
        }).subscribe();
    }

    private void initBulletRefreshSubscriptionSubscription() {
        bulletsRefreshSubject.map(onNext -> {
            mapIdToBullet.values().forEach(bullet ->
                    mapIdToEnemy.values().forEach(rock -> {
                        if (rock.getBounds().touchedBy(bullet.getBounds())) {
                            bullet.setToRemove();
                            rock.setToRemove();
                            mapIdToEnemy.remove(rock.getId());
                        }
                    })
            );
            return onNext;
        }).subscribe();
    }

    private void initRemoveSubscriptionSubscription() {
        removedSubject.map(onNext -> {
            removedGameElements.forEach(key -> {
                if (mapIdToBullet.containsKey(key)) {
                    mapIdToBullet.remove(key);
                    blowSubject.onNext(mapIdToElement.get(key));
                }
            });
            return onNext;
        }).subscribe();
    }

    private void updateGameElements() {
        updateHero();
        updateGrounds();
        updateItems();
    }

    private void updateHero() {
        CharacterData heroData = levelData.getHero();
        hero = new CharacterImpl(this, heroData);
        mapIdToElement.put(hero.getId(), hero);
    }

    private void updateGrounds() {
        List<SceneElementData> sceneElementDataList = levelData.getGrounds();
        sceneElementDataList.forEach(sceneElementData -> {
            Element sceneElement = new SceneElementImpl(this, sceneElementData);
            mapIdToSceneElement.put(sceneElement.getId(), sceneElement);
            mapIdToElement.put(sceneElement.getId(), sceneElement);
        });
    }

    private void updateItems() {
        List<ItemData> itemDataList = levelData.getItems();
        itemDataList.forEach(itemData -> {
            Element item = new ItemImpl(this, itemData);
            mapIdToElement.put(item.getId(), item);
        });
    }

    public boolean isOnBackgroundElement(Element element){
        return mapIdToSceneElement.values().stream()
                .anyMatch(backgroundElement -> element.getBounds().isOn(backgroundElement.getBounds()));
    }


    public void refresh() {
        refreshSubject.onNext(true);
        bulletsRefreshSubject.onNext(true);
        removedSubject.onNext(true);
    }

    public void removeElement(String id) {
        removedGameElements.add(id);
    }

    public void clearRemoved() {
        removedGameElements.forEach(mapIdToElement::remove);
    }

    public Map<String, Element> getMapIdToElement() {
        return mapIdToElement;
    }

    public List<String> getRemovedGameElements() {
        return removedGameElements;
    }

    public synchronized void action() {
        actualVector = hero.getBounds().getVector();
        hero.move(actualVector, 20);

    }

    private Vector2D actualVector = new Vector2D(1,0);
    public synchronized void move(Vector2D vector, double speed) {
        hero.move(vector, speed);
    }

    public void move(double speed) {
        hero.move(hero.getBounds().getVector(), speed);
    }

    public synchronized void setDirection(int x, int y) {
        hero.setDirection(x,y);
        actualVector = hero.getBounds().getVector();
    }

    public String getBackground() {
        return "img/"+levelData.getBackground().getName()+".jpg";
    }
}
