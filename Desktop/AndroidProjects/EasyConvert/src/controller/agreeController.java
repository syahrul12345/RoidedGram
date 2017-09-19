package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


import java.net.URL;
import java.util.ResourceBundle;

public class agreeController implements Initializable{

    @FXML private GridPane gridPane;
    @FXML private TextField value;
    @FXML private TextField inUnits;
    @FXML private TextField outUnits;
    @FXML private TextArea textArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setFillWidth(true);
        col1.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().add(col1);
    }

    public void convertBtnClicked(ActionEvent actionEvent) {
        String fromValue = value.getText();
        String fromIn = inUnits.getText();
        String fromOut = outUnits.getText();
        textArea.appendText(fromValue + fromIn + fromOut);
    }
}
