package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import model.Creator;
import model.NameObserver;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

    @FXML
    private Spinner spinner;
    private Creator creator;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private NameObserver nameObserver = new NameObserver();
    public void spinnerClicked(ActionEvent actionEvent) throws IOException {
        int accToCreate = (Integer) spinner.getValue();
        creator = new Creator(accToCreate);
        creator.addObserver(nameObserver);
        executorService.submit(creator);
    }
}
