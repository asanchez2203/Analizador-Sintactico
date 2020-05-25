package test;

import DataStructure.Stack;

public class testStack {
    public static void main(String[] args) {
        Stack pila = new Stack(3);
        pila.push("ELEMENTO 1");
        pila.push("ELEMENTO 2");
        pila.push("ELEMENTO 3");       
        pila.push("ELEMENTO 4");

        System.out.println("****** IMPRIME PILA");
        pila.printStack();
        
        pila.pop();
        System.out.println("****** IMPRIME PILA MODIFICADA");
        pila.printStack();
        
    }
}
