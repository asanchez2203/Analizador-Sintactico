package CodigoObjeto;

import Tokens.Token;
import java.util.ArrayList;

public class GenerarCodigoObjeto {

    public void headers(){
        System.out.println(".Const\n"
                + "\n"
                + ".Data?\n"
                + "\n"
                + ".Data\n"
                + "	message DB \"Start\", 0\n"
                + "	message2 DB \"End\", 0\n"
                + "	salto DB 10, 13, 0	\n"
                + "	input DB 10 Dup(0)");
    }
    
    public void generaVariables(ArrayList<Token> variables){
        for (int i = 0; i < variables.size(); i++) {
            System.out.println("\t" + variables.get(i).getLexema().toString() + " DWord 0");
        }
    }
}
