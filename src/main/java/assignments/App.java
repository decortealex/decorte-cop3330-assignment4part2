/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 4 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */

package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File(View.MAIN.getFileName()).toURI().toURL());
        Parent root = loader.load();

        todoList list = new todoList();
        MainController controller = loader.getController();

        Scene scene = new Scene(root);
        ViewSwitcher.setScene(scene, loader);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class todoList {
    private static ArrayList<todoItem> items = new ArrayList<>();

    /**
     * appends item to todo list
     * @param item item to add
     */
    public static void addItem(todoItem item) {
        items.add(item);
    }

    /**
     * removes item from todo list
     * @param item item to remove
     * @return true if successful
     */
    public static boolean popItem(todoItem item) {
        return items.remove(item);
    }

    /**
     * get item from todo list by index
     * @param index index to get
     * @return todoItem object
     */
    public static todoItem getItem(int index) {
        return items.get(index);
    }

    public static void clearAllItems() {
        items.clear();
    }

    public static int getSize() {
        return items.size();
    }

    public static ObservableList<String> getAllComplete() {
        ObservableList<String> complete = FXCollections.observableArrayList();
        for(todoItem item : items) {
            if(item.isItemComplete()) {
                complete.add(item.getItemTitle());
            }
        }
        return complete;
    }

    public static ObservableList<String> getAllIncomplete() {
        ObservableList<String> incomplete = FXCollections.observableArrayList();
        for (todoItem item : items) {
            if(!item.isItemComplete()) {
                incomplete.add(item.getItemTitle());
            }
        }
        return incomplete;
    }

    public static ObservableList<String> getList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for(todoItem item : items) {
            list.add(item.getItemTitle());
        }
        return list;
    }

    public static void loadFromFile(String fp) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fp));
        ArrayList<todoItem> list = new ArrayList<>();

        while(s.hasNextLine()) {
            list.add(new todoItem(s.next(), s.next(), s.next()));
        }
        items = list;
        s.close();
    }

    public static void writeToFile(String fp) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fp));
        for(todoItem item : items) {
            pw.printf("%s %s %s\n", item.getItemTitle(), item.getDesc(), item.getDueDate());
        }
    }
}

class todoItem {
    private String itemTitle;
    private String desc;
    private Date dueDate;
    private SimpleDateFormat sdf;
    private boolean isComplete;

    // constructor params will be class variables
    public todoItem(String itemTitle, String desc, String dueDate) {
        this.itemTitle = itemTitle;
        this.desc = desc;
        this.sdf = new SimpleDateFormat("YYYY-mm-DD");
        this.isComplete = false;

    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String title) {
        this.itemTitle = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) throws Exception {
        if(desc.length() < 256 && desc.length() > 1) {
            this.desc = desc;
        } else {
            throw new Exception();
        }
    }

    public String getDueDate() {
        return dueDate.toString();
    }

    public void setDueDate(String date) throws ParseException {
        this.dueDate = sdf.parse(date);
    }

    public boolean isItemComplete() {
        return isComplete;
    }

    public void setDone(boolean isDone) {
        this.isComplete = isDone;
    }
}
