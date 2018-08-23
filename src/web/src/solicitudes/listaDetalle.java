package solicitudes;

import ecci.bl.SolicitudBL;
import ecci.entidades.Solicitud;
import ecci.entidades.SolicitudDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Trae la lista de los detalles de una solicitud
 *
 * @author
 */
public class listaDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        Properties dbProperties = new Properties();
        dbProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/database.properties"));
        
        SolicitudBL solicitudMgr = new SolicitudBL(Integer.parseInt(request.getParameter("idsolicitud")), dbProperties);
        
        ArrayList<SolicitudDetalle> detalles = solicitudMgr.getDetalles();
        
        try (PrintWriter out = response.getWriter()) {
            out.println("{");
            out.println("\"solicitudDetalles\":");
            out.println("[");
            int i = 0;
            for (SolicitudDetalle detalle : detalles) {
                if (i != 0) {
                    out.println(",");
                }
                out.println(detalle.toString());
                i++;
            }
            out.println("]");
            out.println("}");
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
            Logger.getLogger(listaDetalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(listaDetalle.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(listaDetalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(listaDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Listado de escolaridades de la aplicación";
    }// </editor-fold>

}