package br.uff.midiacom.xml.datatype.reference;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;


/**
 * This class represents a reference inside an xml document.
 *
 * @param <E>
 *          the type of the referred element.
 */
public abstract class ReferenceType<E extends XMLElement> {

    protected String reference;
    protected E element;


    /**
     * Reference constructor. Creates a reference to an element without presenting
     * any reference to where the element is.
     *
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element is null.
     */
    public ReferenceType(E element) throws XMLException {
        if(element == null)
            throw new NullPointerException("Null element.");

        this.element = element;
    }


    /**
     * Reference constructor. Creates a reference to an element also indicating
     * where the element is.
     *
     * @param reference
     *          string representing the element location.
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element or the string is null or empty.
     */
    public ReferenceType(String reference, E element) throws XMLException {
        if(reference == null)
            throw new XMLException("Null alias.");
        if("".equals(reference.trim()))
            throw new XMLException("Empty alias.");
        if(element == null)
            throw new XMLException("Null element.");

        this.reference = reference;
        this.element = element;
    }


    /**
     * Reference constructor. Creates an reference just indicating the element
     * location.
     *
     * @param reference
     *          string representing the element location.
     * @throws XMLException
     *          if the string is null or empty or if the element could not be found.
     */
    public ReferenceType(String reference) throws XMLException {
        if(reference == null)
            throw new XMLException("Null alias.");
        if("".equals(reference.trim()))
            throw new XMLException("Empty alias.");

        createReference(reference);
    }


    /**
     * Returns the referred element.
     *
     * @return
     *          referred element.
     */
    public E getElement() {
        return element;
    }


    /**
     * Creates the reference from a string that represents the complete reference.
     * After this method an element reference object should have an element.
     *
     * @param reference
     *          string representing the element location.
     * @throws XMLException
     *          if the element could not be found.
     */
    protected abstract void createReference(String reference) throws XMLException;


    /**
     * Returns the string that represents the element reference.
     *
     * @return
     *          string representing the element complete reference string.
     */
    protected abstract String parse();
}
