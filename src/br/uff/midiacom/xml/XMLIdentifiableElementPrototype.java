package br.uff.midiacom.xml;


/**
 * Class that implements the XMLIdentifiableElement interface.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public abstract class XMLIdentifiableElementPrototype<T extends XMLIdentifiableElement, P extends XMLElement, I extends XMLElementImpl>
        extends XMLElementPrototype<T, P, I> implements XMLIdentifiableElement<T, P> {


    public XMLIdentifiableElementPrototype() throws XMLException {
        super();
    }


    public void setId(String id) throws XMLException {
        impl.setId(id);
    }


    public String getId() {
        return impl.getId();
    }


    public boolean compare(T other) {
        return impl.compare(other);
    }


    @Override
    protected void createImpl() throws XMLException {
        impl = (I) new XMLElementImpl<T, P>();
    }
}
