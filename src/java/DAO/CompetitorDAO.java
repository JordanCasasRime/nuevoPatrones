package DAO;

import Class.Competitor;
import DataBase_Strategy.MongoDB;
import Interfaces.ICompetitorDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class CompetitorDAO implements ICompetitorDAO {

    private static MongoDB mongodb;
    private static DBCollection collection;
    private static CompetitorDAO dao;

    public synchronized static CompetitorDAO getInstance () {
        if (dao == null){
            dao = new CompetitorDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("participantes");
    }

    @Override
    public void disconnection() {
        mongodb.disconnection();
    }
    
    @Override
    public void create(Competitor competition) {
        Competitor newCompetitor = (Competitor) competition.clone();
        BasicDBObject participanteU = (BasicDBObject) collection.find().sort(new BasicDBObject("participanteId", -1)).limit(1).next();
        int idU = 1;
        if (participanteU != null) {
            if (participanteU.get("participanteId") != null) {
                idU = (int) participanteU.get("participanteId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("personaId", newCompetitor.getPersonId()).append("participanteId", idU).append("competenciaId", newCompetitor.getCompetitionId());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Competitor> readAll() {
        DBCursor competidor = collection.find();
        ArrayList<Competitor> competenciasA = new ArrayList<Competitor>();
        competidor.forEach((competencia) -> {
            competenciasA.add(new Competitor((int) competencia.get("participanteId"), (int) competencia.get("personaId"), (int) competencia.get("competenciaId")));
        });
        return competenciasA;
    }

    @Override
    public Competitor readID(int id) {
        BasicDBObject competencia = (BasicDBObject) collection.findOne(new BasicDBObject("participanteId", id));
        if (competencia != null) {
            return new Competitor((int) competencia.get("participanteId"), (int) competencia.get("personaId"), (int) competencia.get("competenciaId"));
        }
        return null;
    }

    @Override
    public void update(Competitor competition) {
        collection.update(new BasicDBObject().append("participanteId", competition.getCompetitionId()),
        new BasicDBObject("$set", new BasicDBObject("personaId", competition.getPersonId()).append("competenciaId", competition.getCompetitionId())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("participanteId", id));
    }
    
}
