package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.Model;
import eu.mrndesign.matned.client.model.game.object.data.model.LevelData;
import eu.mrndesign.matned.client.model.game.object.element.ElementImpl;
import eu.mrndesign.matned.client.model.tool.Gravity;
import eu.mrndesign.matned.client.model.tool.GravityImpl;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Game {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private final Map<String, ElementImpl> mapIdToGameElement = new HashMap<>();

    private final Map<String, ElementImpl> mapIdToBullet = new HashMap<>();
    private final Map<String, ElementImpl> mapIdToEnemy = new HashMap<>();
    private final Map<String, ElementImpl> mapIdToBackgroundElement = new HashMap<>();

    private final List<String> removedGameElements = new LinkedList<>();

    private final CanvasModel canvasModel;

    private ElementImpl hero;
    private final Gravity gravity;
    private long activatedFrameNo = 0;

    private final Subject<Boolean> refreshSubject = PublishSubject.create();
    private final Subject<Boolean> bulletsRefreshSubject = PublishSubject.create();
    private final Subject<Boolean> removedSubject = PublishSubject.create();
    private final Subject<ElementImpl> blowSubject = PublishSubject.create();

    private final Model model;
    private LevelData levelData;

    public Game(CanvasModel canvasModel, Model model) {
        this.canvasModel = canvasModel;
        this.model = model;
        gravity = new GravityImpl(this);
        initRefreshSubscriptionSubscription();
        initBulletRefreshSubscriptionSubscription();
        initRemoveSubscriptionSubscription();
        initGameElements();
    }

    private void initRefreshSubscriptionSubscription() {
        refreshSubject.map(next -> {
            mapIdToGameElement.forEach((key, gameElement) -> {
                gravity.calculate(gameElement);
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
                    blowSubject.onNext(mapIdToGameElement.get(key));
                }
            });
            return onNext;
        }).subscribe();
    }

    private void initGameElements() {
        addHero();
    }

    public boolean isOnBackgroundElement(ElementImpl element){
        return mapIdToBackgroundElement.values().stream()
                .anyMatch(backgroundElement -> element.getBounds().isOn(backgroundElement.getBounds()));
    }


    public void refresh() {
        refreshSubject.onNext(true);
        bulletsRefreshSubject.onNext(true);
        removedSubject.onNext(true);
    }

    private void addHero() {
        mapIdToGameElement.put(hero.getId(), hero);
    }

    public void removeElement(String id) {
        removedGameElements.add(id);
    }

    public void clearRemoved() {
        removedGameElements.forEach(mapIdToGameElement::remove);
    }

    public Map<String, ElementImpl> getMapIdToGameElement() {
        return mapIdToGameElement;
    }

    public List<String> getRemovedGameElements() {
        return removedGameElements;
    }

    public void fire() {
//        TODO
        logger.info("FIRE");
    }

    public void move(int direction, boolean isThrottle) {
//        TODO
        logger.info("Move " + direction + " t:" +isThrottle);
    }

    public void jump(boolean isThrottle) {
//        TODO
        logger.info("Jump " + " t:" +isThrottle);
    }

    public Gravity getGravity() {
        return gravity;
    }

    public String getBackground() {
        return "";
    }

}
