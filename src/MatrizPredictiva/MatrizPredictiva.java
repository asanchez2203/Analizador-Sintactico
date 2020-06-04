package MatrizPredictiva;

/**
 *
 * @author Alexis Sanchez
 */
public class MatrizPredictiva {
    private final int[][] matrizPredictiva;

    public MatrizPredictiva(String[] noTerminales, String[] terminales){
        matrizPredictiva = new int[terminales.length][noTerminales.length];
        setValues();
    }

    private void setValues(){
        matrizPredictiva[0][0] = 1; //Interseccion programa-inicio

        matrizPredictiva[1][1] = 2; //Interseccion begin-program

        matrizPredictiva[2][2] = 2; //Interseccion end-stmt_list

        matrizPredictiva[3][2] = 4; // Interseccion id - stmt_list
        matrizPredictiva[3][3] = 5; // Interseccion id - stmt
        matrizPredictiva[3][4] = 6; // Interseccion id - expression
        matrizPredictiva[3][6] = 10; // Interseccion id - primary

        matrizPredictiva[5][5] = 8; // Interseccion ; - primarytail

        matrizPredictiva[6][4] = 6; // Interseccion ( - expression
        matrizPredictiva[6][6] = 9; // Interseccion ( - primary

        matrizPredictiva[7][5] = 8; // Interseccion ) - primarytail

        matrizPredictiva[8][4] = 6; // Interseccion intliteral - expression
        matrizPredictiva[8][6] = 11; // Interseccion intliteral - primary

        matrizPredictiva[9][4] = 6; // Interseccion realliteral - expression
        matrizPredictiva[9][6] = 12; // Interseccion realliteral - primary

        matrizPredictiva[10][5] = 7; // Interseccion + - primarytail
        matrizPredictiva[10][7] = 13; // Interseccion + - aritop

        matrizPredictiva[11][5] = 7; // Interseccion - - primarytail
        matrizPredictiva[11][7] = 14; // Interseccion - - aritop

        matrizPredictiva[12][5] = 7; // Interseccion * - primarytail
        matrizPredictiva[12][7] = 15; // Interseccion * - aritop
    }

    public int[][] getMatrizPredictiva(){
        return matrizPredictiva;
    }
}
