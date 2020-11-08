package CodigoIntermedio;

import Tokens.Token;
import java.util.ArrayList;

public class PorTercetos {
    ArrayList<Terceto> tablaTercetos; //Tabla de tercetos
    ArrayList<Token> posfija; //Expresion posfija
    String[][] variableTemp; //Lista de variables temporales
    
    //Constructor de la clase
    public PorTercetos(ArrayList<Token> posfija) {
        this.tablaTercetos = new ArrayList();
        this.posfija =  posfija;
        this.variableTemp = new String[posfija.size()][2];
    }
    
    /*Proceso: De la expresion posfija, verifica que el elemento actual 
        sea un '=' que indica la asignación de la ultima variable de la 
        expresion y termina el proceso, por el contrario si los elementos 
        son identificadores o numeros, se creará una variable temporal por cada 
        uno de ellos. */
    public ArrayList<Terceto> generacionTercetos(){
        for (int i = 0; i < posfija.size(); i++) {
            Token t = posfija.get(i); //Token apuntador
            if(t.getLexema().equals("=")){ 
                int max = posfija.size() - 1;
                tablaTercetos.add(new Terceto((String)t.getLexema(), (String) posfija.get(max).getLexema(), ultimoTemp()));
                break;
            }else{
                if(t.getAtributo() >= 500 && t.getAtributo() <= 502){
                tablaTercetos.add(new Terceto("=", "temp" + i, (String)t.getLexema()));
                variableTemp[i][0] = "temp" + i;
                variableTemp[i][1] = (String)t.getLexema();
                }else{
                    if(!(posfija.get(i-1).getAtributo() <= 256))
                        tablaTercetos.add(new Terceto((String)t.getLexema(), variableTemp[i-1][0], variableTemp[i-2][0]));
                    else{
                        int c = i - 1;
                        while(posfija.get(c).getAtributo() <= 256) c--;
                        tablaTercetos.add(new Terceto((String)t.getLexema(), variableTemp[c][0], variableTemp[(i-c)-2][0]));
                    }
                }
            }
        }
        return tablaTercetos;
    }
    
    private String ultimoTemp(){
        return tablaTercetos.get(tablaTercetos.size()-1).getX();
    }
    
    public void imprimir(){
        tablaTercetos.forEach((t) -> {
            System.out.println(t.operador + " " + t.x + " " + t.y);
        });
    }
    
}
