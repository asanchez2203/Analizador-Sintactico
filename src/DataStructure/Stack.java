package DataStructure;

/**
 *
 * @author Alexis Sanchez
 */
public class Stack {

    private int size;
    private Object[] elements;
    private int stackPointer;
    
    public Stack(int size){
        this.size = size;
        elements = new Object[this.size];
        stackPointer=0;
        
        for(int i=0;i<elements.length;i++) elements[i]=null;
    }
    
    public void push(Object element){
        if(!stackFull()){
            elements[stackPointer] = element;
            stackPointer++;
        }else{
            System.err.println("Pila Llena");
        }
        
    }
    
    public void pop(){
        if(!emptyStack()){
            stackPointer--;
            elements[stackPointer] = null;
        }else{
            System.err.println("La pila está vacia");
        }
    }
    
    public boolean stackFull(){
        return (stackPointer == size);
    }
    
    public boolean emptyStack(){
        return (stackPointer==0);
    }
    
    public void printStack(){
        for(int i=0; i< size;i++)
            if(elements[i]!=null)
                System.out.println((String) elements[i]);
    }
}
