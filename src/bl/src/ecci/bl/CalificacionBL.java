package ecci.bl;

import ecci.dal.CalificacionDAL;
import ecci.entidades.Calificacion;
import ecci.entidades.Etiqueta;
import ecci.entidades.Software;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class CalificacionBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Calificacipon manipulada
     */
    private Calificacion calificacion;

    /**
     * Administrador de la persistencia
     */
    private CalificacionDAL calificacionDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva califiación con su administrador de persistencia
     *
     * @param id Identificador de la calificación
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public CalificacionBL(int id, Properties propiedadesBD) throws IOException {
        this.calificacion = new Calificacion(id);
        this.calificacionDAL = new CalificacionDAL(propiedadesBD);
        this.calificacionDAL.setCalificacion(calificacion);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la calificación
     *
     * @return Identificador de la calificación
     */
    public int getId() {
        return this.calificacion.getId();
    }

    /**
     * Cambia el identificador de la calificacion
     *
     * @param id Nuevo identificador de la calificación
     */
    public void setId(int id) {
        this.calificacion.setId(id);
    }

    /**
     * Trae el software calificado
     *
     * @return Software calificado
     */
    public Software getSoftware() {
        return this.calificacion.getSoftware();
    }

    /**
     * Cambia el softare calificado
     *
     * @param software Nuevo software calificado
     */
    public void setSoftware(Software software) {
        this.calificacion.setSoftware(software);
    }

    /**
     * Trae la etiqueta calificada
     *
     * @return Etiqueta calificada
     */
    public Etiqueta getEtiqueta() {
        return this.calificacion.getEtiqueta();
    }

    /**
     * Cambia la etiqueta calificada
     *
     * @param etiqueta Nueva etiqueta calificado
     */
    public void setEtiqueta(Etiqueta etiqueta) {
        this.calificacion.setEtiqueta(etiqueta);
    }

    /**
     * Trae el porcentaje de la calificación
     *
     * @return Porcentaje de la calificación
     */
    public int getPorcentaje() {
        return this.calificacion.getPorcentaje();
    }

    /**
     * Cambia el porcentaje de la calificacion
     *
     * @param porcentaje Nuevo porcentaje de la calificación
     */
    public void setPorcentaje(int porcentaje) {
        this.calificacion.setPorcentaje(porcentaje);
    }

    /**
     * Trae el listado de calificaciones desde la base de datos
     *
     * @return Listado de calificaciones desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Calificacion> listar() throws SQLException {
        return this.calificacionDAL.listar();
    }

    /**
     * Inserta una califiacción en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.calificacionDAL.insertar();
    }

    /**
     * Carga a calificación desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.calificacionDAL.cargar();
    }

    /**
     * Actualiza una calificación en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.calificacionDAL.actualizar();
    }

    /**
     * Elimina una calificación en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.calificacionDAL.eliminar();
    }
    //</editor-fold>
}
