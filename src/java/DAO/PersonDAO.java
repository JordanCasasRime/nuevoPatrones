package DAO;

import Class.Person;
import DataBase_Strategy.MongoDB;
import Interfaces.IConnection;
import Interfaces.IPersonDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class PersonDAO implements IPersonDAO {

    private static MongoDB mongodb;
    private static DBCollection collection; 
    private static PersonDAO dao;

    public synchronized static PersonDAO getInstance () {
        if (dao == null){
            dao = new PersonDAO();
            connection();
        }
        return dao;
    }
    
    private static void connection() {
        mongodb = MongoDB.getInstance();
        collection = mongodb.getDatabase().getCollection("personas");
    }

    public void disconnection() {
        mongodb.disconnection();
    }

    @Override
    public void create(Person user) {
        Person newPerson = (Person) user.clone();
        BasicDBObject userU = (BasicDBObject) collection.find().sort(new BasicDBObject("personaId", -1)).limit(1).next();
        int idU = 1;
        if (userU != null) {
            if (userU.get("personaId") != null) {
                idU = (int) userU.get("personaId") + 1;
            }
        }
        BasicDBObject documento = new BasicDBObject("nombre", newPerson.getName()).append("personaId", idU).append("apellidos", newPerson.getLastName()).
                append("edad",newPerson.getAge()).append("tipoUsuario", newPerson.getType()).append("telefono", newPerson.getPhone()).
                append("direccion", newPerson.getAddress());
        collection.insert(documento);
    }

    @Override
    public ArrayList<Person> readAll() {
        DBCursor personas = collection.find();
        ArrayList<Person> personaA = new ArrayList<Person>();
        personas.forEach((persona) -> {
            personaA.add(new Person((int) persona.get("personaId"), (String) persona.get("nombre"), (String) persona.get("apellidos"), (int) persona.get("edad"),
                    (String) persona.get("tipoUsuario"), (String) persona.get("telefono"), (String) persona.get("direccion")));
        });
        return personaA;
    }

    @Override
    public Person readID(int id) {
        BasicDBObject person = (BasicDBObject) collection.findOne(new BasicDBObject("personaId", id));
        if (person != null) {
            return new Person((int) person.get("personaId"), (String) person.get("nombre"), (String) person.get("apellidos"), (int) person.get("edad"), (String) person.get("tipoUsuario"), (String) person.get("telefono"), (String) person.get("direccion"));
        }
        return null;
    }

    @Override
    public void update(Person person) {
        collection.update(new BasicDBObject().append("personaId", person.getPersonId()),
        new BasicDBObject("$set", new BasicDBObject("nombre", person.getName()).append("apellidos", person.getAddress()).append("edad", person.getAge()).append("tipoUsuario", person.getType()).append("telefono", person.getPhone()).append("direccion", person.getAddress())));
    }

    @Override
    public void delete(int id) {
        collection.remove(new BasicDBObject().append("personaId", id));
    }

}
