
package test;

import Pila.Stack;

/**
 *
 * @author Alexis Sanchez
 */
public class testStack {
    public static void main(String[] args) {
        Stack pila = new Stack();
        pila.push("$");
        pila.push("inicio");
        pila.push("stmt_list");
        pila.push(")");
        pila.push("aritop");
        pila.push("stmt_list");
        
        System.out.println("PILA SIN SACAR NADA");
        pila.printStack();
        pila.pop();
        System.out.println("");
        System.out.println("PILA DESPUES DEL POP");
        pila.printStack();
    }
}
