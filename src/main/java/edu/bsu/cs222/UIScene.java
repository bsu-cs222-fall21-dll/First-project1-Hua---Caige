package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UIScene {

    @FXML
    private TextField urlField;
    private final Executor executor = Executors.newSingleThreadExecutor();
    @FXML
    private TextArea result;

    @SuppressWarnings("unused")
    @FXML
    public void CountWard(javafx.event.ActionEvent actionEvent) throws RuntimeException {
        WikiSearch wikiSearch = new WikiSearch();

        if(urlField.getText().equals("")){
            System.exit(1);
        }
        try{
            getResult();
    }catch (MalformedURLException murle){
            throw new RuntimeException(murle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getResult() throws IOException {
        WikiSearch wikiSearch = new WikiSearch();
        String string = wikiSearch.getRevisionOf(urlField.getText());
        String frontLine = string.substring(0,string.length()/2);
        String lastLine = string.substring(string.length()/2,string.length());
        result.appendText(frontLine + "\n" + lastLine);
    }
}

