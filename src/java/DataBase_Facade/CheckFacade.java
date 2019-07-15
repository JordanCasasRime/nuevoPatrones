package DataBase_Facade;

public class CheckFacade {
    
    private MongoAPI mongoAPI;
    private SQLAPI sqlAPI;
    private MySQLAPI mysqlAPI;
    private SQLServerAPI sqlserverAPI;
    private PostgreSQLAPI postgresqlAPI;

    public CheckFacade() {
        mongoAPI = new MongoAPI();
        sqlAPI = new SQLAPI();
        mysqlAPI = new MySQLAPI();
        sqlserverAPI = new SQLServerAPI();
        postgresqlAPI = new PostgreSQLAPI();
    }

    public void findConnection(String user, String password, String host, String url, String nameDB) {
        mongoAPI.findConection(user, password, host, url, nameDB);
        mysqlAPI.findConection(user, password, host, url, nameDB);
        sqlAPI.findConection(user, password, host, url, nameDB);
        sqlserverAPI.findConection(user, password, host, url, nameDB);
        postgresqlAPI.findConection(user, password, host, url, nameDB);
    }
    
}
