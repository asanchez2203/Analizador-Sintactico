/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Pila.Stack;
import java.io.IOException;
import java.util.ArrayList;
import matrizPredictiva.Tabla;

/**
 *
 * @author andre
 */
public class TestTabla {
    public static void main(String[] args) throws IOException {
        Tabla t = new Tabla();
        System.out.println("------------- GRAMATICA COMPLETA");
        ArrayList<String> x = t.contenido("src/Archivos/gramatica.txt");
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }   
        System.out.println("------------- LADO DERECHO DE LA GRAMATICA");
        Stack w = t.llenadoDerecho(x);
        w.printStack();
        System.out.println("--------------- NO TERMINALES");
        Stack y = t.llenadoNoTerminales(x);
        y.printStack();
        System.out.println("--------------- TERMINALES");
        Stack z = t.llenadoTerminales(x);
        z.printStack();
    }
}
