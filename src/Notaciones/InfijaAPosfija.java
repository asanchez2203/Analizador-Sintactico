package Notaciones;

import Tokens.Token;
import java.util.ArrayList;
import java.util.Stack;

public class InfijaAPosfija {
    private final Stack stack;
    private final ArrayList<Token> expresion;
    private final ArrayList<Token> tokenList;
    private final int line;

    public InfijaAPosfija(int line,ArrayList<Token> tokenList){
        this.line = line;
        this.tokenList = tokenList;
        expresion = new ArrayList<>();
        stack = new Stack();
    }
    
    public ArrayList<Token> convertirExpresion(){
        ArrayList<Token> expresionConvertida = new ArrayList<>();
        for (int i = 2; i < expresion.size()-1; i++) {
            Token t = expresion.get(i);
            if(t.getAtributo() < 255){
                if(stack.contains("(") && t.getLexema().equals(")")){
                    String item;
                    do{
                         item = stack.pop().toString();
                         if(!item.equals("(")) 
                             expresionConvertida.add(new Token((int)item.charAt(0),item,(int)item.charAt(0),line));
                    }while(item.equals("(")); 
                }
                stack.add(t.getLexema().toString());
            }else{
                expresionConvertida.add(t);
            }
        }
        String item;
        do{
            if(stack.empty()) item = null;
            else item = stack.pop().toString();
            if(item!=null)
                if(!item.equals("(") && !item.equals(")") && !item.equals(";"))
                    expresionConvertida.add(new Token((int)item.charAt(0),item,(int)item.charAt(0),line));
        }while(item!=null);
        expresionConvertida.add(expresion.get(1));
        expresionConvertida.add(expresion.get(0));
        return expresionConvertida;
    }
    
    //Obtiene las expresiones según el numero de linea al que pertenecen
    public int getExpresion(){
        int n=0;
        for(Token t : tokenList)
            if(t.getLine() == line){
                n++;
                expresion.add(t);
            }
        return n;      
    }
    
    private ArrayList<Token> acomodar(ArrayList<Token> resultado){
        ArrayList<Token> resulFinal = new ArrayList<>();
        for (int i = resultado.size() - 1; i >= resultado.size()-2; i--) 
            resulFinal.add(resultado.get(i));
        
        for(Token t: resultado)
            if(!resulFinal.contains(t)) resulFinal.add(t);
        
        return resulFinal;
    }
    
    public void printResultado(ArrayList<Token> res){
        for(Token t: res){
            System.out.print(t.getLexema()+" ");
        }
            
        System.out.println("");
    }
     
}
