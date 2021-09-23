package edu.bsu.cs222;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class WikiSearch extends WikiUser{
    WikiUser wikiUser = new WikiUser();
    public URLConnection connectToWikipedia() throws IOException{
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=4&redirects");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent","Revision Reporter/0.1 (me@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        connection.connect();
        return connection;
    }
    public Document readXmlDocumentFrom(URLConnection connection) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(connection.getInputStream());
    }
}
