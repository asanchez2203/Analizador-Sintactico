package LLDriver;

import Pila.Node;
import Pila.Stack;
import java.io.IOException;
import Estructura.EstructurasEstaticas;
import Lector.LectorPrograma;
import Tokens.AFN;
import MatrizPredictiva.MatrizPredictiva;
import Tokens.Token;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
    private final String gramaticaPath = "src/Archivos/gramatica.txt";
    
    public LLDriver(String filePath) throws IOException{
        pila = new Stack();
        EstructurasEstaticas estructuras = new EstructurasEstaticas(gramaticaPath);
        ladoDerecho = estructuras.llenadoDerecho(estructuras.contenido(gramaticaPath));
        noTerminales = estructuras.llenadoNoTerminales(estructuras.contenido(gramaticaPath));
        terminales = estructuras.llenadoTerminales(ladoDerecho);
        matrizPredictiva = new MatrizPredictiva(noTerminales, terminales).getMatrizPredictiva();
        
        LectorPrograma lp = new LectorPrograma(filePath);
        String[] lineasPrograma = lp.extraerTexto();
        analizadorLexico = new AFN(lineasPrograma);
    }
    
    public void run(){
        pila.push("$"); // Poner el simbolo inicial en la pila vacia
        pila.push("inicio"); // Poner el simbolo inicial en la pila vacia
        String x = noTerminales[0];
        Token a = analizadorLexico.getNextToken();
        int produccion;
        
        while(!pila.isEmpty()){
            System.out.println("X = " + x);
            System.out.println("a = " + a.getTipo() +" --"+ a.getLexema().toString());
            if(contains(noTerminales, x)){
                System.out.println("Se encontró " + x + " en los noTerminales");
                if(matrizPredictiva[findIndex(x, noTerminales)][findIndex(a.getTipo(), terminales)]!=0){
                    System.out.println("Se encontró interseccion entre x=" + x + " y a="+ a.getTipo()+" en la matriz Predictiva");    
                    produccion = matrizPredictiva[findIndex(x, noTerminales)][findIndex(a.getTipo(), terminales)];
                    System.out.println("Matriz predictiva: " + produccion);
                    pila.pop();
                    String[] prod = ladoDerecho[produccion-1].split(" ");
                    for (int i = prod.length-1; i >= 0; i--) if(!"".equals(prod[i])) pila.push(prod[i]);
                    x = pila.peek().getInfo().toString();
                }else{
                    System.out.println("*************************ERROR SINTACTICO*****************************");
                    JOptionPane.showMessageDialog(null, "ERROR SINTACTICO DETECTADO","ERROR",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }else{
                System.out.println("No se encontró x=" + x + " en los noTerminales");
                if(x.equals(a.getTipo())){
                    System.out.println("Se encontró que X=" + x + " es igual a a="+ a.getTipo()+" en los noTerminales");
                    pila.pop();
                    if(!analizadorLexico.endFile()){
                        a = analizadorLexico.getNextToken();
                        while(a==null){a = analizadorLexico.getNextToken();}
                    }else break;
                    
                    //while((a = analizadorLexico.getNextToken())!=null){}
                    x = pila.peek().getInfo().toString();
                }else{
                    System.out.println("*************************ERROR SINTACTICO*****************************");
                    JOptionPane.showMessageDialog(null, "ERROR SINTACTICO DETECTADO","ERROR",JOptionPane.ERROR);
                    break;
                }
            }
            System.out.println("************* INICIO PILA");
            pila.printStack();
            System.out.println("************* FINAL FIN PILA");
            System.out.println("");
            //new Scanner(System.in).nextLine();
        }
        System.out.println("**********PILA FINAL");
        pila.printStack();
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
