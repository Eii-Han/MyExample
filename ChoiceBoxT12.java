

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxT12 extends Application{

    Stage window;
    Scene scene;
    Button button;
    
	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiceBox Demo");

        button = new Button("Click me");
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();

        //GetItems returns ObservableList object which you can add items to
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().add("Orange");
        choiceBox.getItems().add("Grape");
        choiceBox.getItems().add("Strawberry");
        choiceBox.getItems().addAll("Bacan", "Ham", "Meatballs");
        
        //Set a default value
        choiceBox.setValue("Apple");

        //Listen for selection changes
        //void changed(ObservableValue<? extends T> observable,T oldValue,T newValue)
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
            MessageBox.display("You changed.", "Old Choice: " + oldValue + "\nNew Choice: " + newValue);
        });

        button.setOnAction(e->{
            MessageBox.display("Fruit", "You choosed " + choiceBox.getSelectionModel().selectedItemProperty().getValue());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
   

}