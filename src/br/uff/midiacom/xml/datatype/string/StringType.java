package br.uff.midiacom.xml.datatype.string;

import br.uff.midiacom.xml.XMLException;


/**
 * This class represents an String that can not be empty or have an special
 * character.
 */
public class StringType {

    private String value;


    /**
     * String constructor.
     *
     * @param value
     *          the string value.
     * @throws XMLException
     *          if the string is empty or has an special character.
     */
    public StringType(String value) throws XMLException {
        if(value != null && "".equals(value.trim()))
            throw new XMLException("Empty String");

        //@todo: testar se tem caracter especial

        this.value = value;
    }


    /**
     * Returns the string value.
     *
     * @return
     *          string representing the string value.
     */
    public String getValue() {
        return value;
    }
}
