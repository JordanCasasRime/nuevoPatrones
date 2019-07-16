package DAO;

import Class.Sede;
import DataBase_Strategy.MongoDB;
import Interfaces.IHeadquartersDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.Hashtable;

public class HeadquartersDAO implements IHeadquartersDAO {
    
    private static MongoDB mongodb;
    private static DBCollection collection;
    private static HeadquartersDAO dao;

    public synchronized static HeadquartersDAO getInstance () {
        if (dao == null){
            dao = new HeadquartersDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("sedes");
    }

    public void disconnection() {
        mongodb.disconnection();
    }

    @Override
    public void create(Sede headquarters) {
        Sede newHeadquarters = (Sede) headquarters.clone();
        BasicDBObject sedeU = (BasicDBObject) collection.find().sort(new BasicDBObject("sedeId", -1)).limit(1).next();
        int idU = 1;
        if (sedeU != null) {
            if (sedeU.get("sedeId") != null) {
                idU = (int) sedeU.get("sedeId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("nombre", newHeadquarters.getNombre()).append("sedeId", idU).append("direccion", newHeadquarters.getDireccion()).append("aforo", newHeadquarters.getAforo());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Sede> readAll() {
        DBCursor sedes = collection.find();
        ArrayList<Sede> sedesA = new ArrayList<Sede>();
        sedes.forEach((sede) -> {
            sedesA.add(new Sede((String) sede.get("nombre"), (String) sede.get("direccion"), (int) sede.get("aforo"), (int) sede.get("sedeId")));
        });
        return sedesA;
    }

    @Override
    public Sede readID(int id) {
        BasicDBObject sede = (BasicDBObject) collection.findOne(new BasicDBObject("sedeId", id));
        if (sede != null) {
            return new Sede((String) sede.get("nombre"), (String) sede.get("direccion"), (int) sede.get("aforo"), (int) sede.get("sedeId"));
        }
        return null;
    }

    @Override
    public void update(Sede headq) {
        collection.update(new BasicDBObject().append("sedeId", headq.getSedeId()),
        new BasicDBObject("$set", new BasicDBObject("nombre", headq.getNombre()).append("direccion", headq.getDireccion()).append("aforo", headq.getAforo())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("sedeId", id));
    }

    @Override
    public Hashtable<Integer, String> getHeadquartersDiccionary() {
        DBCursor headquarters = collection.find();
        Hashtable<Integer, String> headquartersH = new Hashtable<Integer, String>();
        headquarters.forEach((headquarter)->{
            headquartersH.put((int)headquarter.get("sedeId"), (String)headquarter.get("nombre"));
        });
        return headquartersH;
    }
    
}
