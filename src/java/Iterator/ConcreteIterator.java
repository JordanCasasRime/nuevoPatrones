package Iterator;

import java.util.ArrayList;

public class ConcreteIterator implements Iterator<Object> {

    private int position = 0;
    private ArrayList<Object> myList;

    public ConcreteIterator(ArrayList<Object> myList) {
        super();
        this.myList = myList;
    }
    
    @Override
    public boolean hasNext() {
        return position + 1 <= myList.size();
    }

    @Override
    public Object next() {
        Object list = myList.get(position);
        position ++;
        return list;
    }
    
}
