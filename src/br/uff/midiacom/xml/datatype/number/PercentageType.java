package br.uff.midiacom.xml.datatype.number;

import br.uff.midiacom.xml.XMLException;


/**
 * This class percentage value. The value can be represented:
 * <ul>
 *   <li>without the percentage sign as a number between 0 and 1</li>
 *   <li>with the percentage sign as a number between 0 and 100 (ex.: 99.99%)</li>
 * </ul>
 */
public class PercentageType {

    private double value;
    private boolean signed;


    /**
     * Creates the percentage as a signed value.
     *
     * @param value
     *          double representing a number between 0 and 100.
     * @throws XMLException
     *          if the value is out of bounds.
     */
    public PercentageType(double value) throws XMLException {
        signed = true;
        setValue(value);
    }


    /**
     * Creates the percentage indicating if it has a percent sign.
     *
     * @param value
     *          double representing the percentage.
     * @param signed
     *          boolean indicating if the percentage value has or not a percent
     *          sign. true for a signed value and false for unsigned.
     * @throws XMLException
     *          if the value is out of bounds.
     */
    public PercentageType(double value, boolean signed) throws XMLException {
        this.signed = signed;
        setValue(value);
    }


    /**
     * Creates the percentage as a String.
     *
     * @param value
     *          String representing the percentage.
     * @throws XMLException
     *          if the String is null, empty or out of bounds.
     */
    public PercentageType(String value) throws XMLException {
        if(value == null)
            throw new XMLException("Null value String");
        if("".equals(value.trim()))
            throw new XMLException("Empty value String");

        int index = value.indexOf("%");
        if(index > 0){
            value = value.substring(0, index);
            signed = true;
        }

        setValue(new Double(value));
    }


    private void setValue(double value) throws XMLException {
        if(!signed && (value < 0 || value > 1))
            throw new XMLException("The number must be between 0 and 1.");
        if(signed && (value < 0 || value > 100))
            throw new XMLException("The number must be between 0 and 100.");

        this.value = value;
    }


    /**
     * Returns the percentage value.
     *
     * @return
     *          double representing the number.
     */
    public double getValue() {
        return value;
    }


    /**
     * Indicates if the percentage has a percentage sign.
     *
     * @return
     *          boolean indicating if the percentage value has or not a percent
     *          sign. true for a signed value and false for unsigned.
     */
    public boolean isRelative() {
        return signed;
    }


    /**
     * Returns the number value.
     *
     * @return
     *          String representing the number.
     */
    public String parse() {
        if(signed)
            return "" + value + "%";
        else
            return "" + value;
    }
}
