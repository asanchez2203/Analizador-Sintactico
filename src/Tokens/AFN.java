/*
    CLASE AFN
    Clase que modela el funcionamiento del analizador lexico
*/
package Tokens;

import java.util.ArrayList;

public class AFN {
    private int edo; //indicador de estado
    private int pointA, pointB; //Punteros de la cadena
    int pointerLineas;
    String[] lineas;
    Token t = null;
    ArrayList <Token> listaToken;
    int auxID = 600;
    int signID = 50;
    int line = 1;
    
    //Array para simbolos
    private char[] cs = {';', '+', '-', '*', '(', ')', '='};
    
    //Array para palabras reservadas
    private final PalabraReservada[] reservadas = {new PalabraReservada(300, "program")
            ,new PalabraReservada(301, "begin"), new PalabraReservada(302, "end")};
    
    public AFN(String[] lineas){
        this.edo = 0;
        pointA = 0;
        pointB = 0;
        this.lineas = lineas;
        this.pointerLineas = 0;
        listaToken = new ArrayList();
    }
    
    //Metodo que modela el funcionamiento del AFN diseñado para el
    //analizador lexico
    public Token afnToken(String cadena){ 
        switch(edo){   
            case 0:
                //IF PARA IDENTIFICADORES
                if(esEspacio(cadena)){
                    pointB++;
                    pointA = pointB;
                }
                else if(esLetraMayuscula(cadena)){
                    edo = 1;
                    pointB++; 
                } 
                //IF PARA NUMEROS
                else if(esNumero(cadena)){
                    edo = 5;
                    pointB++;
                } 
                //IF PARA SIMBOLOS
                else if(esSimbolo(cadena.charAt(pointB))){
                    if(esFinalDeLinea(cadena)) {edo = 8;}
                    else edo = 8;                  
                }           
                //IF PARA PALABRAS RESERVADAS
                else if (esLetraMinuscula(cadena)){
                    edo=9;
                    //pointB++;
                }
                else if(esDosPuntos(cadena)){
                    edo = 11;
                    pointB++;
                }
                //IF PARA ERRORES
                else edo = 10;     
                break;
            //ESTADO PARA IDENTIFICADORES
            case 1: 
                if(esLetraMinuscula(cadena) || esNumero(cadena)){
                    edo = 2;
                    if(esFinalDeLinea(cadena)){
                        edo = 10;
                        break;
                    }
                    pointB++;
                }else if(esGuionBajo(cadena)){
                    edo = 3;
                    pointB++;
                } else{
                    edo = 10; 
                }
                break;
            case 2:
                if(esLetraMinuscula(cadena) || esNumero(cadena)){
                    edo = 2;
                    if(esFinalDeLinea(cadena)){
                        pointB=cadena.length();
                        if(esSimbolo(cadena.charAt(pointB-1))){
                            --pointB;
                        }
                        if(buscaID(cadena.substring(pointA,pointB)) > 0){
                            t = generarToken(cadena.substring(pointA,pointB), 500, buscaID(cadena.substring(pointA,pointB)), line);
                            listaToken.add(t);
                            actualizaApuntadores();
                            return t;
                        }
                        t = generarToken(cadena.substring(pointA,pointB), 500, auxID, line);
                        auxID++;
                        listaToken.add(t);
                        actualizaApuntadores();
                        return t;
                    }
                    pointB++;
                }else if(esGuionBajo(cadena)){
                    edo = 3;
                    pointB++;
                }else {
                    if(esSimbolo(cadena.charAt(pointB-1))){
                        --pointB;
                    }
                    t = generarToken(cadena.substring(pointA,pointB), 500, auxID, line);
                    auxID++;
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;
                }
                break;    
            case 3:
                if (esLetraMinuscula(cadena)|| esNumero(cadena)){
                    edo = 4;
                    pointB++;
                }
                else{
                    edo = 10; 
                }
             break;
            case 4:
                if(esLetraMinuscula(cadena) || esLetraMayuscula(cadena)){
                    edo=4;
                    pointB++;
                }else if (esGuionBajo(cadena)){
                    edo=3;
                    pointB++;
                }else{
                    if(esSimbolo(cadena.charAt(pointB-1))){
                        --pointB;
                    }
                    t = generarToken(cadena.substring(pointA,pointB), 500, auxID, line);
                    auxID++;
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;
                }
                break;
            case 5:
                if(esNumero(cadena)){
                    if(esFinalDeLinea(cadena) || esEspacio(cadena)){
                        if(esFinalDeLinea(cadena))  pointB=cadena.length();
                        if(esSimbolo(cadena.charAt(pointB-1))) --pointB;
                        t = generarToken(cadena.substring(pointA,pointB), 501, Integer.parseInt(cadena.substring(pointA,pointB)), line);
                        listaToken.add(t);
                        actualizaApuntadores();
                        return t;
                    }else{
                        edo = 5;
                        pointB ++;
                    }
                } else if(esPunto(cadena)){
                    edo = 6;
                    pointB++;
                } else{
                    if(esFinalDeLinea(cadena))  pointB=cadena.length();
                    if(esSimbolo(cadena.charAt(pointB-1))) --pointB;
                    t = generarToken(cadena.substring(pointA,pointB), 501, Integer.parseInt(cadena.substring(pointA,pointB)), line);
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;
                }
                break;
            case 6:
                if(esNumero(cadena)){
                    edo = 7;
                }else{
                    edo= 10;
                }
                break;
            case 7:
                if(esNumero(cadena)){
                    edo = 7;
                    pointB++;
                } else if(esFinalDeLinea(cadena) || esEspacio(cadena)){
                    if(esSimbolo(cadena.charAt(pointB-1))) --pointB;
                    t = generarToken(cadena.substring(pointA,pointB), 502, Float.parseFloat(cadena.substring(pointA,pointB)), line);
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;
                } else{
                    if(esSimbolo(cadena.charAt(pointB-1))) --pointB;
                    t = generarToken(cadena.substring(pointA,pointB), 502, Float.parseFloat(cadena.substring(pointA,pointB)), line);
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;
                }
                break;
            case 8:
                t = generarToken(String.valueOf(cadena.charAt(pointA)), (int)cadena.charAt(pointA), signID, line);
                signID++;
                listaToken.add(t);
                pointB++;
                actualizaApuntadores();
                return t;
            case 9:
                if(esLetraMinuscula(cadena)){
                    if(esFinalDeLinea(cadena) || esEspacio(cadena)){  
                        if(esFinalDeLinea(cadena)) {pointB=cadena.length();}
                        PalabraReservada word;
                        if((word = esReservada(cadena.substring(pointA, pointB)))!=null){
                            t = generarToken(cadena.substring(pointA, pointB), word.getAtributo(), word.getAtributo(),line);
                            listaToken.add(t);
                            actualizaApuntadores();
                            return t;
                        } else edo=10;
                    }else{
                        pointB ++;
                    }
                }else{
                    edo = 10;
                }
                break;
            case 10:
                if(esFinalDeLinea(cadena)) {pointB=cadena.length();}
                t = generarToken(cadena.substring(pointA,pointB), 404, 404, line);
                auxID++;
                listaToken.add(t);
                actualizaApuntadores();
                return t;
            case 11:
                if(esIgual(cadena)){
                    pointB++;
                    t = generarToken(cadena.substring(pointA,pointB), 503, auxID, line);
                    auxID++;
                    listaToken.add(t);
                    actualizaApuntadores();
                    return t;  
                }else{
                    edo = 10;
                }
                break; 
        }
        return null;
    }  
   
