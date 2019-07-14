package DataBase;

import DataBaseStrategy.DataBase;

public class MySQL extends DataBase{

    private static MySQL mysql;
    
    private synchronized static MySQL Singleton() {
        if (mysql == null) {
            mysql = new MySQL();
            System.out.println("Conectado en MySQL");
        }
        return mysql;
    }

    public static MySQL getInstance() {
        return Singleton();
    }
    
    @Override
    public void disconnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
