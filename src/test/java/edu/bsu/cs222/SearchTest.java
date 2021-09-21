package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SearchTest {
    @Test
    public void ConnectionTest() throws IOException, ParserConfigurationException, SAXException {
        WikiSearch wikiSearch = new WikiSearch();
        wikiSearch.connectToWikipedia();
        wikiSearch.readXmlDocumentFrom(wikiSearch.connectToWikipedia());
    }

}
