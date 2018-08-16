package solicitudes;

import ecci.bl.SolicitudBL;
import ecci.entidades.Escolaridad;
import ecci.entidades.Profesion;
import ecci.entidades.SolicitudDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Guarda una solicitud en la base de datos
 *
 * @author
 */
public class guardar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        Properties dbProperties = new Properties();
        dbProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/database.properties"));

        SolicitudBL solicitud = new SolicitudBL(0, dbProperties);

        solicitud.setNombre(request.getParameter("nombre"));
        solicitud.setEmail(request.getParameter("email"));
        solicitud.setFecha(new Date());
        solicitud.setEscolaridad(new Escolaridad(Integer.parseInt(request.getParameter("escolaridad"))));
        solicitud.setProfesion(new Profesion(Integer.parseInt(request.getParameter("profesion"))));
        PrintWriter out = response.getWriter();
        try {
            String msg;
            solicitud.insertar();

            SolicitudDetalle detalle = new SolicitudDetalle(0);
            detalle.setNecesidad(request.getParameter("necesidad"));
            detalle.setJustificacion(request.getParameter("justificacion"));
            detalle.setHerramientaActual(request.getParameter("herramientaActual"));

            solicitud.insertarDetalle(detalle);
            msg = "Solicitud insertada con éxito";
            out.println("{\"success\":true,\"msg\":\"" + msg + "\",\"idsolicitud\":" + solicitud.getId() + "}");
        } catch (Exception ex) {
            out.println("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Guarda una escolaridad";
    }// </editor-fold>

}
