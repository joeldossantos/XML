package br.uff.midiacom.xml.datatype.reference;

import java.util.TreeSet;


public interface ReferredElement<R extends ReferenceType> {

    
    public boolean addReference(R reference);
    
    
    public boolean removeReference(R reference);
    
    
    public TreeSet<R> getReferences();
}
