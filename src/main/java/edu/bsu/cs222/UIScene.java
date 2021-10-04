package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UIScene {
    @FXML
    private TextField ulrResult;

    @FXML
    private TextField urlField;
    private final Executor executor = Executors.newSingleThreadExecutor();

    @SuppressWarnings("unused")
    @FXML
    public void CountWard(javafx.event.ActionEvent actionEvent) {
        try{
        URL url = new URL(urlField.getText());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                }
            }catch (IOException e){
                    throw new RuntimeException();
                }
            }
        });
    }catch (MalformedURLException murle){
            throw new RuntimeException(murle);
        }
}

    public void GetResult(ActionEvent actionEvent) {

    }
}
