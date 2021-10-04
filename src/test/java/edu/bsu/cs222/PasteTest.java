package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class PasteTest {
    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timeStamp = (String) parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-20T01:32:48Z", timeStamp);
    }
}
