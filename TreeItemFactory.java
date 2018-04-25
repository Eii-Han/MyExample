import javafx.scene.control.TreeItem;

public class TreeItemFactory implements TreeItemInterface{

    public TreeItem<String> makeBranch(String item, TreeItem<String> parent){
        TreeItem<String> treeItem = new TreeItem<>(item);

        treeItem.setExpanded(true);
        parent.getChildren().add(treeItem);

        return treeItem;
    }
}