package Estructura;

import Lector.LectorPrograma;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class EstructurasEstaticas {
    String[] terminales, noTerminales, ladoDerecho, cont;
    int nLineas=0; 
    
    public EstructurasEstaticas(String filePath) {
        nLineas = new LectorPrograma(filePath).extraerTexto().length;
        this.terminales = new String[nLineas];
        this.noTerminales = new String[nLineas];
        this.ladoDerecho = new String[nLineas];
    }
    
    public String[] contenido(String filePath) throws IOException {
        cont = new LectorPrograma(filePath).extraerTexto();
        return cont;
    }
    
    public String[] llenadoDerecho(String[] cont){
        for (int i = 0; i < cont.length; i++) {
            if(cont[i]!=null){
                String aux1 = cont[i].split("->")[1].trim();
                ladoDerecho[i]=aux1;
            } 
        }
        return ladoDerecho;
    }
    
    public String[] llenadoNoTerminales(String[] cont){
        int pointer=0;
        for (int i = 0; i < cont.length; i++) {
            if(cont[i]!=null){
                String aux1 = cont[i].split("->")[0].trim();
                if(!contains(noTerminales,aux1)){
                     noTerminales[pointer]=aux1;
                     pointer++;
                }
            }
        }
        String[] noTerminalesFinal = new String[pointer];
        for(int i=0;i<pointer;i++) noTerminalesFinal[i] = noTerminales[i];
        return noTerminalesFinal;
    }
    
    public String[] llenadoTerminales(String[] ladoDerecho){
        int pointer=0;
        for (int i = 0; i < ladoDerecho.length; i++) {
            if(ladoDerecho[i]!=null){
                if(ladoDerecho[i].contains(" ")){
                    String[] aux = ladoDerecho[i].split(" ");
                    for (String aux1 : aux) {
                        if (!contains(terminales,aux1) && 
                                !contains(noTerminales,aux1)) {
                            terminales[pointer] = aux1;
                            pointer++;
                        }
                    }  
                }else if(!ladoDerecho[i].equals("")){
                    if (!contains(terminales,ladoDerecho[i]) && 
                                !contains(noTerminales,ladoDerecho[i])){
                        terminales[pointer] = ladoDerecho[i];
                        pointer++;
                    }
                }
            }
        }
        String[] terminalesFinal = new String[pointer];
        for(int i=0;i<pointer;i++) terminalesFinal[i] = terminales[i];
        return terminalesFinal;
    }
    
    public void impresion(String[] x){
        for (int i = 0; i < x.length; i++) /*if(x[i]!=null)*/ System.out.println(x[i]);
    }
    
    private boolean contains(String[] array,String word){
        for(String s: array)
            if(s!=null) if(s.equals(word)) return true;
        return false;
    }
}
