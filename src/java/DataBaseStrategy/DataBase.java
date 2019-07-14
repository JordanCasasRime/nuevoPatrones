package DataBaseStrategy;

public abstract class DataBase {
    
    private synchronized static DataBase Singleton(){
        return null;
    }
    
    public static DataBase getInstance() {
        return Singleton();
    }
    
    public abstract void disconnection();
}
