/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manci
 */
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import java.util.List;
import java.util.Optional;
import javafx.scene.layout.GridPane;
import java.util.Arrays;


public class RPNOperationHandler {
    private RPNStack rpnStack; // Aggiungi la classe RPNStack per gestire lo stack

    private GridPane gridPane; // Aggiungi il riferimento al GridPane
    private RPNCalculatorController controller;

    public void setController(RPNCalculatorController controller) {
        this.controller = controller;
    }


    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    // Aggiungi la logica per le nuove operazioni
    public void handleVariableButton() {
        // Apri il popup per selezionare una variabile
        List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        ChoiceDialog<String> variableDialog = new ChoiceDialog<>("A", alphabet);
        variableDialog.setTitle("Seleziona Variabile");
        variableDialog.setHeaderText(null);
        variableDialog.setContentText("Seleziona una variabile:");

        Optional<String> selectedVariable = variableDialog.showAndWait();
        selectedVariable.ifPresent(variable -> {
            // Gestisci la variabile selezionata
            // ...
        });
    }

    // Altre funzioni per le nuove operazioni
    // ...

    // Funzione per mostrare una finestra di dialogo con un messaggio
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Funzione per mostrare una finestra di dialogo con un messaggio di errore
    private void showError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    // Funzione per mostrare una finestra di dialogo con un campo di input
    private String showInputDialog(String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input");
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
