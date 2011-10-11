package br.uff.midiacom.xml.parameterized;

import br.uff.midiacom.xml.XMLElement;
import br.uff.midiacom.xml.XMLException;


public abstract class ParameterizedValueType<T extends ParameterizedValueType, V, P extends XMLElement> {

    private V value;
    private P param;


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
     *          element representing a parameter.
     * @throws XMLException
     *          if the value is null.
     */
    public ParameterizedValueType(P value) throws XMLException {
        if(value == null)
            throw new XMLException("null value.");

        this.param = value;
    }


    public ParameterizedValueType(String value) throws XMLException {
        if(value == null)
            throw new XMLException("null String.");
        if("".equals(value.trim()))
            throw new XMLException("Empty String");

        if(value.contains("$")){
            value = value.substring(1);
            this.param = createParam(value);
        }
        else{
            this.value = createValue(value);
        }
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
    public P getParam() {
        return param;
    }


    public String parse() {
        if(value != null)
            return getStringValue();
        else
            return "$" + getStringParam();
    }


    public boolean compare(T other) {
        return parse().equals(other.parse());
    }


    protected abstract P createParam(String param) throws XMLException;


    protected abstract V createValue(String value) throws XMLException;


    protected abstract String getStringValue();


    protected abstract String getStringParam();
}
