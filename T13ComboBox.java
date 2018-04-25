
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T13ComboBox extends Application{

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Combox Demo");
        button = new Button("Submit");

        comboBox = new ComboBox<String>();
        comboBox.getItems().addAll(
            "Good Will Hunting", "St. Vincent", "Blackhat"
        );

        comboBox.setOnAction(e->System.out.println("User selected " + comboBox.getValue()));

        comboBox.setPromptText("What is your favourite movie?");
        comboBox.setEditable(true);
        button.setOnAction(e->printMovie());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();


    }


    public static void main(String[] args) {
         launch(args);
    }

    //Prints out a movie
    private void printMovie(){
        MessageBox.display("Movie", comboBox.getValue());
    }



}