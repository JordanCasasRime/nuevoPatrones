package controladores;

import BD.ConexionMongo;
import DAO_FactoryMethod.FactoryConnection;
import Class.Sede;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SedesControlador", urlPatterns = {"/SedesControlador"})
public class SedesControlador extends HttpServlet {

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
        if(request.getParameter("pagina").equals("verSedes")){
            
//            ConexionMongo conexion = new ConexionMongo();
//            ArrayList<Headquarter> sede =conexion.obtenerSedes();
//            conexion.cerrarConexion();
            
//            FactoryConnection factory = new FactoryConnection();
            ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("pagina").equals("editarSede")){
//            ConexionMongo conexion = new ConexionMongo();
//            Sede sede =conexion.obtenerSede(Integer.parseInt(request.getParameter("id")));
//            conexion.cerrarConexion();
            
            
            Sede sede = (Sede) factory.getConnection("Headquarters").readID(Integer.parseInt(request.getParameter("id")));
//            factory.getConnection("Headquarters").disconnection();
            
            request.setAttribute("sede",sede);
            request.getRequestDispatcher("administrador/sedes/editarSede.jsp").forward(request, response);
        }else if(request.getParameter("pagina").equals("crearSede")){
            request.getRequestDispatcher("administrador/sedes/crearSede.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FactoryConnection factory = new FactoryConnection();
        if(request.getParameter("_method").equals("POST")){
            String nombre = request.getParameter("nombreSede");
            String direccion = request.getParameter("direccionSede");
            int aforo = Integer.parseInt(request.getParameter("aforoSede"));
            
//            ConexionMongo conexion = new ConexionMongo();
//            conexion.crearSede(nombre,direccion,aforo);
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            conexion.cerrarConexion();
            
            
            factory.getConnection("Headquarters").create(new Sede(nombre,direccion,aforo, 1));
            ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("PUT")){
            String nombre = request.getParameter("nombreSede");
            String direccion = request.getParameter("direccionSede");
            int aforo = Integer.parseInt(request.getParameter("aforoSede"));
            int sedeId = Integer.parseInt(request.getParameter("sedeId"));

//            ConexionMongo conexion = new ConexionMongo();
//            conexion.editarSede(nombre, direccion, aforo, sedeId);
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            conexion.cerrarConexion();
            
            factory.getConnection("Headquarters").update(new Sede(nombre, direccion, aforo, sedeId));
            ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int sedeId = Integer.parseInt(request.getParameter("sedeId"));

//            ConexionMongo conexion = new ConexionMongo();
//            conexion.eliminarSede(sedeId);
//            ArrayList<Sede> sedes =conexion.obtenerSedes();
//            conexion.cerrarConexion();
            
            factory.getConnection("Headquarters").delete(sedeId);
            ArrayList<Sede> sedes = factory.getConnection("Headquarters").readAll();
//            factory.getConnection("Headquarters").disconnection();
            
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }
        
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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
