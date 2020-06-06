package test;

import Lector.LectorPrograma;
import Tokens.AFN;
import Tokens.Token;

/**
 *
 * @author Alexis Sanchez
 */
public class TestCambiosAnalizadorLexico {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/programa.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        
        Token t;
        while((t = analizador.getNextToken())!=null){
            System.out.println(t.toString());
        }
    }
}