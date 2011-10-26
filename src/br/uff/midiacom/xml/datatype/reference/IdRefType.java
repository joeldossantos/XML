package br.uff.midiacom.xml.datatype.reference;

import br.uff.midiacom.xml.XMLException;
import br.uff.midiacom.xml.XMLIdentifiableElement;


/**
 * This class represents an reference to an identifiable element.<br/>
 * If the element comes from a different document, the reference stores the
 * document alias.
 *
 * @param <E>
 *          the type of the referred element.
 */
public class IdRefType<E extends XMLIdentifiableElement> extends ReferenceType<E> {


    /**
     * Reference constructor. Creates a reference to an element without presenting
     * any reference to where the element is.
     *
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element is null.
     */
    public IdRefType(E element) throws XMLException {
        super(element);
    }


    /**
     * Reference constructor. Creates a reference to an element also indicating
     * where the element is.
     *
     * @param alias
     *          string representing the document where the element is defined.
     * @param element
     *          referred element.
     * @throws XMLException
     *          if the element or the string is null or empty.
     */
    public IdRefType(String alias, E element) throws XMLException {
        super(alias, element);
    }


    /**
     * Reference constructor. Creates an reference just indicating the element
     * location.
     *
     * @param reference
     *          string representing the element location (alias#element_id).
     * @throws XMLException
     *          if the string is null or empty or if the element could not be found.
     */
    public IdRefType(String reference) throws XMLException {
        super(reference);
    }


    /**
     * Returns the element alias. The alias is a string representing the document
     * where the element is defined.
     *
     * @return
     *          string representing the element alias.
     */
    public String getAlias() {
        return reference;
    }


    @Override
    protected void createReference(String reference) throws XMLException {
        if(reference == null)
            throw new XMLException("Null reference String");
        if("".equals(reference.trim()))
            throw new XMLException("Empty reference String");

        int index = reference.indexOf("#");
        if(index > 0){
            this.reference = reference.substring(0, index);
            reference = reference.substring(index+1, reference.length());
        }

        this.element = findReference(reference);
    }


    @Override
    protected String parse() {
        String result = "";

        if(reference != null)
            result += reference;
        result += element.getId();

        return result;
    }


    protected E findReference(String id) throws XMLException {
        throw new XMLException("Not supported yet.");
    }
}
