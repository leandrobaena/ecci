package ecci.entidades;

/**
 * Detalle de una solicitud realiada por un usuario
 *
 * @author
 */
public class SolicitudDetalle {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador del detalle de la solicitud
     */
    private int id;

    /**
     * Necesidad solicitada por el usuario
     */
    private String necesidad;

    /**
     * Justificación solicitada por el usuario
     */
    private String justificacion;

    /**
     * Herramineta actual declarada por el usuario
     */
    private String herramientaActual;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public SolicitudDetalle() {
        this.id = 0;
        this.necesidad = "";
        this.justificacion = "";
        this.herramientaActual = "";
    }

    /**
     * Crea un detalle de solicitud con un identificador determinado
     *
     * @param id Identificador del detalle
     */
    public SolicitudDetalle(int id) {
        this.id = id;
        this.necesidad = "";
        this.justificacion = "";
        this.herramientaActual = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del detalle de solicitud
     *
     * @return Identificador del detalle de solicitud
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del detalle de solicitud
     *
     * @param id Nuevo identificador del detalle de solicitud
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae la necesidad solicitada por el detalle de solicitud
     *
     * @return Necesidad solicitada por el detalle de solicitud
     */
    public String getNecesidad() {
        return necesidad;
    }

    /**
     * Cambia la necesidad solicitada por el detalle de solicitud
     *
     * @param necesidad Nueva necesidad solicitada por el detalle de solicitud
     */
    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }

    /**
     * Trae la justificación declarada por el detalle de solicitud
     *
     * @return Justificación declarada por el detalle de solicitud
     */
    public String getJustificacion() {
        return justificacion;
    }

    /**
     * Cambia la justificación declarada por el detalle de solicitud
     *
     * @param justificacion Nueva justificación declarada por el detalle de
     * solicitud
     */
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    /**
     * Trae la herramineta actual declarada por el detalle de solicitud
     *
     * @return Herramineta actual declarada por el detalle de solicitud
     */
    public String getHerramientaActual() {
        return herramientaActual;
    }

    /**
     * Cambia la herramineta actual declarada por el detalle de solicitud
     *
     * @param herramientaActual Nueva herramineta actual declarada por el
     * detalle de solicitud
     */
    public void setHerramientaActual(String herramientaActual) {
        this.herramientaActual = herramientaActual;
    }
 
    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"necesidad\": \"" + this.necesidad + "\","
                + "\"justificacion\": \"" + this.justificacion + "\","
                + "\"herramientaActual\": \"" + this.herramientaActual + "\""
                + "}";
    }
   //</editor-fold>
}