package ComprobacionTipos;

import Tablas.Fila;
import Tokens.Token;
import java.util.ArrayList;

public class ComprobacionTipos {
    
    private final ArrayList<Token> tablaToken;
    private final ArrayList<Fila> tablaSimbolos;
    ArrayList<Token> triada;

    public ComprobacionTipos(ArrayList<Token> tablaToken, ArrayList<Fila> tablaSimbolos) {
        this.tablaToken = tablaToken;
        this.tablaSimbolos = tablaSimbolos;
    }
    
    //Genera triadas segun el numero de la linea en que aparezcan los tokens
    public ArrayList<Token> triada(int line){
        triada = new ArrayList();
    
        for(Token t : tablaToken) if(t.getLine() == line) triada.add(t);
        
        return triada;
    }
    
    public String compruebaTipos(Token t1, Token t2){
        //500 = Identificador, 501 = Numero natural, 502 Numero flotante
        //Si el primero es INT
        switch (t1.getAtributo()) {
            case 500: 
                if(t2.getAtributo() == 500 || 
                        t2.getAtributo() == 501) return "INT"; //INT - INT = INT
                else return "REAL"; //INT - REAL = INT
            case 501:
                if(t2.getAtributo() == 500 || 
                        t2.getAtributo() == 501) return "INT";//INT - INT = INT
                else return "REAL"; //INT - REAL = INT
            case 502:
                if(t2.getAtributo() == 502) return "INT";//INT - INT = INT
                else return "REAL"; //INT - REAL = INT
            default:
                return "ERROR SEMANTICO";
        }
    }
    
    public void addExpresion(){
        
    }
    
    private boolean isReal(float value){
        //Regresa True si es Entero, False si es flotante
        return value % 1 == 0;
    }
}
