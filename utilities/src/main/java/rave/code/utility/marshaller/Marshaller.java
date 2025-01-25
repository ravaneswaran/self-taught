package rave.code.utility.marshaller;

import jakarta.xml.bind.JAXBException;

public interface Marshaller {

    public String toXml(Object arg) throws Exception;

    public String marshall(Object arg) throws Exception;
}
