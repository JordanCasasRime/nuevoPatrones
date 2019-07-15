package Iterator;

import java.util.ArrayList;

public abstract class CopyAll<myClass> {
    
    public ArrayList<myClass> copyAll (ArrayList<myClass> myclass) {
        ArrayList<Object> newList = new ArrayList<Object>();
        ConcreteIterable iterable = new ConcreteIterable((ArrayList<Object>) (Object) myclass);
        ConcreteIterator iterator = (ConcreteIterator) iterable.createIterator();
        while(iterator.hasNext()){
            newList.add((myClass) iterator.myItem());
            iterator.next();
        }
        return (ArrayList<myClass>) newList;
    }
    
}
