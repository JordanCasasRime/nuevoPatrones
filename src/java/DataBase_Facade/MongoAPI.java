package DataBase_Facade;

import DataBase_Strategy.ConectionDataBase;

public class MongoAPI {
    
    ConectionDataBase mongo;
    
    public void findConection(String user, String password, String host, String url, String nameDB){
        mongo = new ConectionDataBase();
        mongo.setUser(user);
        mongo.setPassword(password);
        mongo.setHost(host);
        mongo.setUrl(url);
        mongo.setNameDataBase(nameDB);
        mongo.selectConection("MongoDB");
        if (mongo.getDatabase().isConnection()){
            System.out.println("Conectado en Mongo.");
        }
    }
    
}
