/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author Administrator
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTableViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<String> treeTableView = new TreeTableView<>();
        
        TreeTableColumn<String, String> column = new TreeTableColumn<>("Column 1");
        column.setCellValueFactory(param -> param.getValue().valueProperty());
        
        treeTableView.getColumns().add(column);
        
        TreeItem<String> rootItem = new TreeItem<>("Root");
        for (int i = 1; i <= 100; i++) {
            TreeItem<String> item = new TreeItem<>("Item " + i);
            rootItem.getChildren().add(item);
        }
        
        treeTableView.setRoot(rootItem);
        treeTableView.setShowRoot(false); // Hide the root node from view

        ScrollPane scrollPane = new ScrollPane(treeTableView);

        Scene scene = new Scene(new ScrollPane(treeTableView), 400, 300);
        
        primaryStage.setTitle("TreeTableView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
