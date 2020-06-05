package MatrizPredictiva;

/**
 *
 * @author Alexis Sanchez
 */
public class MatrizPredictiva {
    private final int[][] matrizPredictiva;
    String[] terminales;
    String[] noTerminales;

    public MatrizPredictiva(String[] noTerminales, String[] terminales){
        this.terminales = terminales;
        this.noTerminales = noTerminales;
        matrizPredictiva = new int[noTerminales.length][terminales.length];
        setValues();
    }

    private void setValues(){
        //[FILA][COLUMNA]
        matrizPredictiva[0][0] = 1; //Interseccion programa-inicio
        matrizPredictiva[8][0] = 16; //Interseccion programa-inicio

        matrizPredictiva[1][1] = 2; //Interseccion begin-program

        matrizPredictiva[2][2] = 3; //Interseccion end-stmt_list

        matrizPredictiva[2][3] = 4; // Interseccion id - stmt_list
        matrizPredictiva[3][3] = 5; // Interseccion id - stmt
        matrizPredictiva[4][3] = 6; // Interseccion id - expression
        matrizPredictiva[6][3] = 10; // Interseccion id - primary

        matrizPredictiva[5][5] = 8; // Interseccion ; - primarytail

        matrizPredictiva[4][6] = 6; // Interseccion ( - expression
        matrizPredictiva[6][6] = 9; // Interseccion ( - primary

        matrizPredictiva[5][7] = 8; // Interseccion ) - primarytail

        matrizPredictiva[4][8] = 6; // Interseccion intliteral - expression
        matrizPredictiva[6][8] = 11; // Interseccion intliteral - primary

        matrizPredictiva[4][9] = 6; // Interseccion realliteral - expression
        matrizPredictiva[6][9] = 12; // Interseccion realliteral - primary

        matrizPredictiva[5][10] = 7; // Interseccion + - primarytail
        matrizPredictiva[7][10] = 13; // Interseccion + - aritop

        matrizPredictiva[5][11] = 7; // Interseccion - - primarytail
        matrizPredictiva[7][11] = 14; // Interseccion - - aritop

        matrizPredictiva[5][12] = 7; // Interseccion * - primarytail
        matrizPredictiva[7][12] = 15; // Interseccion * - aritop
    }

    public int[][] getMatrizPredictiva(){
        return matrizPredictiva;
    }
    
    public void imprimeTabla(){
        System.out.print("\t");
//
        for(String s: terminales) System.out.print(s+"\t");
        System.out.println();
        for (int i = 0; i < matrizPredictiva.length; i++) {
            System.out.print(noTerminales[i] + "\t");
            for (int j = 0; j < matrizPredictiva[i].length; j++) {  
                System.out.print(matrizPredictiva[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
