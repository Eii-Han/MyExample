
import java.awt.print.Printable;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MessageBox{
    
    public static void display(String title, String message){
        Stage window = new Stage();

        //Set Properties
        window.setTitle(title);
        window.initModality(Modality.WINDOW_MODAL);
        window.setMinWidth(300);
        window.setMinHeight(100);
        Label label = new Label(message);

        Button button = new Button("Close");
        button.setOnAction(e->window.close());

        VBox box = new VBox(8);
        box.setMinSize(50, 50);
        box.getChildren().addAll(label, button);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 400 , 70);
        window.setScene(scene);
        window.showAndWait();

    }


}