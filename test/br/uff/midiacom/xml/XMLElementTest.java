package br.uff.midiacom.xml;

import br.uff.midiacom.xml.datatype.elementList.ElementList;
import org.junit.Test;
import static org.junit.Assert.*;


public class XMLElementTest {

    private ElementList<XMLElementImpl, XMLElement> list;


    public XMLElementTest() {
        list = new ElementList<XMLElementImpl, XMLElement>();
    }


    @Test
    public void testCompare() throws XMLException {
        list.add(new XMLElementImpl("a"), null);
        list.add(new XMLElementImpl("b"), null);
        list.add(new XMLElementImpl("c"), null);
        list.add(new XMLElementImpl("d"), null);
        list.add(new XMLElementImpl("c"), null);

        String aux = "";
        for(XMLElementImpl el : list)
            aux += el.getId();

        String expected = "abdc";
        assertEquals(expected, aux);
    }
}