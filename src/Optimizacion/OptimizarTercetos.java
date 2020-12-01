package Optimizacion;

import CodigoIntermedio.Terceto;
import java.util.ArrayList;

/**
 *
 * @author Alexis Sanchez
 * @author Andres Arellano
 * 
 * Optimización local
 * Método 4.- Intrucciones con expresiones algebraicas reducibles
 */
public class OptimizarTercetos {
    private ArrayList<Terceto> terceto;
    private ArrayList<Terceto> tercetosOptimizados;
    
    public OptimizarTercetos(ArrayList<Terceto> terceto){
        this.terceto = terceto;
        tercetosOptimizados = new ArrayList<>();
    }
    
    public void optimiza(){
        for(Terceto t : terceto){
            if(t.getOperador().equals("+") || t.getOperador().equals("-")){
                if(t.getY().trim().equals("0") || t.getX().trim().equals("0")){}
                else
                    tercetosOptimizados.add(t);
            }else if(t.getOperador().equals("*") || t.getOperador().equals("/")){
                if(t.getY().trim().equals("1") || t.getX().trim().equals("1")){}
                else
                    tercetosOptimizados.add(t);
            }else if(t.getOperador().equals("=")){
                if(t.getY().trim().equals("1") || t.getX().trim().equals("1")){}
                else if(t.getY().trim().equals("0") || t.getX().trim().equals("0")){}
                else
                    tercetosOptimizados.add(t);
            }
        }
        printNormal();
        System.out.println("");
        printOptimizado();
    }
    
    private void printOptimizado(){
        System.out.println("Terceto Optimizado");
        for (Terceto t : tercetosOptimizados) {
            System.out.println(t.getOperador() + " " + t.getX() + " " + t.getY());
        }
    }
    
    private void printNormal(){
        System.out.println("Terceto Normal");
        for (Terceto t : terceto) {
            System.out.println(t.getOperador() + " " + t.getX() + " " + t.getY());
        }
    }
}
