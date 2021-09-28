package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class WikiPaste extends WikiSearch{

    protected String wikiPaste() throws IOException {
        Scanner scanner = new Scanner(System.in);
        WikiSearch wikiSearch = new WikiSearch();
        ListConvert listConvert = new ListConvert();
        // User inputs Title
        String input = scanner.nextLine();
        if( input.equals("")){
            System.out.println("There was no Input");
            System.exit(1);
            return null;
        } else {
            System.out.println("There was an Input");
        }
        // calls WikiSearch
        System.out.println(getRevisionOf(input));

        return getRevisionOf(input);

    }
}