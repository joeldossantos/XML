package br.uff.midiacom.xml;

import br.uff.midiacom.xml.datatype.string.StringType;


/**
 * Class that implements the XMLIdentifiableElement interface.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public abstract class XMLIdentifiableElementPrototype<T extends XMLIdentifiableElement, P extends XMLElement> extends XMLElementPrototype<T, P> implements XMLIdentifiableElement<T, P> {

    protected StringType id;


    public void setId(String id) throws XMLException {
        if(!validate(id))
            throw new XMLException("Invalid identifier");

        this.id = new StringType(id);
    }


    public String getId() {
        return id.getValue();
    }


    public boolean compare(T other) {
        return id.getValue().equals(other.getId());
    }


    /**
     * Validates the id String to check if it is in accordance with the XML
     * language definition.
     *
     * @param id
     *          string representing the id to be validated.
     * @return
     *          true id the id is valid and false otherwise.
     */
    protected abstract boolean validate(String id);
}
