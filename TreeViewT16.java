
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewT16 extends Application{

    Stage window;
    TreeView<String> tree;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("JavaFx-TreeView");
        TreeItemInterface factory = new TreeItemFactory();


        TreeItem<String> root, bucky, megan;
        TreeItem<String> youtube;

        //Root
        root = new TreeItem<String>("Parent");
        root.setExpanded(true);

        //Bucky
        bucky = factory.makeBranch("Bucky", root);
        factory.makeBranch("thenewboston", bucky);
        factory.makeBranch("Chicken", bucky);

        //Youtube
        youtube = factory.makeBranch("Youtube", bucky);
        factory.makeBranch("Nogi", youtube);
        factory.makeBranch("Keyaki", youtube);

        //Megan
        megan = factory.makeBranch("Megan", root);
        factory.makeBranch("Glitter", megan);
        factory.makeBranch("Makeup", megan);

        //Create Tree
        tree = new TreeView<String>(root);
        tree.setShowRoot(false);

        //Setting Up Listener
        tree.getSelectionModel().selectedItemProperty().addListener(((v, oldValue, newValue)->{
            if(newValue != null){
                MessageBox.display("Items", newValue.getValue());
            }
        }));
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

	public static void main(String[] args) {
        launch(args);
    }


}
