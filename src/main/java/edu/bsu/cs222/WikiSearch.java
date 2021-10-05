package edu.bsu.cs222;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class WikiSearch {

    public static String getRevisionOf(String wikiTitle) throws IOException{
        String encodeUrlStr = URLEncoder.encode(wikiTitle,Charset.defaultCharset());
        String urlStr = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rbprop=timestamp|user&rvlimit=30&redirects",encodeUrlStr);
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent","WikipediaArticle/0.1; carogers@bsu.edu");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            WikipediaRevisionParser parser = new WikipediaRevisionParser();
            String revisions = parser.parse(inputStream);
            return revisions;
        } catch(MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }
}
