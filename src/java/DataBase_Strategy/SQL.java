package DataBase_Strategy;

import DataBase_Strategy.DataBase;

public class SQL extends DataBase{

    private static SQL sql;
    
    private synchronized static SQL Singleton() {
        if (sql == null) {
            sql = new SQL();
            System.out.println("Conectado en SQL");
        }
        return sql;
    }

    public static SQL getInstance() {
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
