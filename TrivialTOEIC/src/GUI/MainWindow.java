/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox mainHBox = new HBox();
        GridPane grid  = FXMLLoader.load(getClass().getResource("test.fxml"));
        Circle token = new Circle(10);
        grid.add(token, 4,5);
        
        mainHBox.getChildren().add(grid);
        Scene scene = new Scene(mainHBox, 1000, 1000);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void runUI(String[] args){
        launch(args);
    }
    
}
