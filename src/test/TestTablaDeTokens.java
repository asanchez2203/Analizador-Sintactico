package test;

import Lector.LectorPrograma;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class TestTablaDeTokens {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        int n;
        ArrayList <Token> al = analizador.getListaToken();
//        ArrayList <Token> tokenWithID = new ArrayList<>();
        
        Token t;
        while((t = analizador.getNextToken())!=null){
            n = 0;
            for(Token z : al) if(z.getLexema().equals(t.getLexema())) n++;
            System.out.println(t.toString() + "\033[32m REPETICION: " + "\033[30m" +n );
        }
    }
}