package controladores;

import BD.ConexionMongo;
import Class.Person;
import TemplateMethod.AccessAdministrator;
import TemplateMethod.AccessPlataform;
import TemplateMethod.AccessUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        if(request.getParameter("parametro").equals("logout")){
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String correo = request.getParameter("correoUser");
        String contrasenia = request.getParameter("contraseniaUser");
        
        AccessPlataform acceso = new AccessAdministrator();
        acceso.gatherInformation(correo, contrasenia);
        if (acceso.showPage()){
            request.getRequestDispatcher("administrador.jsp").forward(request, response);
        }
        acceso = new AccessUser ();
        acceso.gatherInformation(correo, contrasenia);
        if (acceso.showPage()){
            request.getRequestDispatcher("user/user.jsp").forward(request, response);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
//        ConexionMongo conexion = new ConexionMongo();
//        Person person = conexion.findForUser(correo, contrasenia);
//        conexion.cerrarConexion();
//        if(person!=null){
//            request.getSession().setAttribute("person", person);
//            if(person.getType().equals("administrador")){
//                request.getRequestDispatcher("administrador.jsp").forward(request, response);
//            }else{
//                request.getRequestDispatcher("user/user.jsp").forward(request, response);
//            }
//            
//        }else{
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
        
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
