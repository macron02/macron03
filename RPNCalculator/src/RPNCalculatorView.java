/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manci
 */
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

public class RPNCalculatorView {

    private RPNCalculatorController controller;
    private GridPane gridPane;
    private TextField inputTextField;
    private TextField stackTextField;
    private RPNCalculatorView view; 
      

    public RPNCalculatorView(RPNCalculatorController controller) {
        this.controller = controller;
        initializeUI();
    }

    public RPNCalculatorView getView() {
        return view;
    }

    public void setView(RPNCalculatorView view) {
        this.view = view;
    }
     

    private void initializeUI() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        inputTextField = new TextField();
        inputTextField.setEditable(false);
        gridPane.add(inputTextField, 0, 0, 4, 1);

        stackTextField = new TextField();
        stackTextField.setEditable(false);
        gridPane.add(stackTextField, 0, 1, 4, 1);

        // Aggiungi pulsanti al gridPane e gestisci gli eventi dei pulsanti
        addButton("1");
        addButton("2");
        // Aggiungi altri tasti numerici...

        addButton("+");
        addButton("-");
        addButton("*");
        addButton("sqrt");
        addButton("Inverti segno");
        addButton("<x");
        addButton(">x");
        addButton("+x");
        addButton("-x");
        addButton("clear");
        addButton("drop");
        addButton("dup");
        addButton("swap");
        addButton("over");
        addButton("vrbl");

        // Imposta il gridPane come nodo radice della scena
        controller.setGridPane(gridPane);
    }

    private void addButton(String label) {
        Button button = new Button(label);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(e -> controller.onButtonClick(label));
        gridPane.add(button, getColumn(label), getRow(label));
    }

    private int getColumn(String label) {
    switch (label) {
        case "=":
            return 0;
        case "+":
            return 1;
        case "-":
            return 2;
        case "*":
            return 3;
        case "sqrt":
            return 4;
        case "Inverti segno":
            return 5;
        case "<x":
            return 6;
        case ">x":
            return 7;
        case "+x":
            return 8;
        case "-x":
            return 9;
        case "clear":
            return 10;
        case "drop":
            return 11;
        case "dup":
            return 12;
        case "swap":
            return 13;
        case "over":
            return 14;
        case "vrbl":
            return 15;
        // Aggiungi altri casi se necessario
        default:
            return -1; // Ritorna un valore che indica un label non riconosciuto
            //da considerare la posizione reale dei tasti e sistemare tutto
    }
}


    private int getRow(String label) {
    switch (label) {
        case "=":
            return 0;
        case "+":
        case "-":
        case "*":
        case "sqrt":
        case "Inverti segno":
            return 1;
        case "<x":
        case ">x":
        case "+x":
        case "-x":
            return 2;
        case "clear":
        case "drop":
        case "dup":
        case "swap":
        case "over":
        case "vrbl":
            return 3;
        // Aggiungi altri casi se necessario
        default:
            return -1; // Ritorna un valore che indica un label non riconosciuto
    }
}


    public GridPane getGridPane() {
        return gridPane;
    }
    

    public TextField getInputTextField() {
        return inputTextField;
    }

    public TextField getStackTextField() {
        return stackTextField;
    }

public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

}

  
    
