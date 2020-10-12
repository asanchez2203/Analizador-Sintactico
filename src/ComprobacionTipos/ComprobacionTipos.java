package ComprobacionTipos;

import Tablas.Fila;
import Tokens.Token;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ComprobacionTipos {
    
    private final ArrayList<Token> tablaToken;    
    private final ArrayList<Token> sinRepetir;
    int idProv = 800;

    //private final ArrayList<Fila> tablaSimbolos;
    ArrayList<Token> triada;
    ArrayList<Token> FinalArray;

    public ComprobacionTipos(ArrayList<Token> tablaToken) {
        this.tablaToken = tablaToken;
        FinalArray = new ArrayList<>();
        sinRepetir = new ArrayList<>();
        sinRepetir();
        //this.tablaSimbolos = tablaSimbolos;
    }
    
    //Genera triadas segun el numero de la linea en que aparezcan los tokens
    public ArrayList<Token> triada(int line){
        triada = new ArrayList();
    
        for(Token t : tablaToken) if(t.getLine() == line) triada.add(t);
        
        return triada;
    }
    
    public int compruebaTipos(Token t1, Token t2){
        //500 = Identificador, 501 = Numero natural, 502 Numero flotante
        //Si el primero es INT
        switch (t1.getAtributo()) {
            case 500: 
                if(t2.getAtributo() == 500 || 
                        t2.getAtributo() == 501) return 501; //INT - INT = INT
                else return 502; //INT - REAL = INT
            case 501:
                if(t2.getAtributo() == 500 || 
                        t2.getAtributo() == 501) return 501;//INT - INT = INT
                else return 502; //INT - REAL = INT
            case 502:
                if(t2.getAtributo() == 502) return 502;//INT - INT = INT
                else return 502; //INT - REAL = INT
            default:
                return -1;
        }
    }
        
    public void analiza(){
        for(int i = 1; triada(i).size() > 0 ;i++){
            ArrayList <Token> triadaTemp = triada(i);
            
            System.out.println("Linea "+ i);
            for(Token s : triadaTemp) System.out.print(s.getLexema().toString() +" ");
            System.out.println("");
            
            ArrayList<Integer> indexes = new ArrayList();
            for(int k = 0; k<triadaTemp.size(); k++){
                if(triadaTemp.get(k).getAtributo() >= 500 && triadaTemp.get(k).getAtributo() <=502){
                    indexes.add(k);
                    //System.out.println(triadaTemp.get(k).getLexema());
                }
            }
            
            //System.out.println(indexes.size());
            int tokensValidos = indexes.size() -1;
            if(indexes.size() > 0){
                //Token t1 = triadaTemp.get(indexes.get(tokensValidos));
                Token t1 = searchByID(triadaTemp.get(indexes.get(tokensValidos)).getID());
                addTok(t1);
                for(int j = tokensValidos; j >=1; j--){
                    //Token t2 = triadaTemp.get(indexes.get(j-1));
                    Token t2 = searchByID(triadaTemp.get(indexes.get(j-1)).getID());
                    int tipo = compruebaTipos(t1, t2);

                    Token temp = new Token(tipo, "<<Expresion>>",idProv++,i);
                    addTok(t2);
                    addTok(temp);
                    //t1.setAtributo(tipo);
                    System.out.println("Resultado de comparar " + t1.getLexema() +"-"+t1.getTipo()+" y " + t2.getLexema()+"-"+t1.getTipo()+ " es: " + tipo);
                    if(t2.getAtributo()==500)
                        searchByID(t2.getID()).setAtributo(tipo);
                    //}
                    //t1.setAtributo(tipo);
                    t1 = temp;
                    //t1.setLexema("Expresion");
                    //FinalArray.add(t2);
                }
            }          
        }
        System.out.println("------------------------");
        printArray(FinalArray);
    }
    
    private boolean isReal(float value){
        //Regresa True si es Entero, False si es flotante
        return value % 1 == 0;
    }
    
    private void printArray(ArrayList<Token> ar){
        System.out.println("IMPRESION FINAL DE TOKENS");
        for(Token t: ar)
            if(t.getAtributo() >= 500 && t.getAtributo() <=502)
                System.out.println(t.toString());
    }
    
    private Token searchByID(float ID){
        for(Token t : sinRepetir)
            if(t.getID() == ID) return t;
        return null;
    }

    private void sinRepetir(){
        for(Token t : tablaToken)
            if(!exist(sinRepetir, t))
                sinRepetir.add(t);
    }
    
    private boolean exist(ArrayList<Token> Tokens, Token item){
        for(Token t : Tokens)
            if(t.getID() == item.getID()) return true;
        return false;
    }
    
    private void addTok(Token t){
       // if(!exist(FinalArray, t))
            FinalArray.add(t);
    }
}
