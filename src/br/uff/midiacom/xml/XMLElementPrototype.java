package br.uff.midiacom.xml;


/**
 * Class that implements the XMLElement interface.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public abstract class XMLElementPrototype<T extends XMLElement,
                                          P extends XMLElement,
                                          I extends XMLElementImpl>
        implements XMLElement<T, P> {

    protected I impl;


    public XMLElementPrototype() throws XMLException {
        createImpl();
    }


    public boolean setParent(P parent) {
        return impl.setParent(parent);
    }


    public P getParent() {
        return (P) impl.getParent();
    }


    protected void createImpl() throws XMLException {
        impl = (I) new XMLElementImpl<XMLIdentifiableElement, P>();
    }
}
