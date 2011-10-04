package br.uff.midiacom.xml;

import br.uff.midiacom.xml.datatype.string.StringType;


public abstract class IdentifiableElement<T extends XMLIdentifiableElement> extends Element<T> implements XMLIdentifiableElement<T> {

    private StringType id;


    public void setId(String id) throws XMLException {
        this.id = new StringType(id);
    }


    public String getId() {
        return id.getValue();
    }


    public boolean compare(T other) {
        return id.getValue().equals(other.getId());
    }
}
