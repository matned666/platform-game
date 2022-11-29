package eu.mrndesign.matned.service;

import eu.mrndesign.matned.model.GameStructureData;
import eu.mrndesign.matned.model.LevelData;
import eu.mrndesign.matned.util.XmlWorker;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class XmlService {

    private final XmlWorker<GameStructureData> gameXmlWorker = new XmlWorker<>(GameStructureData.class);
    private final XmlWorker<LevelData> levelXmlWorker = new XmlWorker<>(LevelData.class);

    private final ResourceLoader resourceLoader;

    public XmlService(ResourceLoader resourceLoader) throws JAXBException {
        this.resourceLoader = resourceLoader;
    }

    public GameStructureData getGame(String gameUrl) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(gameUrl);
            return gameXmlWorker.unMarshal(inputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public LevelData getLevel(String levelUrl) {
        try {
            InputStream inputStream = new ClassPathResource(levelUrl).getInputStream();
            return levelXmlWorker.unMarshal(inputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
