package ecci.entidades;

/**
 * Software libre que se desea clificar y presentar
 *
 * @author
 */
public class Software {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador del software
     */
    private int id;

    /**
     * Nombre del software
     */
    private String nombre;

    /**
     * Descripción del software
     */
    private String descripcion;

    /**
     * Licencia del software
     */
    private String licencia;

    /**
     * Url del software
     */
    private String url;

    /**
     * Versión actual del software
     */
    private String version;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Software() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.licencia = "";
        this.url = "";
        this.version = "";
    }

    /**
     * Crea un software con un determinado identificador
     *
     * @param id Identificador del software
     */
    public Software(int id) {
        this.id = id;
        this.nombre = "";
        this.descripcion = "";
        this.licencia = "";
        this.url = "";
        this.version = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del software
     *
     * @return El identificador del software
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador del software
     *
     * @param id Nuevo identificador del software
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre del software
     *
     * @return El nombre del software
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del software
     *
     * @param nombre El nuevo nombre del software
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Trae la decripción del software
     *
     * @return La decripción del software
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la decripción del software
     *
     * @param descripcion La bueva decripción del software
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Trae la licencia del software
     *
     * @return La licencia del software
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * Cambia la licencia del software
     *
     * @param licencia La nueva licencia del software
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * Trae la url del software
     *
     * @return La url del software
     */
    public String getUrl() {
        return url;
    }

    /**
     * Cambia la url del software
     *
     * @param url La nueva url del software
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Trae la versión del software
     *
     * @return La versión del software
     */
    public String getVersion() {
        return version;
    }

    /**
     * Cambia la versión del software
     *
     * @param version La nueva versión del software
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"nombre\": \"" + this.nombre + "\","
                + "\"descripcion\": \"" + this.descripcion + "\","
                + "\"licencia\": \"" + this.licencia + "\","
                + "\"url\": \"" + this.url + "\","
                + "\"version\": \"" + this.version + "\""
                + "}";
    }
    //</editor-fold>
}
