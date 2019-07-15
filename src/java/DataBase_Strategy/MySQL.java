package DataBase_Strategy;

import DataBase_Strategy.DataBase;

public class MySQL extends DataBase{

    private static MySQL mysql;
    
    private synchronized static MySQL Singleton() {
        if (mysql == null) {
            mysql = new MySQL();
            System.out.println("Conectado por Singleton MySQL");
        }
        return mysql;
    }

    public static MySQL getInstance() {
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
