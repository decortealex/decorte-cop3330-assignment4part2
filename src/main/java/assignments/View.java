package assignments;

public enum View {
    MAIN("src\\main\\resources\\App.fxml"),
    LOADLIST("src\\main\\resources\\LoadList.fxml"),
    SAVELIST("src\\main\\resources\\SaveList.fxml"),
    ITEM("src\\main\\resources\\AddNewItem.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
