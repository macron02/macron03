/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manci
 */
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RPNStack {

    private Stack<Double> operandStack;
    public List<Double> getOperandStack() {
        return new ArrayList<>(operandStack);
    }

    public RPNStack() {
        operandStack = new Stack<>();
    }

    public void push(Double value) {
        operandStack.push(value);
    }

    public Double pop() {
        if (operandStack.isEmpty()) {
            // Aggiungi gestione dell'errore se lo stack è vuoto
            throw new IllegalStateException("Lo stack è vuoto");
        }
        return operandStack.pop();
    }

    public int size() {
        return operandStack.size();
    }

    public void clear() {
        operandStack.clear();
    }

    public void drop() {
        if (!operandStack.isEmpty()) {
            operandStack.pop();
        }
    }

    public void dup() {
        if (!operandStack.isEmpty()) {
            Double top = operandStack.peek();
            operandStack.push(top);
        }
    }

    public void swap() {
        if (operandStack.size() >= 2) {
            Double top = operandStack.pop();
            Double secondTop = operandStack.pop();
            operandStack.push(top);
            operandStack.push(secondTop);
        } else {
            // Aggiungi gestione dell'errore se ci sono meno di due elementi nello stack
            throw new IllegalStateException("Lo stack deve avere almeno due elementi per lo swap");
        }
    }

    public void over() {
        if (operandStack.size() >= 2) {
            Double secondTop = operandStack.elementAt(operandStack.size() - 2);
            operandStack.push(secondTop);
        } else {
            // Aggiungi gestione dell'errore se ci sono meno di due elementi nello stack
            throw new IllegalStateException("Lo stack deve avere almeno due elementi per l'over");
        }
        
    }
    
}

