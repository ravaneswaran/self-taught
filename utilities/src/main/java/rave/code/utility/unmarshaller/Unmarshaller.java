package rave.code.utility.unmarshaller;

public interface Unmarshaller<T> {

    public T toInstance(Class<?> clazz, String xmlString)
            throws Exception;

    public Object unMarshall(Class<?> clazz, String xmlString)
            throws Exception;

}
