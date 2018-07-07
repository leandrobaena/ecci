package ecci.dal;

import ecci.entidades.Solicitud;
import ecci.database.ConexionMySQL;
import ecci.entidades.Escolaridad;
import ecci.entidades.Profesion;
import ecci.entidades.SolicitudDetalle;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author
 */
public class SolicitudDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Solicitud que se desea persistir en base de datos
     */
    private Solicitud solicitud;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * solicitudes
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public SolicitudDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la solicitud que actualmente se está persistiendo
     *
     * @return Solicitud que actualmente se está persistiendo
     */
    public Solicitud getSolicitud() {
        return this.solicitud;
    }

    /**
     * Cambia la solicitud que actualmente se está persistiendo
     *
     * @param solicitud Nueva solicitud que actualmente se está persistiendo
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * Trae el listado de solicitudes desde la base de datos
     *
     * @return Listado de solicitudes desde la base de datos
     * @throws SQLException
     * @throws java.text.ParseException
     */
    public ArrayList<Solicitud> listar() throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idsolicitud, fecha, nombre, email, idescolaridad, escolaridad, idprofesion, profesion "
                + "FROM vw_solicitud");
        ArrayList<Solicitud> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Solicitud s = new Solicitud(Integer.parseInt(row.get("idsolicitud")));
            s.setFecha(sdf.parse(row.get("fecha")));
            s.setNombre(row.get("nombre"));
            s.setEmail(row.get("email"));
            s.setEscolaridad(new Escolaridad(Integer.parseInt(row.get("idescolaridad"))));
            s.getEscolaridad().setNombre(row.get("escoralidad"));
            s.setProfesion(new Profesion(Integer.parseInt(row.get("idprofesion"))));
            s.getProfesion().setNombre(row.get("profesion"));
            lista.add(s);
        }
        return lista;
    }

    /**
     * Inserta una nueva solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        if (solicitud != null) {
            this.solicitud.setId(this.conexion.insert(
                    "INSERT INTO solicitud "
                    + "(fecha, nombre, email, idescolaridad, iprofesion) "
                    + "VALUES "
                    + "('" + sdf.format(this.solicitud.getFecha()) + "', "
                    + "'" + this.solicitud.getNombre() + "', "
                    + "'" + this.solicitud.getEmail() + "', "
                    + this.solicitud.getEscolaridad().getId() + ", "
                    + this.solicitud.getProfesion().getId()
                    + ")"));
        }
    }

    /**
     * Carga una solicitud desde la base de datos
     *
     * @throws SQLException
     * @throws java.text.ParseException
     */
    public void cargar() throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        ArrayList<Solicitud> lista = new ArrayList<>();
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT fecha, nombre, email, idescolaridad, escolaridad, idprofesion, profesion "
                + "FROM vw_solicitud "
                + "WHERE idsolicitud = " + this.solicitud.getId());
        for (HashMap<String, String> row : table) {
            Solicitud s = new Solicitud(Integer.parseInt(row.get("idsolicitud")));
            s.setFecha(sdf.parse(row.get("fecha")));
            s.setNombre(row.get("nombre"));
            s.setEmail(row.get("email"));
            s.setEscolaridad(new Escolaridad(Integer.parseInt(row.get("idescolaridad"))));
            s.getEscolaridad().setNombre(row.get("escoralidad"));
            s.setProfesion(new Profesion(Integer.parseInt(row.get("idprofesion"))));
            s.getProfesion().setNombre(row.get("profesion"));
            this.solicitud = s;
        }
    }

    /**
     * Actualiza una solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-mm-dd");
        if (solicitud != null) {
            this.conexion.update(
                    "UPDATE solicitud SET "
                    + "fecha = '" + sdf.format(this.solicitud.getFecha()) + "', "
                    + "nombre = '" + this.solicitud.getNombre() + "', "
                    + "email = '" + this.solicitud.getEmail() + "', "
                    + "idescolaridad = " + this.solicitud.getEscolaridad().getId() + ", "
                    + "idprofesion = " + this.solicitud.getProfesion().getId()
                    + " WHERE idsolicitud = " + this.solicitud.getId());
        }
    }

    /**
     * Elimina una solicitud en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (solicitud != null) {
            this.conexion.update(
                    "DELETE FROM solicitud "
                    + "WHERE idsolicitud = " + this.solicitud.getId());
        }
    }

    /**
     * Trae el listado de detalles de esta solicitud
     *
     * @return Listado de detalles de esta solicitud
     * @throws SQLException
     */
    public List<SolicitudDetalle> getDetalles() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idsolicituddetalle, necesidad, justificacion, herramientaActual "
                + "FROM solicituddetalle");
        ArrayList<SolicitudDetalle> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            SolicitudDetalle sd = new SolicitudDetalle(Integer.parseInt(row.get("idsolicituddetalle")));
            sd.setNecesidad(row.get("necesidad"));
            sd.setJustificacion(row.get("justificacion"));
            sd.setHerramientaActual(row.get("herramientaActual"));
            lista.add(sd);
        }
        return lista;
    }

    /**
     * Inserta un nuevo detalle de una solicitud en la base de datos
     *
     * @param detalle Nuevo detalle a insertar
     * @throws SQLException
     */
    public void insertarDetalle(SolicitudDetalle detalle) throws SQLException {
        if (solicitud != null) {
            detalle.setId(this.conexion.insert(
                    "INSERT INTO solicituddetalle "
                    + "(idsolicitud, necesidad, justificacion, herramientaActual) "
                    + "VALUES "
                    + "(" + this.solicitud.getId() + ", "
                    + "'" + detalle.getNecesidad() + "', "
                    + "'" + detalle.getJustificacion() + "', "
                    + "'" + detalle.getHerramientaActual() + "'"
                    + ")"));
        }
    }

    /**
     * Actualiza un detalle de una solicitud en la base de datos
     *
     * @param detalle Detalle de una solicitud que se actualizará
     * @throws SQLException
     */
    public void actualizarDetalle(SolicitudDetalle detalle) throws SQLException {
        if (solicitud != null) {
            this.conexion.update(
                    "UPDATE solicituddetalle SET "
                    + "idsolicitud = " + this.solicitud.getId() + ", "
                    + "necesidad = '" + detalle.getNecesidad() + "', "
                    + "justificacion = '" + detalle.getJustificacion() + "', "
                    + "herramientaActual = '" + detalle.getHerramientaActual() + "'"
                    + " WHERE idsolicituddetalle = " + detalle.getId());
        }
    }

    /**
     * Elimina un detalle de una solicitud en la base de datos
     *
     * @param detalle Detalle de una solicitud que se eliminará
     * @throws SQLException
     */
    public void eliminarDetalle(SolicitudDetalle detalle) throws SQLException {
        if (solicitud != null) {
            this.conexion.update(
                    "DELETE FROM solicitudetalle "
                    + "WHERE idsolicituddetalle = " + detalle.getId());
        }
    }
    //</editor-fold>
}
