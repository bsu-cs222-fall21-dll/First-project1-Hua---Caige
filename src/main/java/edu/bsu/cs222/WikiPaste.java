package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class WikiPaste extends WikiSearch{

    public String titleCall() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    protected String wikiPaste() throws IOException {

        System.out.println();
        String input = titleCall();
        if( input.equals("")){
            System.out.println("There was no Input");
            System.exit(1);
            return null;
        } else {
            System.out.println("There was an Input");
        }
        // calls WikiSearch

        return getRevisionOf(input);

    }
}