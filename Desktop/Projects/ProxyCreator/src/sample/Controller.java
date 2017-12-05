package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private StackPane infoPane;
    @FXML private AnchorPane defaultPane;
    @FXML private AnchorPane apiPane;
    @FXML private AnchorPane providerPane;
    @FXML private AnchorPane specPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Group root = new Group();
        root.getChildren().addAll(defaultPane,apiPane,providerPane,specPane);
        infoPane.getChildren().add(root);
        resetPane();
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/FXML/default.fxml"));
            defaultPane.getChildren().add(pane);
            pane = FXMLLoader.load(getClass().getResource("/FXML/api.fxml"));
            apiPane.getChildren().add(pane);
            pane = FXMLLoader.load(getClass().getResource("/FXML/provider.fxml"));
            providerPane.getChildren().add(pane);
            pane = FXMLLoader.load(getClass().getResource("/FXML/spec.fxml"));
            specPane.getChildren().add(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
        defaultPane.setVisible(true);
    }
    public void providerButtonClicked(ActionEvent actionEvent) {
        resetPane();
        providerPane.setVisible(true);

    }

    public void apiButtonClicked(ActionEvent actionEvent) {
        resetPane();
        apiPane.setVisible(true);
    }

    public void serverSpecButtonClicked(ActionEvent actionEvent) {
        resetPane();
        specPane.setVisible(true);
    }
    public void resetPane() {
        defaultPane.setVisible(false);
        apiPane.setVisible(false);
        providerPane.setVisible(false);
        specPane.setVisible(false);
    }

}
