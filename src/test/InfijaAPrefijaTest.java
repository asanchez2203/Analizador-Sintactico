package test;

import Lector.LectorPrograma;
import NotacionInfijaAPrefija.InfijaAPrefija;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class InfijaAPrefijaTest {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        Token t;
        ArrayList<Token> al = new ArrayList<>();
        while((t = analizador.getNextToken())!=null){
            al.add(t);
        }
        
        for (int i = 1; i <= x.length; i++) {
            //System.out.println("Entra");
            InfijaAPrefija conversor = new InfijaAPrefija(i, al);
            if(conversor.getExpresion() > 2){
                //System.out.println("Entra");
                conversor.printResultado(conversor.convertirExpresion());
            }
                
        }

    }
}
