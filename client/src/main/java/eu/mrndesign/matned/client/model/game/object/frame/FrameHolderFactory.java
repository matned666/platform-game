package eu.mrndesign.matned.client.model.game.object.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FrameHolderFactory {
    private final Logger logger = Logger.getLogger(getClass().getName());

//    TODO sorting
    public static FrameHolder generate(String name) {
        List<String> listOfImageFiles = getListOfImgFiles().stream()
                .filter(f -> f.startsWith(name))
                .collect(Collectors.toList());
        String mainFile = "img/"+name+"-stand1.png";
        return new FrameHolder.FrameHolderBuilder(mainFile,
                listOfImageFiles.stream()
                        .filter(f -> f.toLowerCase().contains("stand") && !f.equals(mainFile))
                        .toArray(String[]::new))
                .walk(listOfImageFiles.stream()
                        .filter(f -> f.toLowerCase().contains("walk"))
                        .toArray(String[]::new))
                .sneak(listOfImageFiles.stream()
                        .filter(f->f.toLowerCase().contains("sneak"))
                        .toArray(String[]::new))
                .attack(listOfImageFiles.stream()
                        .filter(f->f.toLowerCase().contains("attack"))
                        .toArray(String[]::new))
                .run(listOfImageFiles.stream()
                        .filter(f->f.toLowerCase().contains("run"))
                        .toArray(String[]::new))
                .jump(listOfImageFiles.stream()
                        .filter(f->f.toLowerCase().contains("jump"))
                        .toArray(String[]::new))
                .death(listOfImageFiles.stream()
                        .filter(f->f.toLowerCase().contains("death"))
                        .toArray(String[]::new))
                .build();
    }

    private static List<String> getListOfImgFiles() {
        List<String> result = new ArrayList<>();

        return result;
    }
}
