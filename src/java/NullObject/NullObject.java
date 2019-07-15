package NullObject;

import DAO_FactoryMethod.CRUD;
import java.util.ArrayList;

public class NullObject implements CRUD {
    
    private static NullObject myNull;
    
    public synchronized static NullObject getInstance () {
        myNull = new NullObject();
        System.out.println("No hacer nada NullObject.");
        return myNull;
    }

    @Override
    public void create(Object t) {
        System.out.println("No crear");
    }

    @Override
    public ArrayList readAll() {
        return null;
    }

    @Override
    public Object readID(int id) {
        return null;
    }

    @Override
    public void update(Object t) {
        System.out.println("No actualizar");
    }

    @Override
    public void delete(int id) {
        System.out.println("No borrar.");
    }

    @Override
    public void disconnection() {
        System.out.println("No desconectar");
    }
    
}
