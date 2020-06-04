
package Pila;
/**
 * @author andres & roger
 */
public class Stack implements Stackable{
    private Node base, anterior, siguiente;
    
    public Stack(){this.base=null;}

    @Override
    public void push(Object o) {
        if(base == null)
            base = new Node(o);
        else{
            Node aux = base;
            while(aux!=null)
                if(aux.getNext() == null) break;
                else aux = aux.getNext();
            Node nuevo = new Node(o);
            nuevo.next = aux.getNext();
            aux.next = nuevo;
        }
    }

    @Override
    public Node peek() {
        if(!isEmpty()){
            Node aux = base;
            while(aux!=null)
                if(aux.getNext() == null) break;
                else aux = aux.getNext();
            return aux;
        }
        else return null;   
    }

    @Override
    public void pop() {
        if(!isEmpty()){
            if(base.getNext() == null)
                base = null;
            else{
                Node aux = peek();
                anterior = behind(aux);
                anterior.next = null; 
            }
        }
    }

    @Override
    public int size() {
        int c=0;
        if(!isEmpty()){
            Node aux = base;
            while(aux!=null){
                c++;
                aux = aux.getNext();
            }
        }
        return c;
    }

    @Override
    public boolean trace(Object o) {
        if(!isEmpty()){
            Node aux = base;
            while(aux != null && !aux.getInfo().equals(o))
                aux = aux.getNext();
            return aux == null;
        }
        else return true;
    }

    @Override
    public boolean isEmpty() {
        return base==null;
    }

    @Override
    public void empty() {
        base=null;
    }

    @Override
    public Node behind(Node n) {
        if (!isEmpty() && !trace(n.getInfo())) {
            Node aux = base;
            while (aux != null) {
                if (aux.getInfo().equals(n.getInfo())) break;
                anterior = aux;
                aux = aux.getNext();
            }
            return anterior;
        }else return null;
    }

    @Override
    public Node next(Node n) {
        if(!isEmpty() && !trace(n.getInfo())){
        Node aux = base;
        while(aux != null){
            if(!aux.getInfo().equals(n.getInfo()))
                aux = aux.getNext();
            else {
                siguiente = aux.getNext();
                break;
            }
        }     
        }
        return siguiente;
    }
}
