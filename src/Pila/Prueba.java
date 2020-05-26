/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author Andres
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n1 = new Node(":D");
        Node n2 = new Node(":c");
        Node n3 = new Node(":/");
        
        Stack p = new Stack();
        
        p.push(n1.getInfo());
        p.push(n2.getInfo());
        p.push(n3.getInfo());
        
        System.out.println(p.size());

        p.pop();
        System.out.println(p.size());
        System.out.println(p.peek().getInfo());
    }
    
}
