/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Util.Lector;
import java.io.IOException;

/**
 *
 * @author andre
 */
public class EstructurasEstaticas {
    String[] terminales, noTerminales, ladoDerecho, cont;

    public EstructurasEstaticas(String filePath) {
        int nLineas=0;     
        try {
            nLineas = new Lector(filePath).numLineas();
        } catch (Exception e) { }
        this.terminales = new String[nLineas];
        this.noTerminales = new String[nLineas];
        this.ladoDerecho = new String[nLineas];
        this.cont = new String[nLineas];
    }
    
    public String[] contenido(String filePath) throws IOException {
        Lector lector = new Lector(filePath);
        String line;

        for(int i=0;i<cont.length;i++){
            line=lector.readLine();
            cont[i]=line;
        }
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
        return noTerminales;
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
        return terminales;
    }
    
    public void impresion(String[] x){
        for (int i = 0; i < x.length; i++) if(x[i]!=null) System.out.println(x[i]);
    }
    
    private boolean contains(String[] array,String word){
        for(String s: array)
            if(s!=null) if(s.equals(word)) return true;
        return false;
    }
}
