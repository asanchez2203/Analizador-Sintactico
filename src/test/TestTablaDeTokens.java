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
            //BLOQUE QUE CUENTA LAS REPETICIONES
            n = 0;
            for(Token z : al) if(z.getLexema().equals(t.getLexema())) n++;
            // FIN BLOQUE QUE CUENTA REPETICIONES
            
//            //ASIGNAR ID UNICO
//            int idToken;
//            if((idToken = exists(tokenWithID,t)) > 0){ //BUSCAR EL TOKEN, SI EXISTE 
//                // OBTENER EL ID DEL SIMILAR Y PONERLO AL TOKEN
//                t.setID(idToken);
//            }else{ //SINO SE ENCUENTRA
//                tokenWithID.add(t); //AGREGALO A LA LISTA
//                t.setID(id); //ASIGNALE EL ID SIGUIENTE
//                id++; //AUMENTA EL ID
//            }
            //IMPRIME
            System.out.println(t.toString() + "\033[32m REPETICION: " + "\033[30m" +n );
        }
    }
    
//    private static int exists(ArrayList<Token> list,Token token){
//        for(Token z : list)
//            if(z.getLexema().equals(token.getLexema())) return z.getID();
//        return 0;
//    }

}