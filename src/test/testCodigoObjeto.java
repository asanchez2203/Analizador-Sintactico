package test;

import CodigoIntermedio.PorTercetos;
import CodigoIntermedio.Terceto;
import CodigoObjeto.GenerarCodigoObjeto;
import Lector.LectorPrograma;
import Notaciones.InfijaAPosfija;
import Optimizacion.OptimizarTercetos;
import Tokens.AFN;
import Tokens.Token;
import java.util.ArrayList;

public class testCodigoObjeto {
    public static void main(String[] args) {
        LectorPrograma lp = new LectorPrograma("src/Programas/ejemplo.txt");
        String[] x = lp.extraerTexto();
        AFN analizador = new AFN(x);
        Token t;
        ArrayList<Token> al = new ArrayList<>();
        while((t = analizador.getNextToken())!=null) al.add(t);
        ArrayList<Token> filtrados = new ArrayList<>();
        for(Token tok: al){
            if(!filtra(filtrados,tok) && tok.getAtributo()==500){
                filtrados.add(tok);
            }
        }
        
        
        PorTercetos pt;
        ArrayList<Terceto> art;
        GenerarCodigoObjeto gco = new GenerarCodigoObjeto();
        gco.headers();
        gco.generaVariables(filtrados);
        gco.generaMetodoMain();
        
        for (int i = 1; i <= x.length; i++) {
            InfijaAPosfija conversor2 = new InfijaAPosfija(i, al);
            if(conversor2.getExpresion() > 2){
                ///System.out.println("\u001B[32m EXPRESION POSFIJA");
                //conversor2.printResultado(conversor2.convertirExpresion());
                //System.out.println("\u001B[32m TABLA DE TERCETOS");
                //System.out.println("\u001B[34m -------------------");
                pt = new PorTercetos(conversor2.convertirExpresion());
                art = new OptimizarTercetos(pt.generacionTercetos()).optimiza2();
                
                //pt.imprimir();
                //System.out.println("\u001B[3m -------------------");
               
               gco.generaCodigo(art);
               //System.out.println("\u001B[3m -------------------");
            }    
        }
        
        gco.setFinal();
    }
    
    private static boolean filtra(ArrayList<Token> uno,Token t){
        for(Token to : uno )
            if(to.getLexema().toString().equals(t.getLexema().toString()))
                return true;
        return false;
    }
}
