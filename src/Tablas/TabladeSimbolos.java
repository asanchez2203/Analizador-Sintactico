
package Tablas;

import Tokens.Token;
import java.util.ArrayList;

public class TabladeSimbolos {
    ArrayList lista;
    ArrayList <Token> at;
    
    public TabladeSimbolos(ArrayList <Token> at){
        lista = new ArrayList();
        this.at = at;
    }
    
    public ArrayList tablasimbolos(){
        
        return at;
    }
}
