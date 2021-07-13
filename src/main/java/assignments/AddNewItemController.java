package assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddNewItemController {
    @FXML
    private TextField titleField, dateField, descField;

    @FXML
    private Button doneButton;

    @FXML
    private Label label1;

    private todoItem item;

    public AddNewItemController() {

    }

    public void initialize() {

    }

    @FXML
    public void handleEvent(Event e) {
        String itemTitle, itemDate, itemDesc;

        itemTitle = titleField.getText();
        itemDate = dateField.getText();
        itemDesc = descField.getText();

        item = new todoItem(itemTitle, itemDesc, itemDate);
        todoList.addItem(item);
        ViewSwitcher.switchTo(View.MAIN);
    }

    public todoItem getItem() {
        return item;
    }


}
