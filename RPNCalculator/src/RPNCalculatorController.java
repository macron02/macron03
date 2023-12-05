/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manci
 */
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.List;
import java.util.function.BinaryOperator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.function.UnaryOperator;
import javafx.scene.layout.GridPane;









public class RPNCalculatorController extends Application{
    private RPNOperationHandler rpnOperationHandler;
    private RPNStack stack;
    private RPNStack rpnStack;
    private RPNCalculatorView view;
   


    // Altri metodi e codice...

    
    // Altri metodi e variabili della classe
private boolean isBinaryOperator(String operator) {
        // Verifica se l'operatore è uno degli operatori binari supportati
        return operator.equals("=") || operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("sqrt");
    }

 private BinaryOperator<Double> getBinaryOperator(String operator) {
    switch (operator) {
        case "=":
            return (a, b) -> b; // l'operazione "=" restituisce il secondo operando
        case "+":
            return Double::sum;
        case "-":
            return (a, b) -> a - b;
        case "*":
            return (a, b) -> a * b;
        case "sqrt":
            return (a, b) -> Double.valueOf(Math.sqrt(a));
        default:
            throw new IllegalArgumentException("Operatore binario non supportato: " + operator);
    }
}

private void performBinaryOperation(String operator) {
    // Ottieni l'operatore binario associato all'operatore specifico
    BinaryOperator<Double> binaryOperator = getBinaryOperator(operator);

    // Esegui l'operazione binaria utilizzando l'operatore ottenuto
    if (rpnStack.size() >= 2) {
        double operand2 = rpnStack.pop();
        double operand1 = rpnStack.pop();
        double result = binaryOperator.apply(operand1, operand2);
        rpnStack.push(result);
        updateStackField();
    } else {
        showAlert("Errore", "Non ci sono abbastanza operandi nello stack per l'operazione binaria");
    }
}

    // Altri metodi della classe
 private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
 public void setRPNOperationHandler(RPNOperationHandler rpnOperationHandler) {
        this.rpnOperationHandler = rpnOperationHandler;
    }




private void updateStackField() {
        // Implementa la logica per aggiornare il campo dello stack nell'interfaccia utente
        // Ad esempio, puoi ottenere gli elementi dallo stack e visualizzarli nell'interfaccia utente
        List<Double> stackElements = stack.getOperandStack();
  // Sostituisci con il metodo appropriato
        // Aggiorna l'interfaccia utente con gli elementi dello stack
    }
@Override
public void start(Stage primaryStage) {
    rpnOperationHandler = new RPNOperationHandler();

    // Inizializza il controller e passa il riferimento a rpnOperationHandler
    RPNCalculatorController controller = new RPNCalculatorController();
    controller.setRPNOperationHandler(rpnOperationHandler);
    controller.start(primaryStage);

    // Inizializza l'interfaccia utente
    initializeUI();

    // Avvia l'applicazione JavaFX
    Scene scene = new Scene(rpnOperationHandler.getGridPane(), 600, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("RPN Calculator");
    primaryStage.show();
}

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        // Altre configurazioni del pulsante, se necessario...
        return button;
    }

   private void initializeUI() {
    // Inizializza l'interfaccia utente, pulsanti, ecc.
    // Aggiungi pulsanti al gridPane e gestisci gli eventi dei pulsanti
    // ...

    // Esempio: Aggiungi pulsante per variabili
    Button variableButton = createButton("vrbl");
    if (rpnOperationHandler != null) {
        GridPane gridPane = rpnOperationHandler.getGridPane();
        if (gridPane != null) {
            gridPane.add(variableButton, 2, 5);
            variableButton.setOnAction(e -> onButtonClick("vrbl"));
        }
    }
}

public void setGridPane(GridPane gridPane) {
    this.view.setGridPane(gridPane);
}


  private void handleUnaryOperatorOrAction(String operator) {
        switch (operator) {
            case "sqrt":
                performUnaryOperation(Math::sqrt, "sqrt");
                break;
            case "inverti segno":
                performUnaryOperation(value -> -value, "inverti segno");
                break;
            // Aggiungi altri operatori unari secondo le tue esigenze
            default:
                showAlert("Errore", "Operatore unario non gestito: " + operator);
        }
    }

    private void performUnaryOperation(UnaryOperator<Double> unaryOperator, String operatorName) {
        if (rpnStack.size() >= 1) {
            Double operand = rpnStack.pop();
            Double result = unaryOperator.apply(operand);
            rpnStack.push(result);
            updateStackField();
        } else {
            showAlert("Errore", "Non ci sono abbastanza operandi nello stack per l'operazione " + operatorName);
        }
    }
   public void onButtonClick(String buttonText) {
    try {
        // Se il testo del pulsante è un numero, lo aggiungiamo allo stack
        double number = Double.parseDouble(buttonText);
        stack.push(number);
        updateStackField(); // Aggiorna il campo dello stack nell'interfaccia utente
    } catch (NumberFormatException e) {
        // Se non è un numero, potrebbe essere un operatore
        if (isBinaryOperator(buttonText)) {
            // Se è un operatore binario, esegui l'operazione
            performBinaryOperation(buttonText);
        } else {
            // Altrimenti, potrebbe essere un operatore unario o un'altra azione
            handleUnaryOperatorOrAction(buttonText);
        }

        updateStackField(); // Aggiorna il campo dello stack dopo l'operazione
    }
}


    public RPNCalculatorView getView() {
        return view;
    }

}
