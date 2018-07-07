package ecci.dal;

import ecci.entidades.Calificacion;
import ecci.database.ConexionMySQL;
import ecci.entidades.Etiqueta;
import ecci.entidades.Software;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class CalificacionDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Calificación que se desea persistir en base de datos
     */
    private Calificacion calificacion;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * calificaciones
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public CalificacionDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la calificación que actualmente se está persistiendo
     *
     * @return Módulo que actualmente se está persistiendo
     */
    public Calificacion getCalificacion() {
        return this.calificacion;
    }

    /**
     * Cambia la calificación que actualmente se está persistiendo
     *
     * @param calificacion Nueva calificación que actualmente se está
     * persistiendo
     */
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Trae el listado de calificaciones desde la base de datos
     *
     * @return Listado de calificaciones desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Calificacion> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idcalificacion, "
                + "idsoftware, nombreSoftware, descripcion, licencia, url, version, "
                + "idetiqueta, nombreEtiqueta, "
                + "porcentaje "
                + "FROM vw_calificacion");
        ArrayList<Calificacion> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Calificacion c = new Calificacion(Integer.parseInt(row.get("idcalificacion")));
            c.setSoftware(new Software(Integer.parseInt(row.get("idsoftware"))));
            c.getSoftware().setNombre("nombreSoftware");
            c.getSoftware().setDescripcion("descripcion");
            c.getSoftware().setLicencia("licencia");
            c.getSoftware().setUrl("url");
            c.getSoftware().setVersion("version");
            c.setEtiqueta(new Etiqueta(Integer.parseInt(row.get("idetiqueta"))));
            c.getEtiqueta().setNombre("nombreEtiqueta");
            c.setPorcentaje(Integer.parseInt(row.get("porcentaje")));
            lista.add(c);
        }
        return lista;
    }

    /**
     * Inserta una califiacción en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (calificacion != null) {
            this.calificacion.setId(this.conexion.insert(
                    "INSERT INTO calificacion "
                    + "(idsoftware, idetiqueta, porcentaje) "
                    + "VALUES "
                    + "(" + this.calificacion.getSoftware().getId() + ", "
                    + this.calificacion.getEtiqueta().getId() + ", "
                    + this.calificacion.getPorcentaje()
                    + ")"));
        }
    }

    /**
     * Carga a calificación desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT "
                + "idsoftware, nombreSoftware, descripcion, licencia, url, version, "
                + "idetiqueta, nombreEtiqueta, "
                + "porcentaje "
                + "FROM vw_calificacion "
                + "WHERE idcalificacion = " + this.calificacion.getId());
        for (HashMap<String, String> row : table) {
            Calificacion c = new Calificacion(Integer.parseInt(row.get("idcalificacion")));
            c.setSoftware(new Software(Integer.parseInt(row.get("idsoftware"))));
            c.getSoftware().setNombre("nombreSoftware");
            c.getSoftware().setDescripcion("descripcion");
            c.getSoftware().setLicencia("licencia");
            c.getSoftware().setUrl("url");
            c.getSoftware().setVersion("version");
            c.setEtiqueta(new Etiqueta(Integer.parseInt(row.get("idetiqueta"))));
            c.getEtiqueta().setNombre("nombreEtiqueta");
            c.setPorcentaje(Integer.parseInt(row.get("porcentaje")));
            this.calificacion = c;
        }
    }

    /**
     * Actualiza una calificación en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (calificacion != null) {
            this.conexion.update(
                    "UPDATE calificacion SET "
                    + "idsoftware = " + this.calificacion.getSoftware().getId() + ", "
                    + "idetiqueta = " + this.calificacion.getEtiqueta().getId() + ", "
                    + "porcentaje = " + this.calificacion.getPorcentaje()
                    + " WHERE idcalificacion = " + this.calificacion.getId());
        }
    }

    /**
     * Elimina una calificación en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (calificacion != null) {
            this.conexion.update(
                    "DELETE FROM calificacion "
                    + "WHERE idcalificacion = " + this.calificacion.getId());
        }
    }
    //</editor-fold>
}
