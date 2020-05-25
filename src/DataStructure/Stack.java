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
        stackPointer++;
    }
    
    public void pop(){
        stackPointer--;
    }
    
    public boolean stackFull(){
        return (stackPointer == elements.length);
    }
    
    public boolean emptyStack(){
        return (stackPointer==0);
    }
}
