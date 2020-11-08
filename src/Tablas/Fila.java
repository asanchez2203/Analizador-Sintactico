package Tablas;

public class Fila{
    protected Object nombre; //LEXEMA
    protected String tipo; //Identificador = int, Numero = Real
    protected float id; //ID
    protected String linea; //Numero de linea, concatenar con ,
    protected float valor; //Valor si es Real convertir  
    protected int repeticion; 
    protected int atributo; //Valor de identidad original(no es el ID)

    public Fila(Object nombre, String tipo, float id, String linea, float valor, int repeticion, int atributo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.id = id;
        this.linea = linea;
        this.valor = valor;
        this.repeticion = repeticion;
        this.atributo = atributo;
    }
    
    public String imprimir(){
        return (String)nombre + "\t" + 
               "\t" + tipo + "\t" + 
               "\t" + id + "\t" + 
               "\t" + linea + "\t" +
               "\t" + valor + "\t" +
               "\t" + repeticion + "\t";
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

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

}