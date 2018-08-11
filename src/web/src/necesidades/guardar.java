package necesidades;

import ecci.bl.NecesidadBL;
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
 * Guarda una necesidad en la base de datos
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
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        Properties dbProperties = new Properties();
        dbProperties.load(request.getServletContext().getResourceAsStream("/WEB-INF/database.properties"));

        NecesidadBL necesidad = new NecesidadBL(Integer.parseInt(request.getParameter("id")), dbProperties);

        necesidad.setCodigo(request.getParameter("codigo"));
        necesidad.setDescripcion(request.getParameter("descripcion"));
        PrintWriter out = response.getWriter();
        try {
            String msg;
            int idNecesidadPadre = 0;
            if(request.getParameter("idnecesidadpadre") != null && !request.getParameter("idnecesidadpadre").equals("")){
                idNecesidadPadre = Integer.parseInt(request.getParameter("idnecesidadpadre"));
            }
            if (necesidad.getId() == 0) {//Insertar
                necesidad.insertar(idNecesidadPadre);
                msg = "Necesidad insertada con éxito";
            } else { //Actualizar
                necesidad.actualizar(idNecesidadPadre);
                msg = "Necesidad actualizada con éxito";
            }
            out.println("{\"success\":true,\"msg\":\"" + msg + "\"}");
        } catch (NumberFormatException | SQLException ex) {
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
        return "Guarda una etiqueta";
    }// </editor-fold>

}
