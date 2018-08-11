package necesidades;

import ecci.bl.NecesidadBL;
import ecci.entidades.Etiqueta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Trae la lista de etiquetas asociadas a una necesidad
 *
 * @author
 */
public class etiquetasNecesidad extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        Properties dbProperties = new Properties();
        dbProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/database.properties"));

        NecesidadBL necesidadMgr = new NecesidadBL(Integer.parseInt(request.getParameter("idnecesidad")), dbProperties);
        ArrayList<Etiqueta> etiquetas;
        if (request.getParameter("tipo").equals("in")) {
            etiquetas = necesidadMgr.listarEtiquetasActuales();
        } else {
            etiquetas = necesidadMgr.listarEtiquetasExcluidas();
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("{");
            out.println("\"etiquetas\":");
            out.println("[");
            int i = 0;
            for (Etiqueta etiqueta : etiquetas) {
                if (i != 0) {
                    out.println(",");
                }
                out.println(etiqueta.toString());
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
            Logger.getLogger(etiquetasNecesidad.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(etiquetasNecesidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Listado de usuarios de la aplicación";
    }// </editor-fold>

}
