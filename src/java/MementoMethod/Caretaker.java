package MementoMethod;

import Iterator.CopyAll;
import java.util.ArrayList;

public class Caretaker {

    private ArrayList<Memento> mementos = new ArrayList<>();
    
    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public ArrayList<Memento> getMementos() {
        return mementos;
    }
    
    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}
