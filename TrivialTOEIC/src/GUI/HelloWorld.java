/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane; 
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    

    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'"); 
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            System.out.println("Hello World!"); }
            });
        Button signIn = new Button("Sign In");
        final Text actiontarget = new Text();
        signIn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Enregistrement effectué");
            }
        });
        Label coucou = new Label("coucou");
        TextField field = new TextField();
        StackPane root = new StackPane();
        root.getChildren().add(btn); 
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(btn,0,0);
        grid.add(coucou,1,1);
        HBox hbx = new HBox();
        Button btn2 = new Button("Ceci est un autre bouton");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Coucou");
                actiontarget.setText("Coucou");
            } 
        });
        
        hbx.getChildren().add(btn2);
        grid.add(hbx, 1, 0);
        grid.add(field,2,1);
        grid.add(signIn, 2, 2);
        grid.add(actiontarget,2,3);
        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        scene.getStylesheets().add
        (HelloWorld.class.getResource("test.css").toExternalForm());
        
        primaryStage.show();
    }
    public void runUI(String[] args) {
    launch(args); }
}
