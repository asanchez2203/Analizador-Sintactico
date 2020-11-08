package Tablas;

import Tokens.Token;
import java.util.ArrayList;


public class TablaDeSimbolos1 {
    ArrayList <Fila> tsimbolos; //Tabla de simbolos a llenar
    ArrayList <Token> ttoken; //Tabla de Tokens
    Fila f;

    
    //Para crear la tabla de simbolos, se expota la tabla de Tokens
    public TablaDeSimbolos1(ArrayList<Token> ttoken) { 
        this.tsimbolos = new ArrayList();
        this.ttoken = ttoken; 
    }
    
    public ArrayList<Fila> tablaSimbolos(){
        ArrayList<Token> aux = primerTabla();
        
        for(Token to : aux){           
            f = new Fila(to.getLexema(), 
                        defineTipo(to), 
                        to.getID(), 
                        numeroLineas(aux, 
                        to.getID()), valor(to), 
                        numeroRepeticiones(aux, to.getID()),
                        to.getAtributo());
            tsimbolos.add(f);
        }
        
        for (int i = 0; i < tsimbolos.size(); i++) 
            for (int j = i+1; j < tsimbolos.size(); j++) 
                if(tsimbolos.get(i).getId() == tsimbolos.get(j).getId() 
                        && tsimbolos.get(j).getRepeticion() > 1)
                    tsimbolos.remove(j);

        return tsimbolos;
    }
    
    //Se filtra la tabla de Tokens para aquellos que tengan un atributo 
    //500, 501 y 502 que correponden a los identificadores y numero
    private ArrayList<Token> primerTabla(){
        ArrayList <Token> pt = new ArrayList();
        for(Token t :  ttoken) 
            if(t.getAtributo() >= 500 && t.getAtributo() <= 502) 
                pt.add(t);
        return pt;
    }
    
    //Define el tipo segun su numero de atributo
    private String defineTipo(Token t){
        if(t.getAtributo() == 500) return "INT";
        else return "REAL";
    }
    
    //Define en que lineas se ha encontrado el token
    private String numeroLineas(ArrayList<Token> at, float id){
        String lineas = "";
        
        for(Token t: at)
            if(t.getID() == id) lineas = lineas.concat(t.getLine()+",");
        
        return lineas;
    }
    
    //Define el numero de repeticiones por ID
    private int numeroRepeticiones(ArrayList<Token> at, float id){
        int n = 0;
        
        for(Token t: at)
            if(t.getID() == id) n++;
        
        return n;
    }
    
    //Define el valor del numero
    private float valor(Token t){
        if(t.getAtributo() == 500) return 0;
        else return Float.parseFloat((String)t.getLexema());
    }

    public ArrayList<Fila> getTsimbolos() {
        return tsimbolos;
    }

    public Fila getF() {
        return f;
    }

    
    
}


