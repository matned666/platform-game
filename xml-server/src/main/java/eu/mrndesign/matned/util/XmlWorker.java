package eu.mrndesign.matned.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class XmlWorker<E> {

    private final Unmarshaller jaxbUnmarshaller;

    public XmlWorker(Class<E> classType) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classType);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    }

    public E unMarshal(InputStream inputStream) throws JAXBException {
        return (E) jaxbUnmarshaller.unmarshal(inputStream);
    }

}
