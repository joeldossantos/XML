package br.uff.midiacom.xml.aux;


public interface ComparableItem<T> {

    
    /**
     * Compares two element.
     *
     * @param other
     *          the element to be compared with.
     * @return
     *          true if the elements are equal and false otherwise.
     */
    public boolean compare(T other);
}
