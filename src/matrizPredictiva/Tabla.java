/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizPredictiva;

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
    private Stack ladoProduccion;
    private ArrayList<String> cont;

    public ArrayList<String> contenido(String filePath) throws IOException {
        cont = new ArrayList();
        Lector lector = new Lector(filePath);
        String line = null;

        while ((line = lector.readLine()) != null) {
            cont.add(line);
        }

        return cont;
    }

    public Stack llenadoNoTerminales(ArrayList<String> cont) {
        noTerminales = new Stack();

        for (int i = 0; i < cont.size(); i++) {
            String aux1 = cont.get(i).split("->")[0];
            if (noTerminales.isEmpty()) {
                noTerminales.push(aux1);
            } else if (noTerminales.trace(aux1)) {
                noTerminales.push(aux1);
            }
        }

        return noTerminales;
    }

    public Stack llenadoTerminales(ArrayList<String> cont) {
        terminales = new Stack();
        String[] array;
        String aux1, aux2 = "";

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

}
