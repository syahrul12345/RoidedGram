package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.apache.poi.ss.formula.functions.Column;

import java.net.URL;
import java.util.ResourceBundle;

public class disagreeController implements Initializable{

    @FXML private GridPane gridPane;
    @FXML private HBox hBox;
    public void agreeButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
    }

    public void disagreeButtonClicked(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setFillWidth(true);

        gridPane.getColumnConstraints().add(col1);


    }
}
