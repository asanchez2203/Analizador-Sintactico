package test;

import Util.Lector;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis Sanchez
 */
public class TestLector {
    public static void main(String[] args) throws IOException {
        Lector lector = new Lector("src/Archivos/gramatica.txt");
        String line = null;
        while((line=lector.readLine())!=null){
            System.out.println(line);
        }
    }
}
