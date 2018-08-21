package ecci.bl;

import ecci.dal.SolicitudDAL;
import ecci.entidades.Escolaridad;
import ecci.entidades.Metrica;
import ecci.entidades.Profesion;
import ecci.entidades.Solicitud;
import ecci.entidades.SolicitudDetalle;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author
 */
public class SolicitudBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Solicitud manipulada
     */
    private Solicitud solicitud;

    /**
     * Administrador de la persistencia
     */
    private SolicitudDAL solicitudDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva solicitud con su administrador de persistencia
     *
     * @param id Identificador de la solicitud
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public SolicitudBL(int id, Properties propiedadesBD) throws IOException {
        this.solicitud = new Solicitud(id);
        this.solicitudDAL = new SolicitudDAL(propiedadesBD);
        this.solicitudDAL.setSolicitud(solicitud);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la solicitud
     *
     * @return Identificador de la solicitud
     */
    public int getId() {
        return this.solicitud.getId();
    }

    /**
     * Cambia el identificador de la solicitud
     *
     * @param id Identificador de la solicitud
     */
    public void setId(int id) {
        this.solicitud.setId(id);
    }

    /**
     * Trae la fecha de la solicitud
     *
     * @return Fecha de la solicitud
     */
    public Date getFecha() {
        return this.solicitud.getFecha();
    }

    /**
     * Cambia la fecha de la solicitud
     *
     * @param fecha Nueva fecha de la solicitud
     */
    public void setFecha(Date fecha) {
        this.solicitud.setFecha(fecha);
    }

    /**
     * Trae el nombre del usuario que realiza la solicitud
     *
     * @return Nombre del usuario que realiza la solicitud
     */
    public String getNombre() {
        return this.solicitud.getNombre();
    }

    /**
     * Cambia el nombre del usuario que realiza la solicitud
     *
     * @param nombre Nuevo nombre del usuario que realiza la solicitud
     */
    public void setNombre(String nombre) {
        this.solicitud.setNombre(nombre);
    }

    /**
     * Trae el email del usuario que hace la solicitud
     *
     * @return Email del usuario que hace la solicitud
     */
    public String getEmail() {
        return this.solicitud.getEmail();
    }

    /**
     * Cambia el email del usuario que hace la solicitud
     *
     * @param email Nuevo email del usuario que hace la solicitud
     */
    public void setEmail(String email) {
        this.solicitud.setEmail(email);
    }

    /**
     * Trae el nivel de escolaridad del usuario que hace la solicitud
     *
     * @return Nivel de escolaridad del usuario que hace la solicitud
     */
    public Escolaridad getEscolaridad() {
        return this.solicitud.getEscolaridad();
    }

    /**
     * Cambia el nivel de escolaridad del usuario que hace la solicitud
     *
     * @param escolaridad Nuevo nivel de escolaridad del usuario que hace la
     * solicitud
     */
    public void setEscolaridad(Escolaridad escolaridad) {
        this.solicitud.setEscolaridad(escolaridad);
    }

    /**
     * Trae la ocupación o profesión del usuario que hace la solicitud
     *
     * @return Ocupación o profesión del usuario que hace la solicitud
     */
    public Profesion getProfesion() {
        return this.solicitud.getProfesion();
    }

    /**
     * Cambia la ocupación o profesión del usuario que hace la solicitud
     *
     * @param profesion Ocupación o profesión del usuario que hace la solicitud
     */
    public void setProfesion(Profesion profesion) {
        this.solicitud.setProfesion(profesion);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.solicitud.toString();
    }

    /**
     * Trae el listado de solicitudes desde la base de datos
     *
     * @return Listado de solicitudes desde la base de datos
     * @throws SQLException
     * @throws java.text.ParseException
     */
    public ArrayList<Solicitud> listar() throws SQLException, ParseException {
        return this.solicitudDAL.listar();
    }

    /**
     * Inserta una nueva solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.solicitudDAL.insertar();
    }

    /**
     * Carga una solicitud desde la base de datos
     *
     * @throws SQLException
     * @throws java.text.ParseException
     */
    public void cargar() throws SQLException, ParseException {
        this.solicitudDAL.cargar();
    }

    /**
     * Actualiza una solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.solicitudDAL.actualizar();
    }

    /**
     * Elimina una solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.solicitudDAL.eliminar();
    }

    /**
     * Trae el listado de detalles de esta solicitud
     *
     * @return Listado de detalles de esta solicitud
     * @throws SQLException
     */
    public ArrayList<SolicitudDetalle> getDetalles() throws SQLException {
        return this.solicitudDAL.getDetalles();
    }

    /**
     * Inserta un nuevo detalle de una solicitud en la base de datos
     *
     * @param detalle Nuevo detalle a insertar
     * @throws SQLException
     */
    public void insertarDetalle(SolicitudDetalle detalle) throws SQLException {
        this.solicitudDAL.insertarDetalle(detalle);
    }

    /**
     * Actualiza un detalle de una solicitud en la base de datos
     *
     * @param detalle Detalle de una solicitud que se actualizará
     * @throws SQLException
     */
    public void actualizarDetalle(SolicitudDetalle detalle) throws SQLException {
        this.solicitudDAL.actualizarDetalle(detalle);
    }

    /**
     * Elimina un detalle de una solicitud en la base de datos
     *
     * @param detalle Detalle de una solicitud que se eliminará
     * @throws SQLException
     */
    public void eliminarDetalle(SolicitudDetalle detalle) throws SQLException {
        this.solicitudDAL.eliminarDetalle(detalle);
    }

    /**
     * Trae el resultado de aplicar la métrica sobre la solicitud
     *
     * @return Resultado de aplicar la métrica sobre la solicitud
     */
    public ArrayList<Metrica> getMetricas() throws SQLException {
        return this.solicitudDAL.getMetricas();
    }
    //</editor-fold>
}
