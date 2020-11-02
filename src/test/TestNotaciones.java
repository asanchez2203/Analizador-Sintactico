package test;

import Lector.LectorPrograma;
import Notaciones.InfijaAPosfija;
import Notaciones.InfijaAPrefija;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class TestNotaciones {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        Token t;
        ArrayList<Token> al = new ArrayList<>();
        while((t = analizador.getNextToken())!=null){
            al.add(t);
        }
        System.out.println("-------- NOTACIÓN PRESFIJA --------");
        for (int i = 1; i <= x.length; i++) {
            InfijaAPrefija conversor = new InfijaAPrefija(i, al);
            if(conversor.getExpresion() > 2){
                conversor.printResultado(conversor.convertirExpresion());
            }      
        }
        System.out.println("-------- NOTACIÓN POSFIJA --------");
        for (int i = 1; i <= x.length; i++) {
            InfijaAPosfija conversor2 = new InfijaAPosfija(i, al);
            if(conversor2.getExpresion() > 2){
                conversor2.printResultado(conversor2.convertirExpresion());
            }      
        }

    }
}
