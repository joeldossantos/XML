package br.uff.midiacom.xml.datatype.reference;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;
import br.uff.midiacom.xml.aux.ComparableItem;


/**
 * This class represents a reference inside an xml document.
 * 
 * @param <O>
 *          the type of the reference owner element.
 * @param <T>
 *          the type of the referred (target) element.
 * @param <A>
 *          Representation of the language attribute names.
 */
public abstract class ReferenceType<O extends XMLElement,
                                    T extends ReferredElement,
                                    A>
        implements ComparableItem<ReferenceType> {

    protected T target;
    protected A targetAtt;
    protected O owner;
    protected A ownerAtt;
    


    /**
     * Reference constructor. Creates a reference to an element without presenting
     * any reference to where the element is.
     *
     * @param target
     *          referred element.
     * @param targetAtt
     *          referred element attribute.
     * @throws XMLException
     *          if one of the parameters is null.
     */
    public ReferenceType(T target, A targetAtt) throws XMLException {
        setTarget(target);
        setTargetAtt(targetAtt);
    }
    
    
    /**
     * Set the reference target element. The target element can not be null.
     * 
     * @param target
     *          referred element.
     * @throws XMLException 
     *          if the target element is null.
     */
    private void setTarget(T target) throws XMLException {
        if(target == null)
            throw new XMLException("Null target element.");
        
        this.target = target;
        ((ReferredElement) this.target).addReference(this);
    }
    
    
    /**
     * Get the reference target element.
     * 
     * @return
     *          referred element.
     */
    public T getTarget() {
        return target;
    }
    
    
    /**
     * Set the attribute used to make the reference to the target element. The
     * attribute can not be null.
     * 
     * @param targetAtt
     *          referred element attribute.
     * @throws XMLException 
     *          if the attribute is null.
     */
    private void setTargetAtt(A targetAtt) throws XMLException {
        if(targetAtt == null)
            throw new XMLException("Null target attribute.");
        
        this.targetAtt = targetAtt;
    }
    
    
    /**
     * Get the attribute used to make the reference to the target element.
     * 
     * @return
     *          referred element attribute.
     */
    public A getTargetAtt() {
        return targetAtt;
    }
    
    
    /**
     * Set the reference owner element. The owner element can not be null.
     * 
     * @param owner
     *          reference owner element.
     * @throws XMLException 
     *          if the owner element is null.
     */
    public void setOwner(O owner) throws XMLException {
        if(owner == null)
            throw new NullPointerException("Null owner element.");
        
        this.owner = owner;
    }
    
    
    /**
     * Get the reference owner element.
     * 
     * @return
     *          reference owner element.
     */
    public O getOwner() {
        return owner;
    }
    
    
    /**
     * Set the attribute that makes the reference. The attribute can not be null.
     * 
     * @param ownerAtt
     *          owner element attribute.
     * @throws XMLException 
     *          if the attribute is null.
     */
    public void setOwnerAtt(A ownerAtt) throws XMLException {
        if(ownerAtt == null)
            throw new XMLException("Null target attribute.");
        
        this.ownerAtt = ownerAtt;
    }
    
    
    /**
     * Get the attribute that makes the reference.
     * 
     * @return
     *          owner element attribute.
     */
    public A getOwnerAtt() {
        return ownerAtt;
    }
    
    
    public void clean() throws XMLException {
        if(target != null)
            ((ReferredElement) target).removeReference(this);
    }
    
    
    public boolean compare(ReferenceType other) {
        if(other == null || other.getOwner() == null)
            return false;
        
        return getOwner().compare(other.getOwner());
    }


    /**
     * Returns the string that represents the element reference.
     *
     * @return
     *          string representing the element complete reference string.
     */
    public abstract String parse();
}
