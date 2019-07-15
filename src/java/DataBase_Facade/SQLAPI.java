package DataBase_Facade;

import DataBase_Strategy.ConectionDataBase;

public class SQLAPI {
    
    ConectionDataBase sql;
    
    public void findConection(String user, String password, String host, String url, String nameDB){
        sql = new ConectionDataBase();
        sql.setUser(user);
        sql.setPassword(password);
        sql.setHost(host);
        sql.setUrl(url);
        sql.setNameDataBase(nameDB);
        sql.selectConection("SQL");
        if (sql.getDatabase().isConnection()){
            System.out.println("Conectado en SQL.");
        }
    }
}
