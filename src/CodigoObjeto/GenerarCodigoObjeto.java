package CodigoObjeto;

import CodigoIntermedio.Terceto;
import Tokens.Token;
import java.util.ArrayList;

public class GenerarCodigoObjeto {

    public void headers() {
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

    public void generaVariables(ArrayList<Token> variables) {
        for (int i = 0; i < variables.size(); i++) {
            System.out.println("\t" + variables.get(i).getLexema().toString() + " DWord 0");
        }
    }

    public void generaCodigo(ArrayList<Terceto> tercetos) {
        String[] reg = {"EAX", "EBX", "ECX", "EDX"}; //Registros 
        int cont = 0;
        ArrayList<String> auxT = new ArrayList();

        for (int i = 0; i < tercetos.size(); i++) {
            Terceto t = tercetos.get(i);
            //Asignaciones de registros MOV
            if (t.getOperador().equalsIgnoreCase("=") && i != tercetos.size() - 1) {
                if (t.getX().substring(0, 4).equalsIgnoreCase("temp")) {
                    System.out.println("MOV " + reg[cont] + " " + t.getY());
                    auxT.add(t.getX());
                    cont++;
                } else {
                    System.out.println("MOV " + reg[cont] + " " + t.getX());
                    auxT.add(t.getY());
                    cont++;
                }
            }

            //Uso de operaciones ADD, SUB, MUL
            if (t.getOperador().equalsIgnoreCase("+") && i != tercetos.size() - 1) {
                for (int j = 0; j < reg.length; j++) {
                    if (auxT.get(j).equals(t.getX())) {
                        for (int k = 0; k < reg.length; k++) {
                            if (auxT.get(k).equals(t.getY())) {
                                System.out.println("ADD " + reg[j] + " " + reg[k]);
                                break;
                            }
                        }
                        break;
                    }

                }
            } else if (t.getOperador().equalsIgnoreCase("-") && i != tercetos.size() - 1) {
                for (int j = 0; j < reg.length; j++) {
                    if (auxT.get(j).equals(t.getX())) {
                        for (int k = 0; k < reg.length; k++) {
                            if (auxT.get(k).equals(t.getY())) {
                                System.out.println("SUB " + reg[j] + " " + reg[k]);
                                break;
                            }
                        }
                        break;
                    }

                }
            } else if (t.getOperador().equalsIgnoreCase("*") && i != tercetos.size() - 1) {
               for (int j = 0; j < reg.length; j++) {
                    if (auxT.get(j).equals(t.getX())) {
                        for (int k = 0; k < reg.length; k++) {
                            if (auxT.get(k).equals(t.getY())) {
                                System.out.println("MUL " + reg[j] + " " + reg[k]);
                                break;
                            }
                        }
                        break;
                    }

                }
            }
            //Asignacion del resultado en la ultima variable
            if (t.getOperador().equalsIgnoreCase("=") && i == tercetos.size() - 1){
                for (int j = 0; j < reg.length; j++) {
                     if (auxT.get(j).equals(t.getY())){
                         System.out.println("MOV " + t.getX() + " " + reg[j]);
                         break;
                     }
                }
                
            }
        }
    }
}
