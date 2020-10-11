package test;

import ComprobacionTipos.ComprobacionTipos;
import Lector.LectorPrograma;
import Tablas.TablaDeSimbolos1;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class TestComprobacionTipos {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        
        Token t;
        ArrayList<Token> aux = new ArrayList();
        //Llenado de la tabla de Tokens
        while((t = analizador.getNextToken()) != null) aux.add(t);
     
        //TablaDeSimbolos1 ts = new TablaDeSimbolos1(aux);
        ComprobacionTipos comprueba = new ComprobacionTipos(aux);
        comprueba.analiza();
    }
}
