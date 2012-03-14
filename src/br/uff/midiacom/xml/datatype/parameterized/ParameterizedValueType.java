package br.uff.midiacom.xml.datatype.parameterized;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;
import br.uff.midiacom.xml.datatype.reference.ReferenceType;


public abstract class ParameterizedValueType<T extends ParameterizedValueType,
                                             O extends XMLElement,
                                             V,
                                             A,
                                             R extends ReferenceType> {

    protected V value;
    protected R param;
    protected O owner;
    
    private String tempValue;


    /**
     * Creates a parameterized value as a regular value.
     *
     * @param value
     *          regular value.
     * @throws XMLException
     *          if the value is null.
     */
    public ParameterizedValueType(V value) throws XMLException {
        if(value == null)
            throw new XMLException("null value.");

        this.value = value;
    }


    /**
     * Creates a parameterized value as a parameter.
     *
     * @param value
     *          element representing a reference to a parameter.
     * @throws XMLException
     *          if the value is null.
     */
    public ParameterizedValueType(R value) throws XMLException {
        if(value == null)
            throw new XMLException("null value.");

        this.param = value;
    }


    /**
     * Creates a parameterized value from a String.
     * 
     * @param value
     *          String representing the parameterized value. If the value is a
     *          reference to a parameter, it will be created when the
     *          parameterized value is added to an XML element.
     * @throws XMLException 
     *          if the String is null, empty or has an invalid content.
     */
    public ParameterizedValueType(String value) throws XMLException {
        if(value == null)
            throw new XMLException("null String.");
        if("".equals(value.trim()))
            throw new XMLException("Empty String");
        if(value.contains("$"))
            tempValue = value.substring(1);
        else
            this.value = createValue(value);
    }


    /**
     * Returns the parameterized value regular value.
     *
     * @return
     *          regular value.
     */
    public V getValue() {
        return value;
    }


    /**
     * Returns the parameterized value parameter.
     *
     * @return
     *          element representing a parameter.
     */
    public R getParam() {
        return param;
    }
    
    
    /**
     * Set the parameterized value owner and the attribute used to make the
     * reference. If the value is a reference to a parameter, this method will
     * also try to create the parameter reference.
     * 
     * @param owner
     *          parameterized value owner element.
     * @param ownerAtt
     *          owner element attribute.
     * @throws XMLException 
     *          if any error occur while creating the parameter reference.
     */
    public void setOwner(O owner, A ownerAtt) throws XMLException {
        this.owner = owner;
        
        // If the reference to the parameter needs to be created, creates it
        if(tempValue != null)
            this.param = createParam(tempValue, owner);
        
        // Set the reference owner and attribute
        if(param != null){
            param.setOwner(owner);
            param.setOwnerAtt(ownerAtt);
        }
    }
    
    
    /**
     * Removes the owner of the parameterized value. If the value is a reference
     * to a parameter, the parameter reference will be removed.
     */
    public void removeOwner() throws XMLException {
        if(param != null){
            param.clean();
            param = null;
        }
    }


    /**
     * Return the String representing the parameterized value.
     * 
     * @return 
     *          String with the value representation. If the value refers to
     *          a parameter, it will return the parameter name with the "$"
     *          String.
     */
    public String parse() {
        if(value != null)
            return getStringValue();
        else
            return "$" + getStringParam();
    }


    /**
     * Compares two parameterized values.
     * 
     * @param other
     *          other parameterized value to make the comparison.
     * @return 
     *          true is the values are equal and false otherwise.
     */
    public boolean compare(T other) {
        return parse().equals(other.parse());
    }


    protected abstract R createParam(String param, O owner) throws XMLException;


    protected abstract V createValue(String value) throws XMLException;


    protected abstract String getStringValue();


    protected abstract String getStringParam();
}
