package DataBase_Facade;

import DataBase_Strategy.ConectionDataBase;

public class PostgreSQLAPI {
    
    ConectionDataBase postgresql;
    
    public void findConection(String user, String password, String host, String url, String nameDB){
        postgresql = new ConectionDataBase();
        postgresql.setUser(user);
        postgresql.setPassword(password);
        postgresql.setHost(host);
        postgresql.setUrl(url);
        postgresql.setNameDataBase(nameDB);
        postgresql.selectConection("PostgreSQL");
        if (postgresql.getDatabase().isConnection()){
            System.out.println("Conectado en PostgreSQL.");
        }
    }
}
