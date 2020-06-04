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
        matrizPredictiva[0][0] = 1; //Interseccion inicio-begin
        matrizPredictiva[1][1] = 2; //Interseccion begin-program

        matrizPredictiva[2][2] = 4; // Interseccion stmt_list - id
        matrizPredictiva[2][3] = 5; // Interseccion stmt - id
        matrizPredictiva[2][4] = 6; // Interseccion expression - id
        matrizPredictiva[2][6] = 10; // Interseccion primary - id

        matrizPredictiva[3][6] = 10; // Interseccion primary - id
    }

    public int[][] getMatrizPredictiva(){
        return matrizPredictiva;
    }
}
