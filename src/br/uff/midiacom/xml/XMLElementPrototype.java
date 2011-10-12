package br.uff.midiacom.xml;


/**
 * Class that implements the XMLElement interface.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public abstract class XMLElementPrototype<T extends XMLElement, P extends XMLElement, I extends XMLElementImpl>
        implements XMLElement<T, P> {

    protected I impl;


    public XMLElementPrototype() {
        impl = (I) new XMLElementImpl<XMLIdentifiableElement, P>();
    }


    public boolean setParent(P parent) {
        return impl.setParent(parent);
    }


    public P getParent() {
        return (P) impl.getParent();
    }
}
