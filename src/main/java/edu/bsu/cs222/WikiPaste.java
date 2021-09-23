package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class WikiPaste extends WikiSearch{
    public static void main(String[] args) throws IOException, ParserConfigurationException,
            SAXException, TransformerException {
        WikiSearch wikiSearch = new WikiSearch();
        URLConnection connection = wikiSearch.connectToWikipedia();
        Document document = wikiSearch.readXmlDocumentFrom(connection);
        printDocument(document);
    }
    public static void printDocument(Document document) throws TransformerException{
        TransformerFactory transFormer = TransformerFactory.newInstance();
        Transformer transformer = transFormer.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"no");
        transformer.setOutputProperty(OutputKeys.METHOD, "json");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.setOutputProperty("{http://json.apache.org/xslt}indent-amount","4");
        transformer.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(System.out, StandardCharsets.UTF_8)));

    }
}
