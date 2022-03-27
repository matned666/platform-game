package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.controller.TimeWrapper;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Game {

    private final Map<String, GameElement> mapIdToGameElement = new HashMap<>();

    private final Map<String, GameElement> mapIdToBullet = new HashMap<>();
    private final Map<String, GameElement> mapIdToRock = new HashMap<>();
    private final List<String> removedGameElements = new LinkedList<>();

    private final CanvasModel canvasModel;

    private GameElement hero;
    private long activatedFrameNo = 0;

    private boolean newEnemy = false;

    private final Subject<Boolean> refreshSubject = PublishSubject.create();
    private final Subject<Boolean> bulletsRefreshSubject = PublishSubject.create();
    private final Subject<Boolean> removedSubject = PublishSubject.create();
    private final Subject<Boolean> newEnemySubject = PublishSubject.create();
    private final Subject<Boolean> newBulletSubject = PublishSubject.create();
    private final Subject<GameElement> blowSubject = PublishSubject.create();

    public Game(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
        initRefreshSubscriptionSubscription();
        initBulletRefreshSubscriptionSubscription();
        initRemoveSubscriptionSubscription();
        initEnemySubscription();
        initBulletSubscription();
        initBlowSubscription();
        initGameElements();
    }

    private void initRefreshSubscriptionSubscription() {
        refreshSubject.map(next -> {
            mapIdToGameElement.forEach((key, gameElement) -> {
                gameElement.refresh();
                if ((gameElement.isToRemove())) {
                    removeElement(gameElement.id);
                    if (gameElement.getType() == GameElementType.ROCK) {
                        newEnemy = true;
                    }
                }
            });
            return next;
        }).subscribe();
    }

    private void initBulletRefreshSubscriptionSubscription() {
        bulletsRefreshSubject.map(onNext -> {
            mapIdToBullet.values().forEach(bullet ->
                    mapIdToRock.values().forEach(rock -> {
                        if (rock.bounds.touchedBy(bullet.bounds)) {
                            bullet.setToRemove();
                            rock.setToRemove();
                            mapIdToRock.remove(rock.getId());
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
                    blowSubject.onNext(mapIdToGameElement.get(key));
                }
            });
            return onNext;
        }).subscribe();
    }

    private void initEnemySubscription() {
        newEnemySubject.map(selected -> {
            if (selected) {
                addNewEnemy();
            }
            newEnemy = false;
            return selected;
        }).subscribe();
    }

    private void initBulletSubscription() {
        newBulletSubject.map(fire -> {
            if (fire) fireBullet();
            return fire;
        }).subscribe();
    }

    private void initBlowSubscription() {
        blowSubject.map(blownElement -> {
            blow(blownElement);
            return blownElement;
        }).subscribe();
    }

    private void initGameElements() {
        addHero();
        newEnemySubject.onNext(true);
    }


    public void refresh() {
        refreshSubject.onNext(true);
        bulletsRefreshSubject.onNext(true);
        removedSubject.onNext(true);
        newEnemySubject.onNext(newEnemy);
    }

    private void addHero() {
        hero = GameElementsFactory.hero(canvasModel);
        mapIdToGameElement.put(hero.id, hero);
    }

    public void addNewEnemy() {
        GameElement rock = GameElementsFactory.enemy( hero, canvasModel, 10, 10); // TODO temporary hp and hit
        mapIdToGameElement.put(rock.id, rock);
        mapIdToRock.put(rock.getId(), rock);
    }

    void fireBullet() {
        if (TimeWrapper.getInstance().getFrameNo() - activatedFrameNo > 20) {
            GameElement bullet = GameElementsFactory.bullet(hero.getVector(), hero.getBounds(), canvasModel);
            mapIdToGameElement.put(bullet.getId(), bullet);
            mapIdToBullet.put(bullet.getId(), bullet);
            activatedFrameNo = TimeWrapper.getInstance().getFrameNo();
        }
    }


    public void removeElement(String id) {
        removedGameElements.add(id);
    }

    private void blow(GameElement ge) {
        GameElement blow = GameElementsFactory.blow(ge.getVector(), ge.getBounds(), canvasModel);
        mapIdToGameElement.put(blow.id, blow);
    }

    public void clearRemoved() {
        removedGameElements.forEach(mapIdToGameElement::remove);
    }

    public Map<String, GameElement> getMapIdToGameElement() {
        return mapIdToGameElement;
    }

    public List<String> getRemovedGameElements() {
        return removedGameElements;
    }

    public void fire() {
        newBulletSubject.onNext(true);
    }
}
