package Servlets;

import BD.ConexionMongo;
import Class.Competition;
import Class.Sede;
import DAO_FactoryMethod.FactoryConnection;
import Interfaces.IHeadquartersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CompetitionsController", urlPatterns = {"/CompetitionsController"})
public class CompetitionsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FactoryConnection factory = new FactoryConnection();
        if(request.getParameter("page").equals("showCompetitions")){
            //ArrayList<Person> users =conexion.getPersons();
            //request.setAttribute("usuarios",users);
//            ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
//            conexion.cerrarConexion();
            
            ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
            Hashtable<Integer, String> headquartersH = ((IHeadquartersDAO) factory.getConnection("Headquarters")).getHeadquartersDiccionary();
//            factory.getConnection("Headquarters").disconnection();
//            factory.getConnection("Competition").disconnection();
            
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("createCompetition")){
//            ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            System.out.println(sedes);
//            conexion.cerrarConexion();
            
            ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/competitions/createCompetition.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("editCompetition")){
//            ConexionMongo conexion = new ConexionMongo();
//            Competition competition =conexion.getCompetition(Integer.parseInt(request.getParameter("id")));
//            ArrayList<Sede> headquarters =conexion.obtenerSedes();
//            conexion.cerrarConexion();
            
            Competition competition = (Competition) factory.getConnection("Competition").readID(Integer.parseInt(request.getParameter("id")));
            ArrayList<Sede> headquarters = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            request.setAttribute("competition",competition);
            request.setAttribute("headquarters",headquarters);
            request.getRequestDispatcher("administrador/competitions/editCompetition.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        FactoryConnection factory = new FactoryConnection();
        if(request.getParameter("_method").equals("POST")){
            String title = request.getParameter("titleCompetition");
            String category = request.getParameter("categoryCompetition");
            int headquarterId = Integer.parseInt(request.getParameter("headquarterCompetition"));
//            ConexionMongo conexion = new ConexionMongo();
//            conexion.createCompetition(title, category, headquarterId);
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
//            conexion.cerrarConexion();
            
            factory.getConnection("Competition").create(new Competition(1, title, category, headquarterId));
            ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
            Hashtable<Integer, String> headquartersH = ((IHeadquartersDAO) factory.getConnection("Headquarters")).getHeadquartersDiccionary();
//            factory.getConnection("Headquarters").disconnection();
//            factory.getConnection("Competition").disconnection();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        
        }else if(request.getParameter("_method").equals("PUT")){
            String title = request.getParameter("titleCompetition");
            String category = request.getParameter("categoryCompetition");
            int headquarterId = Integer.parseInt(request.getParameter("headquarterCompetition"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));

//            ConexionMongo conexion = new ConexionMongo();
//            conexion.editCompetition(title, category, headquarterId,competitionId);
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
//            conexion.cerrarConexion();
            
            factory.getConnection("Competition").update(new Competition (competitionId, title, category, headquarterId));
            ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
            Hashtable<Integer, String> headquartersH = ((IHeadquartersDAO) factory.getConnection("Headquarters")).getHeadquartersDiccionary();
//            factory.getConnection("Headquarters").disconnection();
//            factory.getConnection("Competition").disconnection();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));

//            ConexionMongo conexion = new ConexionMongo();
//            conexion.deleteCompetition(competitionId);
//            ArrayList<Competition> competitions =conexion.getCompetitions();
//            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
//            conexion.cerrarConexion();
            
            factory.getConnection("Competition").delete(competitionId);
            ArrayList<Competition> competitions = factory.getConnection("Competition").readAll();
            Hashtable<Integer, String> headquartersH = ((IHeadquartersDAO) factory.getConnection("Headquarters")).getHeadquartersDiccionary();
//            factory.getConnection("Headquarters").disconnection();
//            factory.getConnection("Competition").disconnection();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
