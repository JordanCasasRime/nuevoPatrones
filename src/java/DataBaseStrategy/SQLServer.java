package DataBaseStrategy;

import DataBaseStrategy.DataBase;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
