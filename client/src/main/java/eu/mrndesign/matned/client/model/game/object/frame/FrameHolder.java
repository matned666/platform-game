package eu.mrndesign.matned.client.model.game.object.frame;

import eu.mrndesign.matned.client.model.game.object.element.character.CharacterImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Holds all animations frame urls <br>
 * Per {@link CharacterImpl} object
 * Initialized with {@link FrameHolderBuilder}
 */
public class FrameHolder {

    private final List<String> framesStand;
    private final List<String> framesWalk;
    private final List<String> framesRun;
    private final List<String> framesJump;
    private final List<String> framesSneak;
    private final List<String> framesAttack;
    private final List<String> framesDeath;

    private FrameHolder(FrameHolderBuilder builder){
        framesStand = builder.framesStand;
        framesWalk = builder.framesWalk;
        framesRun = builder.framesRun;
        framesJump = builder.framesJump;
        framesSneak = builder.framesSneak;
        framesAttack = builder.framesAttack;
        framesDeath = builder.framesDeath;
    }

    public List<String> getFrames(MoveType moveType) {
        switch (moveType){
            case WALK: return framesWalk;
            case RUN: return framesRun;
            case JUMP: return framesJump;
            case SNEAK: return framesSneak;
            case ATTACK: return framesAttack;
            case DEATH: return framesDeath;
        }
        return framesStand;
    }

    public static class FrameHolderBuilder {

        private final List<String> framesStand = new ArrayList<>();
        private List<String> framesWalk;
        private List<String> framesRun;
        private List<String> framesJump;
        private List<String> framesSneak;
        private List<String> framesAttack;
        private List<String> framesDeath;

        public FrameHolderBuilder(String mainFirstFrame, String ... nextAnimationFrames) {
            framesStand.add(mainFirstFrame);
            framesStand.addAll(Arrays.asList(nextAnimationFrames));
        }

        /**
         * @param frames can be empty
         * @return List with walk animation frame urls
         */
        public FrameHolderBuilder walk(String ... frames) {
            framesWalk = Arrays.asList(frames);
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with run animation frame urls
         */
        public FrameHolderBuilder run(String ... frames) {
            framesRun = Arrays.asList(frames);
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with jump animation frame urls
         */
        public FrameHolderBuilder jump(String ... frames) {
            framesJump = Arrays.asList(frames);
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with sneak animation frame urls
         */
        public FrameHolderBuilder sneak(String ... frames) {
            framesSneak = Arrays.asList(frames);
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with sneak animation frame urls
         */
        public FrameHolderBuilder attack(String ... frames) {
            framesAttack = Arrays.asList(frames);
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with death animation frame urls
         */
        public FrameHolderBuilder death(String ... frames) {
            framesDeath = Arrays.asList(frames);
            return this;
        }

        /**
         * Inits Lists if not initialized <br>
         * @return new {@link FrameHolder}
         */
        public FrameHolder build(){
            initListsIfNeeded();
            return new FrameHolder(this);
        }

        private void initListsIfNeeded() {
            if (framesWalk == null || framesWalk.isEmpty()) framesWalk = framesStand;
            if (framesRun == null || framesRun.isEmpty()) framesRun = framesWalk;
            if (framesJump == null || framesJump.isEmpty()) framesJump = framesStand;
            if (framesSneak == null || framesSneak.isEmpty()) framesSneak = framesWalk;
            if (framesAttack == null || framesAttack.isEmpty()) framesAttack = framesStand;
            if (framesDeath == null || framesDeath.isEmpty()) framesAttack = Collections.emptyList();
        }

    }



}
