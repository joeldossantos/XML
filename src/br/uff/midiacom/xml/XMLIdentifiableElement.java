package br.uff.midiacom.xml;


/**
 * Extends a XMLElement adding an id attribute.
 *
 * @param <T>
 *          XML element type.
 */
public interface XMLIdentifiableElement<T extends XMLIdentifiableElement> extends XMLElement<T> {


    /**
     * Sets the XML element id attribute.
     *
     * @param id
     *          string representing the element id.
     * @throws IllegalArgumentException
     *          if the id is not valid.
     */
    public void setId(String id) throws XMLException;


    /**
     * Returns the XML element id attribute.
     *
     * @return
     *          string representing the element id.
     */
    public String getId();
}
