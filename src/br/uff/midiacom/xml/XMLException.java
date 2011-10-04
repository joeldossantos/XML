package br.uff.midiacom.xml;


/**
 * This class represent an XML exception.
 */
public class XMLException extends Exception {

    public XMLException() {
        super();
    }


    public XMLException(String msg) {
        super(msg);
    }


    public XMLException(Throwable ex) {
        super(ex);
    }


    public XMLException(String msg, Throwable ex) {
        super(msg,ex);
    }
}
