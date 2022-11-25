package eu.mrndesign.matned.client.model.game.object;

import eu.mrndesign.matned.client.model.tools.Gravity;
import eu.mrndesign.matned.client.model.tools.GravityImpl;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Game {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private final Map<String, GameElement> mapIdToGameElement = new HashMap<>();

    private final Map<String, GameElement> mapIdToBullet = new HashMap<>();
    private final Map<String, GameElement> mapIdToEnemy = new HashMap<>();
    private final Map<String, GameElement> mapIdToBackgroundElement = new HashMap<>();

    private final List<String> removedGameElements = new LinkedList<>();

    private final CanvasModel canvasModel;

    private GameElement hero;
    private final Gravity gravity;
    private long activatedFrameNo = 0;

    private final Subject<Boolean> refreshSubject = PublishSubject.create();
    private final Subject<Boolean> bulletsRefreshSubject = PublishSubject.create();
    private final Subject<Boolean> removedSubject = PublishSubject.create();
    private final Subject<GameElement> blowSubject = PublishSubject.create();

    public Game(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
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
                    removeElement(gameElement.id);
                }
            });
            return next;
        }).subscribe();
    }

    private void initBulletRefreshSubscriptionSubscription() {
        bulletsRefreshSubject.map(onNext -> {
            mapIdToBullet.values().forEach(bullet ->
                    mapIdToEnemy.values().forEach(rock -> {
                        if (rock.bounds.touchedBy(bullet.bounds)) {
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

    public boolean isOnBackgroundElement(GameElement gameElement){
        return mapIdToBackgroundElement.values().stream()
                .anyMatch(backgroundElement -> gameElement.getBounds().isOn(backgroundElement.getBounds()));
    }


    public void refresh() {
        refreshSubject.onNext(true);
        bulletsRefreshSubject.onNext(true);
        removedSubject.onNext(true);
    }

    private void addHero() {
        mapIdToGameElement.put(hero.id, hero);
    }

    public void removeElement(String id) {
        removedGameElements.add(id);
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
}
