/*
    CLASE LISTA
    Empleando la teoría de la Estructura de Datos lista, se creo esta clase
con el mismo nombre, ajustandose a las necesidades del programa,
*/
package DataStructure;

import Tokens.Token;

/**
 * @author Andres Arellano
 * @author Alexis Sanchez
 */
public class Lista {

    private Nodo inicio; //Nodo de la lista
    private int n; //Variable para contar los nodos

    //Constructor de la clase
    public Lista(Nodo inicio) {
        this.inicio = inicio;
        n = 0;
    }
    
    //Agrega un nodo a la lista
    public void agregarNodo(Nodo nodo) {
        if (inicio == null) { //Se agrega el primer nodo
            inicio = nodo;
        } else {
            Nodo UltimoNodo = inicio; //Se agregan nodos
            while (UltimoNodo.siguienteNodo() != null) {
                UltimoNodo = UltimoNodo.siguienteNodo();
            }
            UltimoNodo.siguienteNodo(nodo);
        }
    }

//    public void imprimeInformacionNodos() {
//        Nodo UltimoNodo = inicio;
//        while (UltimoNodo != null) {
//            Token tk = (Token) UltimoNodo.getInfo();
//            System.out.println("**" + tk.toString());
//            UltimoNodo = UltimoNodo.siguienteNodo();
//        }
//    }

    //Imprime los tokens cuyo atributo no sea mayor a 100
    public void imprimeTokens() {
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if(tk.getAtributo()!=404)
                System.out.println("**" + tk.toString());
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
    }
    
    public void imprimeIdentificadores() {
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if(tk.getAtributo()>400 && tk.getAtributo()!=404)
                System.out.println("**" + tk.toString());
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
    }
    
    //Imprime los simbolos
    public void imprimeSimbolos() {
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if((tk.getAtributo() < 100) && tk.getAtributo() != 1)
                System.out.println("**" + tk.toString());
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
    }
    
    //Imprime las palabras reservadas
    public void imprimeReservadas() {
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if(tk.getAtributo() == 300 || tk.getAtributo() == 301 || tk.getAtributo() == 302)
                System.out.println("**" + tk.toString());
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
    }
    
    //Imprime los errores obtenidos
    public void imprimeError() {
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if(tk.getAtributo() == 404)
                System.out.println("**" + tk.toString());
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
    }

    //Regresa el tamaño de la lista
    public int size() {
        while (inicio.siguienteNodo() != null) n++;
        return n;
    }
    
    //Regresa el nodo actual
    public Nodo getInicio() {
        return inicio;
    }
    
    public boolean existe(Token t){
        Nodo UltimoNodo = inicio;
        while (UltimoNodo != null) {
            Token tk = (Token) UltimoNodo.getInfo();
            if(tk.getLexema().toString().equals(t.getLexema().toString()))
                return true;
            UltimoNodo = UltimoNodo.siguienteNodo();
        }
        return false;
    }
}
