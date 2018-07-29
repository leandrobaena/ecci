package ecci.entidades;

/**
 * Calificación que se hace a un software con respecto al porcentaje de
 * cumplimento de un software con relación a una característica o etiqueta
 *
 * @author
 */
public class Calificacion {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador de la calificación
     */
    private int id;

    /**
     * Software que se califica
     */
    private Software software;

    /**
     * Etiqueta que se califica
     */
    private Etiqueta etiqueta;

    /**
     * Porcentaje de calificación del software respecto a la etiqueta
     */
    private int porcentaje;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto de la calificación
     */
    public Calificacion() {
        this.id = 0;
        this.software = new Software();
        this.etiqueta = new Etiqueta();
        this.porcentaje = 0;
    }

    /**
     * Crea una calificación con un identificador determinado
     *
     * @param id Nuevo identificador de la calificación
     */
    public Calificacion(int id) {
        this.id = id;
        this.software = new Software();
        this.etiqueta = new Etiqueta();
        this.porcentaje = 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la calificación
     *
     * @return Identificador de la calificación
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador de la calificacion
     *
     * @param id Nuevo identificador de la calificación
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el software calificado
     *
     * @return Software calificado
     */
    public Software getSoftware() {
        return this.software;
    }

    /**
     * Cambia el softare calificado
     *
     * @param software Nuevo software calificado
     */
    public void setSoftware(Software software) {
        this.software = software;
    }

    /**
     * Trae la etiqueta calificada
     *
     * @return Etiqueta calificada
     */
    public Etiqueta getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Cambia la etiqueta calificada
     *
     * @param etiqueta Nueva etiqueta calificado
     */
    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Trae el porcentaje de la calificación
     *
     * @return Porcentaje de la calificación
     */
    public int getPorcentaje() {
        return this.porcentaje;
    }

    /**
     * Cambia el porcentaje de la calificacion
     *
     * @param porcentaje Nuevo porcentaje de la calificación
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"software\": " + this.software + ","
                + "\"etiqueta\": " + this.etiqueta + ","
                + "\"porcentaje\": " + this.porcentaje
                + "}";
    }
    //</editor-fold>
}
