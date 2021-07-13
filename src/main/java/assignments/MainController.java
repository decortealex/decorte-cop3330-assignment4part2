package assignments;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MainController {

    @FXML
    ListView<String> listView;

    @FXML
    private MenuItem saveListButton, loadListButton, clearListButton, addItemButton, sortCompleteButton, sortIncompleteButton;

    private ObservableList<String> listToShow;

    public MainController() {
        listView = new ListView<>();
    }

    public void initialize() {
    }

    @FXML
    private void onClick(Event e) throws IOException {
        if(e.getSource() == loadListButton) {
            System.out.println("loading list");
            ViewSwitcher.switchTo(View.LOADLIST);

        } else if(e.getSource() == saveListButton) {
            ViewSwitcher.switchTo(View.SAVELIST);
        } else if(e.getSource() == addItemButton) {
            todoList.addItem(new todoItem("test", "test", "09-11-2002"));

            ViewSwitcher.switchTo(View.ITEM);
        } else if(e.getSource() == sortCompleteButton) {
            listToShow = todoList.getAllComplete();
        } else if(e.getSource() == sortIncompleteButton) {
            listToShow = todoList.getAllIncomplete();
        }
        listToShow = todoList.getList();
        listView.setItems(listToShow);
    }




}
