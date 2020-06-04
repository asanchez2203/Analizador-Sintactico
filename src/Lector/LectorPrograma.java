/*
 *Clase Lector Programa
    Esta clase tiene como motivo extraer las cadenas de archivo de texto para
    su analisis lexico.
 */
package Lector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alexis Sanchez
 * @author Andres Arellano
 */
public class LectorPrograma {
    //Ruta donde se encuentra el archivo
    private final String ruta; 
    //Lector del archivo
    private BufferedReader lector;
    private FileReader fr;
    
    
    //Constructor de la clase
    public LectorPrograma(String ruta){
        this.ruta = ruta;
    }
    
    //Metodo para abrir el archivo
    public void abrirArchivo(){
        try{
            //Se crea el objeto para leer el archivo
            fr = new FileReader(ruta);
            lector = new BufferedReader(fr);
        }catch(FileNotFoundException e){
            //Mensaje de error por si no se puede acceder al archivo
            System.err.println("No se ha podido encontrar el archivo " 
                    + e.getMessage());
        }
    }
    
    //Metodo para cerrar el archivo
    public void cerrarArchivo(){
        try{
            //Se cierra el lector
            lector.close();
        }catch(IOException e){
            //Mensaje de error si no se puede cerrar el archivo
            System.err.println("No se ha podido cerrar el archivo " 
                    + e.getMessage());
        }
        
    }
    
    //Metodo para extraer las caadenas de texto del archivo
    public String[] extraerTexto(){
        //Variable auxiliar para almacenear las lineas de texto
        String[] cadenas = null;
        int cont = 0;
       
        try{
            //Se abre el archivo
            abrirArchivo();
            //Se cuentan las lineas que contenga el archivo
            while(lector.readLine() != null) cont ++;
            //Se inicializa el array que contendra las lineas de texto
            cadenas = new String[cont];
            
            //Se almacenan las lineas en el array
            //Se re-instancian los objetos para poder leer el archivo
            abrirArchivo();
            for (int i = 0; i < cadenas.length; i++) 
                cadenas[i] = lector.readLine();
            //Se cierra el archivo
            cerrarArchivo();
        }catch(IOException e){
            System.err.println("Algo salio mal... " + e);
        } 
        return cadenas;
    } 
}
