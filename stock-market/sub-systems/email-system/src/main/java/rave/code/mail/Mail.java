package rave.code.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

public interface Mail {

    /**
     * @param host
     * @param port
     * @param userName
     * @param password
     */
    public void connect(String host, String port, String userName,
                        String password);

    /**
     * @return
     */
    public Session getSession();

    /**
     * @param from
     * @param tos
     * @param ccs
     * @param bccs
     * @param attachments
     * @param subject
     * @param message
     * @throws MessagingException
     */
    public void sendMail(String from, String[] tos, String[] ccs,
                         String[] bccs, String[] attachments, String subject, String message)
            throws MessagingException;

    /**
     * @param from
     * @param to
     * @param subject
     * @param message
     * @throws MessagingException
     */
    public void sendMail(String from, String to, String subject, String message)
            throws MessagingException;

    /**
     * @param from
     * @param to
     * @param ccs
     * @param subject
     * @param message
     * @throws MessagingException
     */
    public void sendMail(String from, String to, String[] ccs, String subject,
                         String message) throws MessagingException;

    /**
     * @param from
     * @param to
     * @param ccs
     * @param bccs
     * @param subject
     * @param message
     * @throws MessagingException
     */
    public void sendMail(String from, String to, String[] ccs, String[] bccs,
                         String subject, String message) throws MessagingException;

    /**
     * @param from
     * @param to
     * @param ccs
     * @param bccs
     * @param attachments
     * @param subject
     * @param message
     * @throws MessagingException
     */
    public void sendMail(String from, String to, String[] ccs, String[] bccs,
                         String[] attachments, String subject, String message)
            throws MessagingException;

    /**
     * @param folderName
     * @param protocol
     * @return
     * @throws MessagingException
     */
    public Message[] checkFolder(String folderName, String protocol) throws MessagingException;


    /**
     * @param folderName
     * @param protocol
     * @param encrypted
     * @return
     * @throws MessagingException
     */
    public Message[] getUnReadMessages(String folderName, String protocol, boolean encrypted) throws MessagingException;


    /**
     * @param folderName
     * @param protocol
     * @param encrypted
     * @return
     * @throws MessagingException
     */
    public Message[] getSentMessages(String folderName, String protocol, boolean encrypted) throws MessagingException;


    /**
     * @param folderName
     * @param protocol
     * @param encrypted
     * @return
     * @throws MessagingException
     */
    public Message[] getDrafts(String folderName, String protocol, boolean encrypted) throws MessagingException;
}
