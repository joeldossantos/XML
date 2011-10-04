package br.uff.midiacom.xml.datatype.number;

import br.uff.midiacom.xml.XMLException;


/**
 * This class represents a value that can be a positive integer or the String
 * "unbounded".
 */
public class MaxType {

    private Integer value;
    private String unbounded = "unbounded";


    /**
     * Creates the value as a integer number.
     *
     * @param value
     *          a positive integer.
     * @throws XMLException
     *          if the integer is negative.
     */
    public MaxType(int value) throws XMLException {
        if(value < 0)
            throw new XMLException("Negative value");

        this.value = value;
    }


    /**
     * Creates the value as a String.
     *
     * @param value
     *          String representing a positive integer or the String "unbounded".
     * @throws XMLException
     *          if the String is null or empty.
     */
    public MaxType(String value) throws XMLException {
        if(value == null)
            throw new XMLException("Null value String");
        if("".equals(value.trim()))
            throw new XMLException("Empty value String");

        if(!value.equals(unbounded))
            this.value = new Integer(value);
    }


    /**
     * Return the value.
     *
     * @return
     *          element representing a positive integer.
     */
    public Integer getValue() {
        return value;
    }


    /**
     * Check if the value is the String "unbounded".
     *
     * @return
     *          true if the value is "unbounded".
     */
    public boolean isUnbounded() {
        return value == null;
    }


    /**
     * Returns the value.
     *
     * @return
     *          String representing the value.
     */
    public String parse() {
        if(value == null)
            return unbounded;
        else
            return value.toString();
    }
}
