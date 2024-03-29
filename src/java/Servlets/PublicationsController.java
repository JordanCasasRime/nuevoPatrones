package Servlets;

import BD.ConexionMongo;
import Class.Competition;
import Class.Competitor;
import clases.Publication;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PublicationsController", urlPatterns = {"/PublicationsController"})
public class PublicationsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("parametro").equals("competitions")){
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Competition> competitions =conexion.getCompetitions();
            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("user/competition/competitions.jsp").forward(request, response);
        }else if(request.getParameter("parametro").equals("showCompetition")){
            ConexionMongo conexion = new ConexionMongo();
            Competition competition =conexion.getCompetition(Integer.parseInt(request.getParameter("id")));
            ArrayList<Competitor> competitors =conexion.getCompetitorsForCompetition(competition.getCompetitionId());
            System.out.println("ASASASASASAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(competition.getCompetitionId());
            System.out.println(competitors.size());
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competition",competition);
            request.setAttribute("competitors",competitors);
            request.setAttribute("personsH",personsH);
            request.getRequestDispatcher("user/competition/showCompetition.jsp").forward(request, response);
        }else if(request.getParameter("parametro").equals("getPublications")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            String txtPublication = request.getParameter("txtPublication");
            ConexionMongo conexion = new ConexionMongo();
            conexion.createPublication(txtPublication, personId, competitionId,parentId);
            ArrayList<Publication> publications;
            if(parentId==0){
                publications =conexion.getPublications(competitionId);
            }else{
                publications =conexion.getPublicationsChildren(parentId);
            }
            
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            conexion.cerrarConexion();
            /*String employeeJsonString = new Gson().toJson(1);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();*/
            request.setAttribute("publications",publications);
            request.setAttribute("personsH",personsH);
            if(parentId==0){
                request.getRequestDispatcher("user/competition/publicationsAjax.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("user/competition/publicationsChildrenAjax.jsp").forward(request, response);
            }
            
            
        }else if(request.getParameter("parametro").equals("getPublicationsAlone")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Publication> publications =conexion.getPublications(competitionId);
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("publications",publications);
            request.setAttribute("personsH",personsH);
            request.getRequestDispatcher("user/competition/publicationsAjax.jsp").forward(request, response);
        }else if(request.getParameter("parametro").equals("getPublicationsChildrenAlone")){
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Publication> publications =conexion.getPublicationsChildren(parentId);
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            conexion.cerrarConexion();
            System.out.println(publications.size());
            request.setAttribute("publications",publications);
            request.setAttribute("personsH",personsH);
            request.getRequestDispatcher("user/competition/publicationsChildrenAjax.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
