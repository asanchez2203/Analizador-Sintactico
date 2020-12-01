package test;

import CodigoIntermedio.PorTercetos;
import Lector.LectorPrograma;
import Notaciones.InfijaAPosfija;
import Optimizacion.OptimizarTercetos;
import Tablas.Fila;
import Tablas.TablaDeSimbolos1;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class TestOptimizacion {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/optimizacion.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        Token t;
        ArrayList<Token> al = new ArrayList<>();
        while((t = analizador.getNextToken())!=null) al.add(t);
        
        /*TablaDeSimbolos1 ts = new TablaDeSimbolos1(al);
        System.out.println("\u001B[32mLexema\t        Tipo\t        ID\t        Linea\t        Valor\t     Repeticiones\t");
        System.out.println("\u001B[34m-----------------------------------------------------------------------------------------------");
        for(Fila f : ts.tablaSimbolos())System.out.println(f.imprimir());
        
        System.out.println("");
        */
        PorTercetos pt;
        
        for (int i = 1; i <= x.length; i++) {
            InfijaAPosfija conversor2 = new InfijaAPosfija(i, al);
            if(conversor2.getExpresion() > 2){
                System.out.println("\u001B[32m EXPRESION POSFIJA");
                conversor2.printResultado(conversor2.convertirExpresion());
                System.out.println("\u001B[32m TABLA DE TERCETOS");
                System.out.println("\u001B[34m -------------------");
                pt = new PorTercetos(conversor2.convertirExpresion());
                new OptimizarTercetos(pt.generacionTercetos()).optimiza();
                //pt.imprimir();
                System.out.println("\u001B[3m -------------------");
            }    
        }
    }
}
