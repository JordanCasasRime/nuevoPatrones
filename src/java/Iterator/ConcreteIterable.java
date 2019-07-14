package Iterator;

import java.util.ArrayList;

public class ConcreteIterable implements Iterable<Object> {

    private ArrayList<Object> myList;

    public ArrayList<Object> getList(){
//        myList.add("");
        return myList;
    }
    
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(getList());
        
    }
    
}
