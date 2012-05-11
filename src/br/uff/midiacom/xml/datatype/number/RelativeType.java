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
package br.uff.midiacom.xml.datatype.number;

import br.uff.midiacom.xml.XMLException;


/**
 * This class represents a number. The number can be:
 * <ul>
 *   <li>absolute integer number in the format 99</li>
 *   <li>relative double number in the format 99.99%</li>
 * </ul>
 */
public class RelativeType {

    private Integer intValue;
    private Double doubleValue;


    /**
     * Creates the number as a absolute integer number.
     *
     * @param value
     *          integer representing the number.
     */
    public RelativeType(int value) {
        this.intValue = value;
    }


    /**
     * Creates the number as a relative double number.
     *
     * @param value
     *          double representing the number.
     */
    public RelativeType(double value) {
        this.doubleValue = value;
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

        boolean relative = false;
        int index = value.indexOf("%");
        if(index > 0){
            value = value.substring(0, index);
            relative = true;
        }

        if(relative)
            this.doubleValue = new Double(value);
        else
            this.intValue = new Integer(value);
    }


    /**
     * Returns the number value if it is an absolute number or <i>null</i> if
     * the number is relative.
     *
     * @return
     *          integer representing the number.
     */
    public Integer getAbsoluteValue() {
        return intValue;
    }


    /**
     * Returns the number value if it is an relative number or <i>null</i> if
     * the number is absolute.
     *
     * @return
     *          double representing the number.
     */
    public Double getRelativeValue() {
        return doubleValue;
    }


    /**
     * Indicates if the number is relative.
     *
     * @return
     *          boolean indicating if the number is relative.
     */
    public boolean isRelative() {
        return (doubleValue != null);
    }


    /**
     * Returns the number value.
     *
     * @return
     *          String representing the number.
     */
    public String parse() {
        if(doubleValue != null)
            return "" + doubleValue + "%";
        else
            return "" + intValue;
    }
}
