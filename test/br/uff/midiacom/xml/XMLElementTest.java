package br.uff.midiacom.xml;

import br.uff.midiacom.xml.datatype.elementList.ElementList;
import org.junit.Test;
import static org.junit.Assert.*;


public class XMLElementTest {

    private ElementList<XMLElementImplementation, XMLElement> list;


    public XMLElementTest() {
        list = new ElementList<XMLElementImplementation, XMLElement>();
    }


    @Test
    public void testCompare() throws XMLException {
        list.add(new XMLElementImplementation("a"), null);
        list.add(new XMLElementImplementation("b"), null);
        list.add(new XMLElementImplementation("c"), null);
        list.add(new XMLElementImplementation("d"), null);
        list.add(new XMLElementImplementation("c"), null);

        String aux = "";
        for(XMLElementImplementation el : list)
            aux += el.getId();

        String expected = "abdc";
        assertEquals(expected, aux);
    }
}