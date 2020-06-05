package LLDriver;

import Pila.Node;
import Pila.Stack;
import java.io.IOException;
import Estructura.EstructurasEstaticas;
import Lector.LectorPrograma;
import Tokens.AFN;
import MatrizPredictiva.MatrizPredictiva;
import Tokens.Token;

/**
 *
 * @author Alexis Sanchez
 */
public class LLDriver {
    private final Stack pila;
    private final String[] terminales;
    private final String[] noTerminales;
    private final String[] ladoDerecho;
    private final int[][] matrizPredictiva;
    private final AFN analizadorLexico;
    
    public LLDriver() throws IOException{
        pila = new Stack();
        EstructurasEstaticas estructuras = new EstructurasEstaticas("src/Archivos/gramatica.txt");
        ladoDerecho = estructuras.llenadoDerecho(estructuras.contenido("src/Archivos/gramatica.txt"));
        noTerminales = estructuras.llenadoNoTerminales(estructuras.contenido("src/Archivos/gramatica.txt"));
        terminales = estructuras.llenadoTerminales(ladoDerecho);
        matrizPredictiva = new MatrizPredictiva(noTerminales, terminales).getMatrizPredictiva();
        
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] lineasPrograma = lp.extraerTexto();
        analizadorLexico = new AFN(lineasPrograma);
    }
    
    public void run(){
        pila.push(new Node("$")); // Poner el simbolo inicial en la pila vacia
        String x = terminales[terminales.length-1];
        Token a = analizadorLexico.getNextToken();
        int produccion;
        
        while(!pila.isEmpty()){
            if(contains(noTerminales, a.getLexema().toString())){
                if((produccion = matrizPredictiva[findIndex(x, noTerminales)][findIndex(a.getLexema().toString(), terminales)])!=0){
                    pila.pop();
                    String[] prod = ladoDerecho[produccion-1].split(" ");
                    for (int i = prod.length-1; i >= 0; i--) {
                        pila.push(prod[i]);
                    }
                }else{
                    System.err.println("ERROR SINTACTICO");
                }
            }else{
                if(x.equals(a.getLexema().toString())){
                    pila.pop();
                    a = analizadorLexico.getNextToken();
                }else{
                    System.err.println("ERROR SINTACTICO");
                }
            }
        }
    }
    
    
    private boolean contains(String[] set,String word){
        for(String s: set)
            if(s!=null) if(s.equals(word)) return true;
        return false;
    }
    
    private int findIndex(String word,String[] array){
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(word)) return i;
        }
        return index;
    }
}
