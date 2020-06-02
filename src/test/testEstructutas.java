/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Estructura.EstructurasEstaticas;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class testEstructutas {
    public static void main(String[] args) throws IOException {
        EstructurasEstaticas ee = new EstructurasEstaticas();
        System.out.println("HOLA :D");
        System.out.println("---- GRAMATICA");
        ArrayList<String> x = ee.contenido("src/Archivos/gramatica.txt");
        ee.impresion(x); 
        System.out.println("---- LADO DERECHO");
        ArrayList<String> y = ee.llenadoDerecho(x);
        ee.impresion(y);
        System.out.println("---- NO TERMINALES");
        ArrayList<String> z = ee.llenadoNoTerminales(x);
        ee.impresion(z);
        System.out.println("---- TERMINALES");
        ArrayList<String> w = ee.llenadoTerminales(y);
        ee.impresion(w);
    }
}
