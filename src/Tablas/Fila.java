package Tablas;

public class Fila{
    protected Object nombre; //LEXEMA
    protected String tipo; //Identificador = int, Numero = Real
    protected float id; //ID
    protected String linea; //Numero de linea, concatenar con ,
    protected float valor; //Valor si es Real convertir  
    protected int repeticion; 

    public Fila(Object nombre, String tipo, float id, String linea, float valor, int repeticion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.id = id;
        this.linea = linea;
        this.valor = valor;
        this.repeticion = repeticion;
    }
    
    public String imprimir(){
        return "\033[32m LEXEMA: " + "\033[30m" +(String)nombre + 
               "\t\033[32m TIPO: " + "\033[30m" + tipo + 
               "\t\033[32m IDENTIFICADOR: " + "\033[30m" + id + 
               "\t\033[32m linea: " + "\033[30m" + linea + 
               "\t\033[32m VALOR: " + "\033[30m" + valor + 
               "\t\033[32m NUM REPETICIONES: " + "\033[30m" + repeticion;
    }

    public Object getNombre() {
        return nombre;
    }

    public void setNombre(Object nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }
    
    
    
}