package br.uff.midiacom.xml.datatype.array;

import br.uff.midiacom.xml.XMLException;
import java.util.Vector;


/**
 * This class represents an value represented as an array (ex.: 99,99,99).
 */
public class ArrayType {

    private double[] values;
    
    
    /**
     * Create the array from an array of values.
     *
     * @param values
     *          array of values.
     * @throws XMLException
     *          if one value of the array is negative.
     */
    public ArrayType(double[] values) throws XMLException {
        setValues(values);
    }


    /**
     * Create the array from an array of values.
     *
     * @param values
     *          array of values.
     * @throws XMLException
     *          if one value of the array is negative.
     */
    public ArrayType(String values) throws XMLException {
        Vector<Double> array = new Vector<Double>();
        while(values.contains(",")){
            int index = values.indexOf(",");
            array.add(new Double(values.substring(0, index)));
            values = values.substring(index + 1);
        }
        array.add(new Double(values));
        double[] a = new double[array.size()];
        for(int k = 0; k < array.size(); k++)
            a[k] = (double) array.elementAt(k);

        setValues(a);
    }


    private void setValues(double[] values) throws XMLException {
        if(values != null){
            for(double coord : values){
                if(coord < 0)
                    throw new XMLException("Invalid value: " + coord);
            }
        }

        this.values = values;
    }


    /**
     * Returns the array.
     *
     * @return
     *          array of values.
     */
    public double[] getArray() {
        return values;
    }


    /**
     * Returns the array size.
     *
     * @return
     *          integer with the array size.
     */
    public int getSize() {
        return values.length;
    }


    /**
     * Returns the array.
     *
     * @return
     *          String representing the array.
     */
    private String parse() {
        String result = "";
        for(int i = 0; i < values.length; i++){
            result += values[i];
            if(i < values.length - 1)
                result += ",";
        }
        return result;
    }
}
