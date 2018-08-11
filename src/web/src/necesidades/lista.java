package necesidades;

import ecci.bl.NecesidadBL;
import ecci.entidades.Necesidad;
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
 * Trae la lista de necesidades
 *
 * @author
 */
public class lista extends HttpServlet {

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

        NecesidadBL necesidadMgr = new NecesidadBL(0, dbProperties);
        int idNecesidadPadre;
        if (request.getParameter("node") == null) {
            idNecesidadPadre = 0;
        } else {
            if (request.getParameter("node").equals("root")) {
                idNecesidadPadre = 0;
            } else {
                idNecesidadPadre = Integer.parseInt(request.getParameter("node"));
            }
        }
        ArrayList<Necesidad> necesidades = necesidadMgr.listar(idNecesidadPadre);
        try (PrintWriter out = response.getWriter()) {
            out.println("{");
            out.println("\"necesidades\":");
            out.println("[");
            int i = 0;
            for (Necesidad necesidad : necesidades) {
                if (i != 0) {
                    out.println(",");
                }
                out.println(necesidad.toString());
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
            Logger.getLogger(lista.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(lista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Listado de etiquetas de la aplicación";
    }// </editor-fold>

}
