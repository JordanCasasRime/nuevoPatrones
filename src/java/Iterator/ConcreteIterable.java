package Iterator;

import java.util.ArrayList;

public class ConcreteIterable implements Iterable<Object> {

    private ArrayList<Object> myList;

    public ConcreteIterable(ArrayList<Object> myList) {
        this.myList = myList;
    }
    
    public ArrayList<Object> getList(){
        return myList;
    }
    
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(getList());
        
    }
    
}
