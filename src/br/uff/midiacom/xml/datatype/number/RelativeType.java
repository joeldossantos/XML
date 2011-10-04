package br.uff.midiacom.xml.datatype.number;

import br.uff.midiacom.xml.XMLException;


/**
 * This class represents a number. The number can be:
 * <ul>
 *   <li>absolute number in the format 99.99</li>
 *   <li>relative number in the format 99.99%</li>
 * </ul>
 */
public class RelativeType {

    private double value;
    private boolean isRelative;


    /**
     * Creates the number as a absolute number.
     *
     * @param value
     *          double representing the number.
     */
    public RelativeType(double value) {
        this.value = value;
        isRelative = false;
    }


    /**
     * Creates a number that can be relative.
     *
     * @param value
     *          double representing the number.
     * @param isRelative
     *          boolean indicating if the number is relative or absolute.
     *          true for relative and false for absolute.
     */
    public RelativeType(double value, boolean isRelative) {
        this.value = value;
        this.isRelative = isRelative;
    }


    /**
     * Creates the number as a String.
     *
     * @param value
     *          String representing the number.
     * @throws XMLException
     *          if the String is null or empty.
     */
    public RelativeType(String value) throws XMLException {
        if(value == null)
            throw new XMLException("Null value String");
        if("".equals(value.trim()))
            throw new XMLException("Empty value String");

        int index = value.indexOf("%");
        if(index > 0){
            value = value.substring(0, index);
            isRelative = true;
        }

        this.value = new Double(value);
    }


    /**
     * Returns the number value.
     *
     * @return
     *          double representing the number.
     */
    public double getValue() {
        return value;
    }


    /**
     * Indicates if the number is relative.
     *
     * @return
     *          boolean indicating if the number is relative.
     */
    public boolean isRelative() {
        return isRelative;
    }


    /**
     * Returns the number value.
     *
     * @return
     *          String representing the number.
     */
    public String parse() {
        if(isRelative)
            return "" + value + "%";
        else
            return "" + value;
    }
}
