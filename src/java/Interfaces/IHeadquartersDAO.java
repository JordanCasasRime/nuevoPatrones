package Interfaces;

import DAO_FactoryMethod.CRUD;
import Class.Sede;
import java.util.Hashtable;

public interface IHeadquartersDAO extends CRUD<Sede> {
    
    public Hashtable<Integer, String> getHeadquartersDiccionary();
}
