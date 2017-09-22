package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import model.DimensionalAnalyzer;
import model.UnitParser;
import org.controlsfx.control.textfield.TextFields;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class agreeController implements Initializable{

    @FXML private GridPane gridPane;
    @FXML private TextField value;
    @FXML private TextField inUnits;
    @FXML private TextField outUnits;
    @FXML private TextArea textArea;
    private UnitParser unitParser;
    private DimensionalAnalyzer dimensionalAnalyzer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        unitParser = new UnitParser();
        dimensionalAnalyzer = new DimensionalAnalyzer();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setFillWidth(true);
        col1.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().add(col1);


    }



    public void convertBtnClicked(ActionEvent actionEvent) {
        String fromValue = value.getText();
        String unitIn = inUnits.getText();
        String unitOut = outUnits.getText();
        unitParser.accept(unitIn,unitOut);

        dimensionalAnalyzer.add(unitParser.getListIn(),unitParser.getListOut());

    }
}
