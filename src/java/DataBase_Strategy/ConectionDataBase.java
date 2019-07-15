package DataBase_Strategy;

public class ConectionDataBase {
    
    private String user = "jordan";
    private String password = "cursogg";
    private String host = "mongodb+srv";
    private String url = "panamericano-cjqv8.mongodb.net/test?retryWrites=true&w=majority";
    private String nameDataBase = "Panamericano";
    private DataBase database;

    public ConectionDataBase() {}
    
    public ConectionDataBase(String user, String password, String host, String url) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.url = url;
    }
    
    public void selectConection(String DB) {
        switch(DB) {
            case "MongoDB": database = MongoDB.getInstance();
                break;
            case "MySQL": database = MySQL.getInstance();
                break;
            case "PostgreSQL": database = PostgreSQL.getInstance();
                break;
            case "SQL": database = SQL.getInstance();
                break;
            case "SQLServer": database = SQLServer.getInstance();
                break;
            default: return;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNameDataBase() {
        return nameDataBase;
    }

    public void setNameDataBase(String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    public DataBase getDatabase() {
        return database;
    }

    public void setDatabase(DataBase database) {
        this.database = database;
    }
    
}
