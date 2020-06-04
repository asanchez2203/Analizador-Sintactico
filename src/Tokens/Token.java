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
    
    public Token(int atributo, Object lexema){
        this.atributo = atributo;
        this.lexema = lexema;
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
            case 502: tipo= "Numero De Punto Flotante"; break; 
        }
        }else{ tipo = "Simbolo";}
        if(atributo>=300 && atributo<=303) tipo="PALABRA RESERVADA";
        return "Lexema: " +(String) lexema + " Atributo: " +String.valueOf(atributo) +" " +tipo;
    }
    
}
