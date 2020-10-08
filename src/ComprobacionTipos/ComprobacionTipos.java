package ComprobacionTipos;

import Tablas.Fila;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 */
public class ComprobacionTipos {
    
    private final ArrayList<Fila> tabla;
    
    public ComprobacionTipos(ArrayList<Fila> tabla){
         this.tabla = tabla;
    }
    
    public void compruebaTipos(){
        
    }
    
    public void addExpresion(){
        
    }
    
    private boolean isReal(float value){
        //Regresa True si es Entero, False si es flotante
        return value % 1 == 0;
    }
}
