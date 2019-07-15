package DataBase_Facade;

import DataBase_Strategy.ConectionDataBase;

public class SQLServerAPI {
    
    ConectionDataBase sqlserver;
    
    public void findConection(String user, String password, String host, String url, String nameDB){
        sqlserver = new ConectionDataBase();
        sqlserver.setUser(user);
        sqlserver.setPassword(password);
        sqlserver.setHost(host);
        sqlserver.setUrl(url);
        sqlserver.setNameDataBase(nameDB);
        sqlserver.selectConection("SQLServer");
        if (sqlserver.getDatabase().isConnection()){
            System.out.println("Conectado en SQLServer.");
        }
    }
}
