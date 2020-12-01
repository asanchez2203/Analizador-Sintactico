package Cronometro;

public class Cronometro {
    private long s, f;
    
    /*
    Meta: Hacer un programa que permita saber el tiempo de ejecución de 
            cualquier programa.
    */
    public void tiempoIncio(){
        s = System.currentTimeMillis();
    }
    
    public void tiempoFinal(){
        f = System.currentTimeMillis();
    }
    
    public long tiempoTotal(){
        return f - s;
    }
    
    public void resultado(long l){
        System.out.print("Tiempo de ejecución: " + l + " ms");
    }
         
}
