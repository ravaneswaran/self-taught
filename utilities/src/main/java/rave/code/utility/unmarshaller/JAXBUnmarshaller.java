package rave.code.utility.unmarshaller;

import javax.xml.bind.JAXBContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class JAXBUnmarshaller<T> implements Unmarshaller<T> {

    @SuppressWarnings("unchecked")
    public T toInstance(Class<?> clazz, String xmlString) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new ByteArrayInputStream(
                xmlString.getBytes(Charset.forName("UTF-8")));
        return (T)jaxbUnmarshaller.unmarshal(inputStream);
    }

    public Object unMarshall(Class<?> clazz, String xmlString) throws Exception {
        return this.toInstance(clazz, xmlString);
    }
}
