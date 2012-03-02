package br.uff.midiacom.xml;

import org.w3c.dom.Element;


public class XMLElementImplementation extends XMLElementPrototype<XMLElementImplementation, XMLElement, XMLElementImpl> {

    private String id;


    public XMLElementImplementation(String id) throws XMLException {
        super();
        this.id = id;
    }


    public String getId() {
        return id;
    }


    public boolean compare(XMLElementImplementation other) {
        return id.equals(other.getId());
    }

    public String parse(int ident) {
        return id;
    }

    public void load(Element element) throws XMLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
