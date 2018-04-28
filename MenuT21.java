import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;


/* T21 -24 including Menu, MenuItem, CheckMenuItem, ToggleGroup, RadioMenuItem*/

public class MenuT21 extends Application{

    Stage window;
    BorderPane layout;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Bar Demo");

        //File Menu
        Menu fileMenu = new Menu("_File");
        Menu selectionMenu = new Menu("Selection");
        Menu viewMenu = new Menu("View");

        //Menu Item
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e->MessageBox.display("New File", "Create a new File"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        //Edit Menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Cut"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e->MessageBox.display("Paste", "Paste an item"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLine = new CheckMenuItem("Show Line Numbers");
        showLine.setOnAction(e->{
            if(showLine.isSelected()){
                MessageBox.display("Line Number", "Program will now display line numbers");
            }
            else{
                MessageBox.display("Line Number", "Hiding line number");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable autoSave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLine, autoSave);

        //Difficulty RadioMenuItem
        Menu diffficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        diffficultyMenu.getItems().addAll(easy, medium, hard);

        //Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,selectionMenu,viewMenu,helpMenu, diffficultyMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}