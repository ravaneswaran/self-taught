package rave.code.utility.marshaller;

import javax.xml.bind.JAXBContext;
import java.io.StringWriter;

public class JAXBMarshaller implements Marshaller {

    public String toXml(Object arg) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(arg.getClass());
        javax.xml.bind.Marshaller jaxbMarshaller = (javax.xml.bind.Marshaller) jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(arg, writer);
        return writer.toString();
    }

    public String marshall(Object arg) throws Exception {
        return this.toXml(arg);
    }
}
