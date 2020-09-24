/*
    Clase Token
    Un Token es una agrupación de caracteres pertenecientes a alguna
        clasificación léxica. 

    Está formado por un lexema y un atributo
 */
package Tokens;

/**
 * @author Andres Arellano
 * @author Alexis Sanchez
 */
public class Token {
    protected int atributo;
    protected Object lexema;
    private int ID;
    
    public Token(int atributo, Object lexema){
        this.atributo = atributo;
        this.lexema = lexema;
        this.ID=0;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public Object getLexema() {
        return lexema;
    }

    public void setLexema(Object lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        String tipo="";
        if(atributo>255){
            switch(atributo){
            case 404: tipo= "Error"; break;
            case 500: tipo= "Identificador"; break;
            case 501: tipo= "Numero Natural"; break;
            case 502: tipo= "Numero de Punto Flotante"; break; 
        }
        }else{ tipo = "Simbolo";}
        if(atributo>=300 && atributo<=303) tipo="Palabra reservada";
        return "\033[32m LEXEMA: " + "\033[30m" +(String) lexema + 
               "\033[32m ATRIBUTO: " + "\033[30m" + String.valueOf(atributo) + 
               "\033[32m TOKEN: " + "\033[30m" + tipo +
               "\033[32m TIPO: " + "\033[30m" + Character.getName(atributo);
    }
    
    public String getTipo(){
        if(atributo==404) return "Error";
        if(atributo==500) return "id";
        if(atributo==501) return "intliteral";
        if(atributo==502) return "realliteral";
        if(atributo==503) return ":=";
        if(atributo>=1 && atributo<=256) return lexema.toString();
        if(atributo>=300 && atributo <=303) return lexema.toString();
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
