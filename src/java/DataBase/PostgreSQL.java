package DataBase;

import DataBaseStrategy.DataBase;

public class PostgreSQL extends DataBase{

    private static PostgreSQL postgresql;
    
    private synchronized static PostgreSQL Singleton() {
        if (postgresql == null) {
            postgresql = new PostgreSQL();
            System.out.println("Conectado en PosgreSQL");
        }
        return postgresql;
    }

    public static PostgreSQL getInstance() {
        return Singleton();
    }
    
    @Override
    public void disconnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
