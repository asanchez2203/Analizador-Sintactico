package Tokens;

public class PalabraReservada {
    private final int atributo;
    private final String palabra;
    
    public PalabraReservada(int atributo,String palabra){
        this.atributo = atributo;
        this.palabra = palabra;
    }

    public int getAtributo() {
        return atributo;
    }

    public String getPalabra() {
        return palabra;
    }
}
