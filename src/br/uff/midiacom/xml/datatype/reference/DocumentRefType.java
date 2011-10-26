package br.uff.midiacom.xml.datatype.reference;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;


/**
 * This class represents an reference to a document.
 *
 * @param <E>
 *          the type of the referred document.
 */
public class DocumentRefType<E extends XMLElement> extends ReferenceType<E> {


    /**
     * Reference constructor. Creates a reference to an element without presenting
     * any reference to where the element is.
     *
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element is null.
     */
    public DocumentRefType(E element) throws XMLException {
        super(element);
    }


    /**
     * Reference constructor. Creates a reference to an element also indicating
     * where the element is.
     *
     * @param documentURI
     *          string representing the path to the imported document.
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element or the string is null or empty.
     */
    public DocumentRefType(String documentURI, E element) throws XMLException {
        super(documentURI, element);
    }


    /**
     * Reference constructor. Creates an reference just indicating the element
     * location.
     *
     * @param documentURI
     *          string representing the path to the imported document.
     * @throws NullPointerException
     *          if the string is null or empty or if the element could not be found.
     */
    public DocumentRefType(String documentURI) throws XMLException {
        super(documentURI);
    }


    /**
     * Returns the path to the imported document.
     *
     * @return
     *          string representing the path.
     */
    public String getDocumentURI() {
        return reference;
    }


    @Override
    protected void createReference(String documentURI) throws XMLException {
        throw new XMLException("Not supported yet.");
    }

    @Override
    protected String parse() {
        return reference;
    }
}
