/*
    CLASE Nodo
    Empleando la teoría de la Estructura de Datos lista, se creo esta clase, 
ajustandose a las necesidades del programa,
*/
package DataStructure;

/**
 * @author Andres Arellano
 * @author Alexis Sanchez
 */

public class Nodo {
    private Object info; //Contenido del nodo
    private Nodo siguienteNodo; //Siguiente
    
    //Constructor de la clase
    public Nodo(Object informacion){
        this.info = informacion;
        siguienteNodo = null;
    }
    
    //Constructor de la clase, con parametros
    public Nodo(Object informacion,Nodo siguiente){
        this.info = informacion;
        this.siguienteNodo = siguiente;
    }
    
    //Regresa el nodo
    public Nodo siguienteNodo(){
        return siguienteNodo;
    }
    
    //Establece un nodo como siguiente
    public void siguienteNodo(Nodo nodo){
        this.siguienteNodo = nodo;
    }
    
    //Regresa información del nodo
    public Object getInfo() {
        return info;
    }
}
