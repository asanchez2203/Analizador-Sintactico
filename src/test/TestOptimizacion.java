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
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        Token t;
        ArrayList<Token> al = new ArrayList<>();
        while((t = analizador.getNextToken())!=null) al.add(t);
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
