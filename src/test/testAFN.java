package test;

import Lector.LectorPrograma;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;
import Cronometro.Cronometro;

public class testAFN {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        Cronometro c = new Cronometro();
        
        c.tiempoIncio();
        AFN analizador = new AFN(x);
        ArrayList <Token> al = analizador.getListaToken();
        c.tiempoFinal();
        c.resultado(c.tiempoTotal());
        
    }
}
