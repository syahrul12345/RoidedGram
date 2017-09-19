package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private TextArea tocTextArea;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button agreeBtn;
    @FXML
    private Button disagreeBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("/Users/muhdsyahrulnizam/Desktop/AndroidProjects/EasyConvert/src/model/toctext.docx");
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
            XWPFDocument docx = new XWPFDocument(fs);
            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            tocTextArea.appendText(we.getText());
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setFillWidth(true);
            col1.setHgrow(Priority.ALWAYS);
            gridPane.getColumnConstraints().add(col1);
            gridPane.setPrefSize(700, 200);
        } catch (FileNotFoundException e) {
            tocTextArea.appendText("If you see this, the TOC wod document is gone for some reason");
        } catch (IOException e) {
            tocTextArea.appendText("ApachePIO initialization failed, please download ApachePIO");
        }

    }

    public void agreeButtonClicked(ActionEvent actionEvent) {
        System.out.println("Agree Button Clicked");
    }

    public void disagreeButtonClicked(ActionEvent actionEvent) {
        System.out.println("Disagree Button Clicked");

    }
}
