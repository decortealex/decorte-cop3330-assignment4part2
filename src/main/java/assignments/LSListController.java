package assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class LSListController {
    @FXML
    private TextField fileName;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    String output;
    boolean isDone = false;

    @FXML
    private void handleOnClick(Event e) {
        if(e.getSource() == loadButton) {
            try {
                todoList.loadFromFile("src\\main\\resources\\" + fileName.getText());
            } catch (FileNotFoundException nfe) {
                System.out.println("file not found");
            }
        } else if(e.getSource() == saveButton) {
            try {
                todoList.writeToFile("src\\main\\resources\\" + fileName.getText());
            } catch(FileNotFoundException nfe) {
                System.out.println("file not found");
            }
        }
        ViewSwitcher.switchTo(View.MAIN);
    }

}
