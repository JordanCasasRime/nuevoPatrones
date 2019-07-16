package Servlets;

import BD.ConexionMongo;
import Class.Competition;
import Class.Competitor;
import Class.Person;
import DAO_FactoryMethod.FactoryConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersController", urlPatterns = {"/UsersController"})
public class UsersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        FactoryConnection factory = new FactoryConnection();
        if(request.getParameter("page").equals("showUsers")){
//            ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Person> users =conexion.getPersons();
//            conexion.cerrarConexion();
            
            ArrayList<Person> users = factory.getConnection("Person").readAll();
//            factory.getConnection("Person").disconnection();
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("createUser")){
//            ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            conexion.cerrarConexion();
            
             ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
//            factory.getConnection("Competition").disconnection();
            request.setAttribute("competitions",competitions);
            request.getRequestDispatcher("administrador/users/createUser.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("editUser")){
//            ConexionMongo conexion = new ConexionMongo();
//            Person person =conexion.getPerson(Integer.parseInt(request.getParameter("id")));
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            Competitor competitor = conexion.getCompetitor(person.getPersonId());
//            conexion.cerrarConexion();
            
            Person person = (Person) factory.getConnection("Person").readID(Integer.parseInt(request.getParameter("id")));
            ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
            Competitor competitor = (Competitor) factory.getConnection("Competitor").readID(person.getPersonId());
//            factory.getConnection("Person").disconnection();
//            factory.getConnection("Competition").disconnection();
//            factory.getConnection("Person").disconnection();
            request.setAttribute("persona",person);
            request.setAttribute("competitions",competitions);
            request.setAttribute("competitor",competitor);
            request.getRequestDispatcher("administrador/users/editUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        FactoryConnection factory = new FactoryConnection();
        if(request.getParameter("_method").equals("POST")){
            String nombre = request.getParameter("nombreUser");
            String apellidos = request.getParameter("apellidosUser");
            int edad ;
            if(request.getParameter("edadUser")!=null && !request.getParameter("edadUser").equals("")){
                edad = Integer.parseInt(request.getParameter("edadUser"));
            }else{
                edad = 0;
            }
            String direccion = request.getParameter("direccionUser");
            String tipo = request.getParameter("tipoUser");
            String correo = request.getParameter("correoUser");
            String contrasenia = request.getParameter("contraseniaUser");
            
            ConexionMongo conexion = new ConexionMongo();
            //conexion.crearSede(nombre,direccion,aforo);
            if(tipo.equals("participante")){
                int competitionId = Integer.parseInt(request.getParameter("competitionUser"));
                conexion.createCompetitor(nombre, apellidos, edad, direccion, tipo, correo, contrasenia, competitionId);
//                factory.getConnection("Competitor").create(new Competitor());
            }else{
                conexion.createUser(nombre, apellidos, edad, direccion, tipo, correo, contrasenia);
            }
            
//            ArrayList<Person> users =conexion.getPersons();
            ArrayList<Person> users = factory.getConnection("Person").readAll();
            
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            //request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("PUT")){
            String nombre = request.getParameter("nombreUser");
            String apellidos = request.getParameter("apellidosUser");
            int edad ;
            if(request.getParameter("edadUser")!=null && !request.getParameter("edadUser").equals("")){
                edad = Integer.parseInt(request.getParameter("edadUser"));
            }else{
                edad = 0;
            }
            String direccion = request.getParameter("direccionUser");
            String tipo = request.getParameter("tipoUser");
            int personId = Integer.parseInt(request.getParameter("personId"));
            String typeStart = request.getParameter("_typeStart");
            ConexionMongo conexion = new ConexionMongo();
            if(tipo.equals("participante")|| typeStart.equals("participante")){
                int competitionId = Integer.parseInt(request.getParameter("competitionUser"));
                conexion.editCompetitor(nombre, apellidos, edad, direccion, tipo, personId,competitionId,typeStart);
            }else{
//                conexion.editPerson(nombre, apellidos, edad, direccion, tipo, personId);
                factory.getConnection("Person").update(new Person(personId, nombre, apellidos, edad, direccion, tipo));
            }
//            ArrayList<Person> users =conexion.getPersons();
            ArrayList<Person> users = factory.getConnection("Person").readAll();
            conexion.cerrarConexion();
            
            
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int personId = Integer.parseInt(request.getParameter("personId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.deletePerson(personId);
            ArrayList<Person> users =conexion.getPersons();
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
