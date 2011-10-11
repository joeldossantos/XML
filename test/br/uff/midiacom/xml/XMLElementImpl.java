package br.uff.midiacom.xml;


public class XMLElementImpl extends XMLElementPrototype<XMLElementImpl, XMLElement> {

    private String id;


    public XMLElementImpl(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }


    @Override
    public boolean compare(XMLElementImpl other) {
        return id.equals(other.getId());
    }

    public String parse(int ident) {
        return id;
    }
}
