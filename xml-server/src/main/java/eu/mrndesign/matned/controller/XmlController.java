package eu.mrndesign.matned.controller;

import eu.mrndesign.matned.model.GameStructureData;
import eu.mrndesign.matned.model.LevelData;
import eu.mrndesign.matned.service.XmlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {

    private final XmlService xmlService;

    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @GetMapping("/game/{fileName}")
    public GameStructureData getGameStructureData(@PathVariable String fileName) {
        return xmlService.getGame(fileName);
    }

    @GetMapping("/level/{fileName}")
    public LevelData getLevelData(@PathVariable String fileName) {
        LevelData level = xmlService.getLevel(fileName);
        return level;
    }


}
