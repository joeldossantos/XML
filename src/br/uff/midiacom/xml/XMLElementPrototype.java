package br.uff.midiacom.xml;


/**
 * Class that implements the XMLElement interface.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public abstract class XMLElementPrototype<T extends XMLElement, P extends XMLElement> implements XMLElement<T, P> {

    protected P parent;


    public boolean setParent(P parent) {
        if(this.parent != null && parent != null)
            return false;

        this.parent = parent;
        return true;
    }


    public P getParent() {
        return parent;
    }
}
