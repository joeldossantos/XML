package br.uff.midiacom.xml.datatype.reference;

import br.uff.midiacom.xml.XMLException;
import br.uff.midiacom.xml.aux.ItemList;


public interface ReferredElement<R extends ReferenceType> {

    
    public boolean addReference(R reference) throws XMLException;
    
    
    public boolean removeReference(R reference) throws XMLException;
    
    
    public ItemList<R> getReferences();
}
