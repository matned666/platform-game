package eu.mrndesign.matned.client.model.tools;

import eu.mrndesign.matned.client.model.game.object.element.MoveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holds all animations frame urls <br>
 * Initialized with {@link FrameHolderBuilder}
 */
public class FrameHolder {

    private final List<String> framesStand;
    private final List<String> framesWalk;
    private final List<String> framesRun;
    private final List<String> framesJump;
    private final List<String> framesSneak;

    private FrameHolder(FrameHolderBuilder builder){
        framesStand = builder.framesStand;
        framesWalk = builder.framesWalk;
        framesRun = builder.framesRun;
        framesJump = builder.framesJump;
        framesSneak = builder.framesSneak;
    }

    public List<String> getFrames(MoveType moveType) {
        switch (moveType){
            case WALK: return framesWalk;
            case RUN: return framesRun;
            case JUMP: return framesJump;
            case SNEAK: return framesSneak;
        }
        return framesStand;
    }

    public static class FrameHolderBuilder {

        private final List<String> framesStand = new ArrayList<>();
        private List<String> framesWalk;
        private List<String> framesRun;
        private List<String> framesJump;
        private List<String> framesSneak;

        public FrameHolderBuilder(String mainFirstFrame, String ... nextAnimationFrames) {
            framesStand.add(mainFirstFrame);
            framesStand.addAll(Arrays.asList(nextAnimationFrames));
        }

        /**
         * @param frames can be empty
         * @return List with walk animation frame urls
         */
        public FrameHolderBuilder walk(String ... frames) {
            framesWalk = new ArrayList<>(Arrays.asList(frames));
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with run animation frame urls
         */
        public FrameHolderBuilder run(String ... frames) {
            framesRun = new ArrayList<>(Arrays.asList(frames));
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with jump animation frame urls
         */
        public FrameHolderBuilder jump(String ... frames) {
            framesJump = new ArrayList<>(Arrays.asList(frames));
            return this;
        }

        /**
         * @param frames can be empty
         * @return List with sneak animation frame urls
         */
        public FrameHolderBuilder sneak(String ... frames) {
            framesSneak = new ArrayList<>(Arrays.asList(frames));
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
            if (framesWalk == null) framesWalk = framesStand;
            if (framesRun == null) framesRun = framesWalk;
            if (framesJump == null) framesJump = framesStand;
            if (framesSneak == null) framesSneak = framesWalk;
        }

    }

}
