package br.uff.midiacom.xml;


public abstract class Element<T extends XMLElement> implements XMLElement<T> {

    private T parent;


    public boolean setParent(T parent) {
        if(this.parent != null && parent != null)
            return false;

        this.parent = parent;
        return true;
    }


    public T getParent() {
        return parent;
    }
}
