package test;

import List.Lista;
import List.Nodo;

/**
 *
 * @author Alexis Sanchez
 */
public class TestSeparador {
    public static void main(String[] args) {
        for(String s : palabras("aritop primary primarytail").getAsArray())
            System.out.println(s);
    }
    
    public static Lista palabras(String linea){
        int pointA=0,pointB=0;
        Lista lista = new Lista();
        while(pointB<linea.length()){
            System.out.println("Point A: "+ pointA +" - Point B: "+ pointB);
            if(linea.charAt(pointB)!=' ') {
                pointB++;
                if(pointB == linea.length()){
                    pointB = linea.length();
                    lista.agregarNodo(new Nodo(linea.substring(pointA, pointB)));
                    pointB++;
                    pointA=pointB;
                }
            } else{
                lista.agregarNodo(new Nodo(linea.substring(pointA, pointB)));
                pointB++;
                pointA=pointB;
            }
        }
        return lista;
    }
}
