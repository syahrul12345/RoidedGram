package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.util.ResourceBundle;

public class agreeController implements Initializable{

    @FXML private GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setFillWidth(true);
        col1.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().add(col1);
    }
}
