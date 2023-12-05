/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manci
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RPNCalculatorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

        @Override
    public void start(Stage primaryStage) {
        RPNCalculatorController controller = new RPNCalculatorController();
        controller.start(primaryStage);
    }
}


