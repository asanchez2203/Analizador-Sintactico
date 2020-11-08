package test;

import Lector.LectorPrograma;
import Tablas.Fila;
import Tablas.TablaDeSimbolos1;
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
        while((t = analizador.getNextToken()) != null) aux.add(t);
     
        TablaDeSimbolos1 ts = new TablaDeSimbolos1(aux);
        System.out.println("\u001B[32mLexema\t        Tipo\t        ID\t        Linea\t        Valor\t     Repeticiones\t");
        System.out.println("\u001B[34m-----------------------------------------------------------------------------------------------");
        for(Fila f : ts.tablaSimbolos())System.out.println(f.imprimir());
        
    }
}
