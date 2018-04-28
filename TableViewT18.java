import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*  In this program, a few of features were added to allow user to insert / delete the columnn of table
    and update the information of product.(Tutorial 19) 4/27/2018
    Done. (Tutorial 20) 4/28/2018
    TO-DO: Using design pattern to make things clean.......
*/

public class TableViewT18 extends Application{

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("JavaFx-TableView");

        //Name Column
        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name")); //Must be exact name with the property

        //Pirce Column
        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity Column
        TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(100);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("name of product");
        nameInput.setMinWidth(100);

        //Pirice Input
        priceInput = new TextField();
        priceInput.setPromptText("price");

        //Quantity Input
        quantityInput = new TextField();
        quantityInput.setPromptText("quantity");

        //Button - add / delete Column
        Button addButton = new Button("Add");
        addButton.setOnAction(e->addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e->deleteButtonClicked());

        //HBox layout to store Button
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameCol, priceCol, quantityCol);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(table, hBox);


        //To-DO: Please create Layout
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    //Add Button Clicked
    private void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);

        //Clear up all the enter field
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //Delete Button Clicked
    private void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        //Short-hand version
        productSelected.forEach(allProducts::remove);
    }


    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy ball", 2.49, 198));
        products.add(new Product("Toilet", 99.00, 74));
        products.add(new Product("The Notebook DVD", 19.99, 12));
        products.add(new Product("Corn", 1.49, 856));

        return products;
    }
}