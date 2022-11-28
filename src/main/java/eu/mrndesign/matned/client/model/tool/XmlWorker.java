package eu.mrndesign.matned.client.model.tool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlWorker<E> {

    private final Unmarshaller jaxbUnmarshaller;

    public XmlWorker(Class<E> classType) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classType);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    }

    public E unMarshal(File file) throws JAXBException {
        return  (E) jaxbUnmarshaller.unmarshal(file);
    }

}
