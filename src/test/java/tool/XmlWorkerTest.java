package tool;

import eu.mrndesign.matned.client.model.game.object.data.model.LevelData;
import eu.mrndesign.matned.client.model.tool.XmlWorker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class XmlWorkerTest {

    private LevelData levelData;


    private final XmlWorker<LevelData> xmlWorker;
    private File file;

    {
        try {
            xmlWorker = new XmlWorker<>(LevelData.class);
            URL url = Thread.currentThread().getContextClassLoader().getResource("test.xml");
            file = new File(url.toURI());
        } catch (JAXBException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void setup() throws JAXBException, URISyntaxException {
        levelData = xmlWorker.unMarshal(file);
    }

    @Test
    void ShouldCorrectlyUnmarshalXMLFile_WhenPathIsGiven() {
        assertEquals("starship", levelData.getHero().getName());
        assertEquals("BOTTOM", levelData.getGrounds().get(0).getVerticalPos());
    }

    @Test
    void ShouldReturnDefaultValues_WhenEmptyInXML(){
        assertTrue(levelData.getHero().isHostile());
    }

    @Test
    void ShouldReturnDefaultValue_WhenNotInXML(){
        assertEquals("", levelData.getBackground().getName());
    }

}