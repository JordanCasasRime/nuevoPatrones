package DataBase_Strategy;

import DataBase_Strategy.DataBase;

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
        if(isConnection())
            System.out.println("Desconectar");
        System.out.println("No existe");
    }

    @Override
    public boolean isConnection() {
        return false;
    }
    
}
