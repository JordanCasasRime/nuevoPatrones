package DataBase_Strategy;

import DataBase_Strategy.DataBase;

public class SQLServer extends DataBase{

    private static SQLServer sqlserver;
    
    private synchronized static SQLServer Singleton() {
        if (sqlserver == null) {
            sqlserver = new SQLServer();
            System.out.println("Conectado en SQLServer");
        }
        return sqlserver;
    }

    public static SQLServer getInstance() {
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
