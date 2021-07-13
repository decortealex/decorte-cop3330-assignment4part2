package assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;

public class ViewSwitcher {
    private static Scene scene;
    private static FXMLLoader loader;

    public static void setScene(Scene scene, FXMLLoader loader) {
        ViewSwitcher.scene = scene;
        ViewSwitcher.loader = loader;
    }
    public static void switchTo(View view) {
        try {
            Parent root = FXMLLoader.load(new File(view.getFileName()).toURI().toURL());

            scene.setRoot(root);
        }catch(Exception e) {
            System.out.println("xml not found.");
        }
    }

    public static FXMLLoader getLoader() {
        return loader;
    }
}
