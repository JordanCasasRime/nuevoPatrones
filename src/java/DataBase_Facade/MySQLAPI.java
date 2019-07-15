package DataBase_Facade;

import DataBase_Strategy.ConectionDataBase;

public class MySQLAPI {
    
    ConectionDataBase mysql;
    
    public void findConection(String user, String password, String host, String url, String nameDB){
        mysql = new ConectionDataBase();
        mysql.setUser(user);
        mysql.setPassword(password);
        mysql.setHost(host);
        mysql.setUrl(url);
        mysql.setNameDataBase(nameDB);
        mysql.selectConection("MySQL");
        if (mysql.getDatabase().isConnection()){
            System.out.println("Conectado en MySQL.");
        }
    }
}
