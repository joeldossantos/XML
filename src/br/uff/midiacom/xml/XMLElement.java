package br.uff.midiacom.xml;

import org.w3c.dom.Element;


/**
 * This interface defines the basic type of an XML element.
 *
 * @param <T>
 *          XML element type.
 * @param <P>
 *          XML element parent type.
 */
public interface XMLElement<T extends XMLElement, P extends XMLElement> {


    /**
     * Sets the element parent.
     *
     * @param parent
     *          element representing the element parent.
     * @return
     *          true if the parent element was defined. If the element already
     *          has a parent element it returns false.
     */
    public boolean setParent(P parent);


    /**
     * Returns the parent element.
     *
     * @return
     *          element representing the parent element.
     */
    public P getParent();


    /**
     * Returns the XML code that represents the XML element.
     *
     * @param ident
     *          integer indicating the indentation level. The XML code will be
     *          indented by a tab "\t".
     * @return
     *          string representing the XML code.
     */
    public String parse(int ident);
    
    
    /**
     * Reads the XML code representing the XML element and creates the class.
     * 
     * @param element
     *          representation of the element to read.
     * @throws XMLException 
     *          if any error occur.
     */
    public void load(Element element) throws XMLException;


    /**
     * Compares two element.
     *
     * @param other
     *          the element to be compared with.
     * @return
     *          true if the elements are equal and false otherwise.
     */
    public boolean compare(T other);
}
