package test;

import Estructura.EstructurasEstaticas;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class testEstructutas {
    public static void main(String[] args) throws IOException {
        EstructurasEstaticas ee = new EstructurasEstaticas(20);
        System.out.println("HOLA :D");
        System.out.println("---- GRAMATICA");
        String[] x = ee.contenido("src/Archivos/gramatica.txt");
        ee.impresion(x); 
        System.out.println("---- LADO DERECHO");
        String[] y = ee.llenadoDerecho(x);
        ee.impresion(y);
        System.out.println("---- NO TERMINALES");
        String[] z = ee.llenadoNoTerminales(x);
        ee.impresion(z);
        System.out.println("---- TERMINALES");
        String[] w = ee.llenadoTerminales(y);
        ee.impresion(w);
    }
}