    //Busta que haya tokens iguales para duplicar ID
    public float buscaID(String s){
        for(Token aux : listaToken) if(aux.lexema.equals(s)) return t.ID;
        return 0;
    }
    /*
        Metodos donde se filtran los caracteres
    */
    private boolean esLetraMinuscula(String cadena){ 
       return cadena.charAt(pointB) >=  'a' && cadena.charAt(pointB) <=  'z' ||
               cadena.charAt(pointA) >=  'a' && cadena.charAt(pointA) <=  'z'; //Agregué este para inicio de archivo
    }
    
    private boolean esLetraMayuscula(String cadena){
        return cadena.charAt(pointB) >=  'A' && cadena.charAt(pointB) <=  'Z'||
               cadena.charAt(pointA) >=  'A' && cadena.charAt(pointA) <=  'Z'; //Agregué este para inicio de archivo;
    }
    
    private boolean esNumero(String cadena){
        return cadena.charAt(pointB) >=  '0' && cadena.charAt(pointB) <=  '9';
    }
    
    private boolean esEspacio(String cadena){
        return cadena.charAt(pointB) == ' ';
    }
    
    private boolean esPunto(String cadena){
        return cadena.charAt(pointB) == '.';
    }
    
    private boolean esFinalDeLinea(String cadena){
        return pointB == cadena.length()-1;
    }
    
    private boolean esGuionBajo(String cadena){
        return cadena.charAt(pointB) == '_';
    }
    
    private boolean esDosPuntos(String cadena){
        return cadena.charAt(pointB) == ':';
    }
    
    private boolean esIgual(String cadena){
        return cadena.charAt(pointB) == '=';
    }
    
    private boolean esSimbolo(char caracter){
        boolean flag = false;
        for(char s : cs)
            if(caracter == s){
                flag=true;
                break;
            }
        return flag;                
    }
    
    private PalabraReservada esReservada(String caracter){
        boolean flag = false;
        for(PalabraReservada s : reservadas)
            if(caracter.equals(s.getPalabra())){
                return s;
            }
        return null;                
    }
    /*
        Fin filtrado de caracteres
    */
    
    //Metodo que genera un token, y lo devuelve
//    private Token generarToken(String lexema,int identificador){
//        for (PalabraReservada reservada : reservadas) {
//            if (lexema.equals(reservada.getPalabra())) {
//                identificador = reservada.getAtributo();
//            }
//        }
//        Token tk = new Token(identificador, lexema);
//        return tk;
//    }
    
    //Metodo que genera un token, y lo devuelve
    private Token generarToken(String lexema,int identificador, float id, int line){
        for (PalabraReservada reservada : reservadas) {
            if (lexema.equals(reservada.getPalabra())) {
                identificador = reservada.getAtributo();
            }
        }
        Token tk = new Token(identificador, lexema, id, line);
        return tk;
    }
    
    
    //Se actualizan los apuntadores para poder iniciar de nuevo en el AFN
    private void actualizaApuntadores(){
        pointA = pointB;
        edo = 0;
    }
    
//    public void AnalizaLinea(String cadena){
//        while(pointB<cadena.length()) afnToken(cadena);
//    }
    
    public Token getNextToken(){
        for(int i = pointerLineas; i < lineas.length;i++){
            String cadena=lineas[i];
            while(pointB<cadena.length()){
                //System.out.println("A: "+ pointA + " B: " +pointB+ " LINEA "+pointerLineas);
                t = afnToken(cadena);
                if(t!=null) return t;
            }
            pointerLineas++;
            reiniciarEstado();
            line++;
        }
        return null;
    }
    
    
    public boolean endFile(){
        return (pointB==lineas[pointerLineas].length() && pointerLineas == lineas.length-1);
    }
    
    public void reiniciarEstado(){
        edo=0;
        pointB=0;
        pointA=0;
    }

    public ArrayList getListaToken() {
        return listaToken;
    }
}