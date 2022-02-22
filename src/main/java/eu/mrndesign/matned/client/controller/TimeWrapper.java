package eu.mrndesign.matned.client.controller;

import static eu.mrndesign.matned.client.controller.Constants.PERIOD_MILLIS;

import com.google.gwt.user.client.Timer;

/**
 * Prosty singleton kolekcjonujący dane dla całego programu. Dzięki temu mam do
 * nich bezpośredni dostęp z każdej klasy.
 */

public class TimeWrapper {

    private static TimeWrapper instance;

    public static TimeWrapper getInstance() {
        if (instance == null) {
            synchronized (TimeWrapper.class) {
                if (instance == null) {
                    instance = new TimeWrapper();
                }
                instance.resetFrame();
            }
        }
        return instance;
    }

    private long frameNo;
    private Timer timer;

    private TimeWrapper() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }
    }

    public void runTimer() {
        timer.run();
    }

    public void stopTimer() {
        timer.cancel();
    }

    public void resetFrame() {
        frameNo = 0;
    }

    public void nextFrame() {
        frameNo++;
    }

    public long getFrameNo() {
        return frameNo;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        if (frameNo == 0) {
            this.timer = timer;
            timer.scheduleRepeating(PERIOD_MILLIS);
        }
    }
}