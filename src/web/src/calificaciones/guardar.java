package calificaciones;

import ecci.bl.CalificacionBL;
import ecci.entidades.Etiqueta;
import ecci.entidades.Software;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Guarda una calificación en la base de datos
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

        CalificacionBL calificacion = new CalificacionBL(Integer.parseInt(request.getParameter("id")), dbProperties);

        calificacion.setSoftware(new Software(Integer.parseInt(request.getParameter("idsoftware"))));
        calificacion.setEtiqueta(new Etiqueta(Integer.parseInt(request.getParameter("idetiqueta"))));
        calificacion.setPorcentaje(Integer.parseInt(request.getParameter("porcentaje")));
        PrintWriter out = response.getWriter();
        try {
            String msg;
            if (calificacion.getId() == 0) {//Insertar
                calificacion.insertar();
                msg = "Calificación insertada con éxito";
            } else { //Actualizar
                calificacion.actualizar();
                msg = "Calificación actualizada con éxito";
            }
            out.println("{\"success\":true,\"msg\":\"" + msg + "\"}");
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
        return "Guarda una calificación";
    }// </editor-fold>

}