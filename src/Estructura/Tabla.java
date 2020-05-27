/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Pila.Node;
import Pila.Stack;
import Util.Lector;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Tabla {

    private Stack terminales;
    private Stack noTerminales;
    private Stack ladoDerecho;
    private ArrayList<String> cont;

    public Tabla(){
        this.terminales = new Stack();
        this.noTerminales = new Stack();
        this.ladoDerecho = new Stack();
        this.cont = new ArrayList();
    }
    public ArrayList<String> contenido(String filePath) throws IOException {
        Lector lector = new Lector(filePath);
        String line = null;

        while ((line = lector.readLine()) != null) {
            cont.add(line);
        }

        return cont;
    }
    
    public Stack llenadoDerecho(ArrayList <String> cont){
        for (int i = 0; i < cont.size(); i++) {
            String aux1 = cont.get(i).split("->")[1].trim();
            ladoDerecho.push(aux1);
        }
        return ladoDerecho;
    }

    public Stack llenadoNoTerminales(ArrayList<String> cont) {
        for (int i = 0; i < cont.size(); i++) {
            String aux1 = cont.get(i).split("->")[0].trim();
            if (noTerminales.isEmpty()) {
                noTerminales.push(aux1);
            } else if (noTerminales.trace(aux1)) {
                noTerminales.push(aux1);
            }
        }
        return noTerminales;
    }

    public Stack llenadoTerminales(ArrayList<String> cont) {
        for (int i = 0; i < ladoDerecho.size(); i++) {
            Node n = ladoDerecho.getBase();
            while(n != null){
                String aux = n.getInfo().toString();
                if(!aux.contains(" ")){
                    if(noTerminales.trace(aux.trim())) {
                        if(terminales.isEmpty()) terminales.push(aux);
                        else if(terminales.trace(aux)) terminales.push(aux);
                    } 
                }else if(aux.contains(" ")){
                    String[] aux1 = aux.split(" ");
                    for (String aux11 : aux1) {
                        if (noTerminales.trace(aux11.trim())) {
                            if(terminales.isEmpty()) terminales.push(aux11);
                        else if(terminales.trace(aux11)) terminales.push(aux11);
                        }
                    }
                }
                n = n.getNext();
            }     
        }
//        for (int i = 0; i < cont.size(); i++) {
//            if(cont.get(i).split("->")[1] == null) aux1 = "";
//            else  aux1 = cont.get(i).split("->")[1].replace(" ", "");
//            Node n = noTerminales.getBase();
//            while(n != null){
//                if(aux1.contains(n.getInfo().toString())){
//                    aux2 = aux1.split(n.getInfo().toString());
//                }
//                System.out.println(aux2);
//                n = n.getNext();
//            }
//            
//            while(n != null){
//                if(aux1.contains(n.getInfo().toString())){
//                    
//                }
//            }
//            for (int j = 0; j < array.length; j++) {
//                if(array[j]==null) j++;
//                System.out.println(array[j]);
//                if(array[j].equals(" ")) j++;
//                Node n = noTerminales.getBase();
//                while(n != null){
//                    System.out.println("Voy a comparar " + array[i] + " y " + n.getInfo().toString());
//                    if(array[i].equals(n.getInfo().toString())){
//                        i++;
//                        break;
//                    }
//                    n = n.getNext();
//                }
//                terminales.push(array[i]);
        return terminales;
    }
    
    public String[] arregloLadoDerecho(Stack s){
        Stack nueva;
        Node no;
        
        nueva = new Stack();
        no = s.getBase();
        while(no != null){
            nueva.push(no.getInfo());
            no = no.getNext();
        }
        
        String[] aux = new String[nueva.size()];
        no = nueva.getBase();
        for (int i = 0; i < aux.length; i++) {
            aux[i] = no.getInfo().toString();
            if(no.getNext() != null) no = no.getNext();
        }
            
        return aux;
    }
    
    public String[] arregloEstatico(Stack s){
        Stack nueva;
        Node no;
        
        nueva = new Stack();
        no = s.getBase();
        while(no != null){
            if(!no.getInfo().equals("")) nueva.push(no.getInfo());
            no = no.getNext();
        }
        
        String[] aux = new String[nueva.size()];
        no = nueva.getBase();
        for (int i = 0; i < aux.length; i++) {
            aux[i] = no.getInfo().toString();
            if(no.getNext() != null) no = no.getNext();
        }
            
        return aux;
    }
    
    public void imprimeArreglo(String[] s){
        for (String item : s) System.out.println(item);
    }

}
