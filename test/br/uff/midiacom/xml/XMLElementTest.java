package br.uff.midiacom.xml;

import br.uff.midiacom.xml.datatype.elementList.ElementList;
import org.junit.Test;
import static org.junit.Assert.*;


public class XMLElementTest {

    private ElementList<XMLElementImpl> list;


    public XMLElementTest() {
        list = new ElementList<XMLElementImpl>();
    }


    @Test
    public void testCompare() throws XMLException {
        list.add(new XMLElementImpl("a"));
        list.add(new XMLElementImpl("b"));
        list.add(new XMLElementImpl("c"));
        list.add(new XMLElementImpl("d"));
        list.add(new XMLElementImpl("c"));

        String aux = "";
        for(XMLElementImpl el : list)
            aux += el.getId();

        String expected = "abdc";
        assertEquals(expected, aux);
    }
}