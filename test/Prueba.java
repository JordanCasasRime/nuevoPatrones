
import Adapter.ArrayAdapter;
import BD.ConexionMongo;
import Class.Sede;
import Class.Person;
import Class.Publication;
import DAO.HeadquartersDAO;
import DAO.PersonDAO;
import DAO.PublicationDAO;
import DataBase_Strategy.ConectionDataBase;
import DataBase_Strategy.MongoDB;
import DataBase_Strategy.MySQL;
import DataBase_Strategy.PostgreSQL;
import DataBase_Strategy.SQL;
import DataBase_Strategy.SQLServer;
import DataBase_Strategy.DataBase;
import DAO_FactoryMethod.CRUD;
import DAO_FactoryMethod.FactoryConnection;
import DataBase_Facade.CheckFacade;
import Interfaces.IConnection;
import Iterator.ConcreteIterable;
import Iterator.ConcreteIterator;
import MementoMethod.Caretaker;
import MementoMethod.Memento;
import TemplateMethod.AccessAdministrator;
import TemplateMethod.AccessPlataform;
import TemplateMethod.AccessUser;
import Class.Sede;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Prueba {

    public static void main(String[] args) {
        
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://jordan:cursogg@panamericano-cjqv8.mongodb.net/test?retryWrites=true&w=majority"));
//        MongoDB mongo = MongoDB.getInstance();
//        mongoClient = mongo.getMongoClient();
//        List<String> databases = mongoClient.getDatabaseNames();
//        for (String dbName : databases) {
//            System.out.println("- Database: " + dbName);
//            
//            DB db = mongoClient.getDB(dbName);
//            
//            Set<String> collections = db.getCollectionNames();
//            for (String colName : collections) {
//                System.out.println("\t + Collection: " + colName);
//            }
//        }
//        
//        mongoClient.close();
//         
//
//       
//                MongoDB aux1 = MongoDB.getInstance();
//                MongoDB aux2 = MongoDB.getInstance();
//                MongoDB aux3 = MongoDB.getInstance();
//                System.out.println(aux1.hashCode());
//                System.out.println(aux2.hashCode());
//                System.out.println(aux3.hashCode());
//                
        
//        HeadquartersDAO conexion = HeadquartersDAO.getInstance();
////        HeadquartersDAO conexion2 = HeadquartersDAO.getInstance();
////        HeadquartersDAO conexion3 = HeadquartersDAO.getInstance();
////        
////        System.out.println(conexion.hashCode());
////        System.out.println(conexion2.hashCode());
////        System.out.println(conexion3.hashCode());
//
//
//        ArrayList<Headquarters> sees = conexion.readAll();
//        sees.forEach((sede) -> {
//             System.out.println(sede.getName());
//        });
//        conexion.disconnection();


//            ConexionMongo conexion = new ConexionMongo();
//            System.out.println("conectado");
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            System.out.println("Pasando array");
//            conexion.cerrarConexion();
//            System.out.println("Cerrando");
        
//        Headquarters h = new Headquarters("nombre", "direccion", 20, 1);
//        Headquarters h2 = (Headquarters) h.clone();
//        
//        if (h2 != null)
//            System.out.println("se clono");
//        System.out.println(h2 == h);

//        System.out.println("Hola");
//        CRUD h =  HeadquartersDAO.getInstance();
//        
//        System.out.println("Intenciando");
//        
//        ArrayList<Headquarters> sees = h.readAll();
//        sees.forEach((sede) -> {
//             System.out.println(sede.getName());
//             System.out.println(sede.getAddress());
//             System.out.println(sede.getCapacity());
//             System.out.println(sede.getHeadquartersId());
//        });

//        AccessPlataform acceso = new AccessAdministrator();
//        
//        String usuario = "cesar.manrique4@unmsm.edu.pe";
//        String contrasena = "mamaMichi";
//        
//        acceso.gatherInformation(usuario, contrasena);
//        if (acceso.showPage()){
//            System.out.println("Eres admin");
//        }
//        acceso = new AccessUser ();
//        acceso.gatherInformation(usuario, contrasena);
//        if (acceso.showPage()){
//            System.out.println("Eres usuario");
//        }


//        DataBase mongo = MongoDB.getInstance();
//        DataBase postgres = PostgreSQL.getInstance();
//        DataBase sql = SQL.getInstance();
//        DataBase sqlserver = SQLServer.getInstance();
//        DataBase mysql = MySQL.getInstance();

//        ConectionDataBase bd = new ConectionDataBase();
//        bd.selectConection("PostgreSQL");
//        bd.selectConection("MySQL");


//        ArrayList<Person> person = new ArrayList<Person>();
//        
//        Person aux = new Person();
//        aux.setName("A");
//        person.add(aux);
//        
//        Person aux2 = new Person();
//        aux2.setName("B");
//        person.add(aux2);
//        
//        aux = new Person();
//        aux.setName("C");
//        person.add(aux);
//        
//        aux = new Person();
//        aux.setName("D");
//        person.add(aux);
//        
        
//
//        ConcreteIterable iterable = new ConcreteIterable((ArrayList<Object>) (Object) person);
//        ConcreteIterator iterator = (ConcreteIterator) iterable.createIterator();
//        while(iterator.hasNext()){
//            Person name = (Person) iterator.myItem();
//            System.out.println(name.getName());
//            iterator.next();
//        }

//        HeadquartersDAO h = HeadquartersDAO.getInstance();
//        h.readAll();

//        Caretaker care = new Caretaker();
//        Publication p = new Publication("titulo", "descripcion", "date", "categoria", 1);
//        Memento me = new Memento(p);
//        care.addMemento(me);
//        ArrayList<Memento> m = care.addAll(care.getMementos());
//        System.out.println(care.getMementos().get(0).getState().getTitle());
//        System.out.println(m.get(0).getState().getTitle());



//        CheckFacade facade = new CheckFacade();
//        facade.findConnection("", "", "", "", "");

        
//        Integer[] numero = new Integer [3];
//        numero[0] = 1;
//        numero[1] = 2;
//        numero[2] = 3;
//        
//        ArrayAdapter adapater = new ArrayAdapter(numero);
//        ArrayList newList = adapater.convertedArrayList();
//        System.out.println(newList.get(0));
//        System.out.println(newList.get(1));
//        System.out.println(newList.get(2));


//        FactoryConnection factory = new FactoryConnection();
//        System.out.println(factory.getConnection("Headquarters").hashCode());
//        System.out.println(factory.getConnection("Publication").hashCode());
//        System.out.println(factory.getConnection("Headquarters").hashCode());
//        System.out.println(factory.getConnection("").hashCode());
//        System.out.println(factory.getConnection("hi").hashCode());

//        ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Headquarters> sede =conexion.obtenerSedes();
//            conexion.cerrarConexion();
//            
//            int n = sede.size();
//            for (int i = 0; i < n; i++){
//                System.out.println(sede.get(i).getSedeId());
//                System.out.println(sede.get(i).getNombre());
//                System.out.println(sede.get(i).getDireccion());
//                System.out.println(sede.get(i).getAforo());
//            }
//            
//            FactoryConnection factory = new FactoryConnection();
//            ArrayList<Headquarters> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
//            
//            n = sedes.size();
//            for (int i = 0; i < n; i++){
//                System.out.println(sedes.get(i).getHeadquartersId());
//                System.out.println(sedes.get(i).getName());
//                System.out.println(sedes.get(i).getAddress());
//                System.out.println(sedes.get(i).getCapacity());
//            }

//            FactoryConnection factory = new FactoryConnection();
//            Headquarters h = (Headquarters) factory.getConnection("Headquarters").readID(1);
//            System.out.println(h.getNombre());

          FactoryConnection factory = new FactoryConnection();
//        Sede headquarters = new Sede("prueba","abc",23, 1);
//        factory.getConnection("Headquarters").create(headquarters);
//        ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
          System.out.println(factory.getConnection("Competitor").hashCode());
          System.out.println(factory.getConnection("Null").hashCode());
    }

}
