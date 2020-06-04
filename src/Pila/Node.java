package Pila;

public class Node {
    protected Object info;
    protected Node next;

    public Node(){
        info = null;
        next = null;
    }
    
    public Node(Object o, Node n){
        this.setInfo(o);
        this.setNext(n);
    }
    
    public Node(Object o){
        this.setInfo(o);
        next = null;
    }

    public Object getInfo() { return info; }
    public void setInfo(Object info) { this.info = info; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; } 
}
