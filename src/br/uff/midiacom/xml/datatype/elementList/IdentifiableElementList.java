package br.uff.midiacom.xml.datatype.elementList;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;
import br.uff.midiacom.xml.XMLIdentifiableElement;


/**
 * This class represents a list of xml elements with id. This element list does not
 * stores null elements or repeated elements.
 *
 * @param <T>
 *          the type of element stored in the list.
 * @param <P>
 *          type of the stored element parent.
 */
public class IdentifiableElementList<T extends XMLIdentifiableElement,
                                     P extends XMLElement>
        extends ElementList<T, P> {


    /**
     * Removes an element with an specific id.
     *
     * @param id
     *          id of the element to be removed.
     * @return
     *          true if the element was removed.
     * @throws XMLException
     *          if the string is null or empty.
     */
    public boolean remove(String id) throws XMLException {
        if(id == null)
            throw new XMLException("Null id string.");
        if("".equals(id.trim()))
            throw new XMLException("Empty id string");

        return elements.remove(get(id));
    }


    /**
     * Returns the element with an specific id.
     *
     * @param id
     *          id of the element to be retrieved.
     * @return
     *          element of the list with the id.
     * @throws XMLException
     *          if the string is null or empty.
     */
    public T get(String id) throws XMLException {
        if(id == null)
            throw new XMLException("Null id string.");
        if("".equals(id.trim()))
            throw new XMLException("Empty id string");

        for(T el : elements){
            if(el.getId().equals(id))
                return el;
        }
        return null;
    }
}
