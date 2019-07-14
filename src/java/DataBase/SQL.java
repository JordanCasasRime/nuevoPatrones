package DataBase;

import DataBaseStrategy.DataBase;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
