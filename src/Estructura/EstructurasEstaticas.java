/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Util.Lector;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class EstructurasEstaticas {
    ArrayList<String> terminales, noTerminales, ladoDerecho, cont;

    public EstructurasEstaticas() {
        this.terminales = new ArrayList();
        this.noTerminales = new ArrayList();
        this.ladoDerecho = new ArrayList();
        this.cont = new ArrayList();
    }
    
    public ArrayList<String> contenido(String filePath) throws IOException {
        Lector lector = new Lector(filePath);
        String line;

        while ((line = lector.readLine()) != null) cont.add(line);
        
        return cont;
    }
    
    public ArrayList<String> llenadoDerecho(ArrayList <String> cont){
        for (int i = 0; i < cont.size(); i++) {
            String aux1 = cont.get(i).split("->")[1].trim();
            ladoDerecho.add(aux1);
        }
        return ladoDerecho;
    }
    
    public ArrayList<String> llenadoNoTerminales(ArrayList <String> cont){
        for (int i = 0; i < cont.size(); i++) {
            String aux1 = cont.get(i).split("->")[0].trim();
            if(!noTerminales.contains(aux1)) noTerminales.add(aux1);
        }
        return noTerminales;
    }
    
    public ArrayList<String> llenadoTerminales(ArrayList <String> ladoDerecho){
        for (int i = 0; i < ladoDerecho.size(); i++) {
            if(ladoDerecho.get(i).contains(" ")){
                String[] aux = ladoDerecho.get(i).split(" ");
                for (String aux1 : aux) {
                    if (!terminales.contains(aux1) && 
                            !noTerminales.contains(aux1)) 
                        terminales.add(aux1);
                }  
            }else if(!ladoDerecho.get(i).equals("")){
                if (!terminales.contains(ladoDerecho.get(i)) && 
                            !noTerminales.contains(ladoDerecho.get(i))) 
                        terminales.add(ladoDerecho.get(i));
            }
        }
        return terminales;
    }
    
    public void impresion(ArrayList <String> x){
        for (int i = 0; i < x.size(); i++) System.out.println(x.get(i));
    }
    
}
