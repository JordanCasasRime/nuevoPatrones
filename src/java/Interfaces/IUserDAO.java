package Interfaces;

import DAO_FactoryMethod.CRUD;
import Class.Headquarter;
import Class.User;

public interface IUserDAO extends CRUD<User> {
    
    public User readEmail(String email);
    
}
