package DAO;

import Class.Competition;
import DataBase_Strategy.MongoDB;
import Interfaces.ICompetitionDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class CompetitionDAO implements ICompetitionDAO {

    private static MongoDB mongodb;
    private static DBCollection collection;
    private static CompetitionDAO dao;

    public synchronized static CompetitionDAO getInstance () {
        if (dao == null){
            dao = new CompetitionDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("competencias");
    }

    @Override
    public void disconnection() {
        mongodb.disconnection();
    }
    
    @Override
    public void create(Competition competition) {
        Competition newCompetition = (Competition) competition.clone();
        BasicDBObject sedeU = (BasicDBObject) collection.find().sort(new BasicDBObject("competenciaId", -1)).limit(1).next();
        int idU = 1;
        if (sedeU != null) {
            if (sedeU.get("competenciaId") != null) {
                idU = (int) sedeU.get("competenciaId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("titulo", newCompetition.getTitle()).append("competenciaId", idU).append("categoria", newCompetition.getCategory()).append("sedeId", newCompetition.getHeadquarterId());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Competition> readAll() {
        DBCursor competencias = collection.find();
        ArrayList<Competition> competenciasA = new ArrayList<Competition>();
        competencias.forEach((competencia) -> {
            competenciasA.add(new Competition((int) competencia.get("competenciaId"), (String) competencia.get("titulo"), (String) competencia.get("categoria"), (int) competencia.get("sedeId")));
        });
        return competenciasA;
    }

    @Override
    public Competition readID(int id) {
        BasicDBObject sede = (BasicDBObject) collection.findOne(new BasicDBObject("competenciaId", id));
        if (sede != null) {
            return new Competition((int) sede.get("competenciaId"), (String) sede.get("titulo"), (String) sede.get("categoria"), (int) sede.get("sedeId"));
        }
        return null;
    }

    @Override
    public void update(Competition competition) {
        collection.update(new BasicDBObject().append("competenciaId", competition.getCompetitionId()),
        new BasicDBObject("$set", new BasicDBObject("titulo", competition.getTitle()).append("categoria", competition.getCategory()).append("sedeId", competition.getHeadquarterId())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("competenciaId", id));
    }
    
}
