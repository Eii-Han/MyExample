
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListViewT15 extends Application{
    
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("wayne");
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll(
            "Iron Man", "Titanic", "Contact", "Surragates"
        );
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e->buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);
        scene = new Scene(layout,300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void buttonClicked(){
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for(String movie : movies){
            message += movie + "\t";
        }

        MessageBox.display("movies", message);
    }
}