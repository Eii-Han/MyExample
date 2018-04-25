import javafx.scene.control.TreeItem;

public interface TreeItemInterface{
    public TreeItem<String> makeBranch(String item, TreeItem<String> parent);
}