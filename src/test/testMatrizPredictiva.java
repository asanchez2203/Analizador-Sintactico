package test;

import Estructura.EstructurasEstaticas;
import MatrizPredictiva.MatrizPredictiva;
import java.io.IOException;

/**
 *
 * @author Alexis Sanchez
 */
public class testMatrizPredictiva {
    public static void main(String[] args) throws IOException {
        EstructurasEstaticas ee = new EstructurasEstaticas("src/Archivos/gramatica.txt");
        String[] x = ee.contenido("src/Archivos/gramatica.txt");
        String[] y = ee.llenadoDerecho(x);
        String[] z = ee.llenadoNoTerminales(x);
        String[] w = ee.llenadoTerminales(y);
        MatrizPredictiva m = new  MatrizPredictiva(z,w);
        
        m.imprimeTabla();
    }
}
