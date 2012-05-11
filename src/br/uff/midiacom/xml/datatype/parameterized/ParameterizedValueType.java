/********************************************************************************
 * This file is part of the API for NCL Authoring - aNa.
 *
 * Copyright (c) 2011, MidiaCom Lab (www.midiacom.uff.br)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * All advertising materials mentioning features or use of this software must
 *    display the following acknowledgment:
 *        This product includes the API for NCL Authoring - aNa
 *        (http://joeldossantos.github.com/aNa).
 *
 *  * Neither the name of the lab nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without specific
 *    prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY MIDIACOM LAB AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE MÍDIACOM LAB OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *******************************************************************************/
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
