package test;

import Lector.LectorPrograma;
import Tablas.Fila;
import Tablas.TablaDeSimbolos;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

public class TestTablaDeSimbolos {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        
        Token t;
        ArrayList<Token> aux = new ArrayList();
        //Llenado de la tabla de Tokens
        while((t = analizador.getNextToken()) != null) aux.add(t);
     
        TablaDeSimbolos ts = new TablaDeSimbolos(aux);
        for(Fila f : ts.tablaSimbolos()) System.out.println(f.imprimir());
    }
}
