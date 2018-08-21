package ecci.entidades;

/**
 *
 * @author
 */
public class Metrica {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Nombre del software encontrado con la métrica
     */
    private String nombre;

    /**
     * Descripción del software encontrado con la métrica
     */
    private String descripcion;

    /**
     * Tipo de licencia que tiene el software encontrado con la métrica
     */
    private String licencia;

    /**
     * Url de descarga del software encontrado con la métrica
     */
    private String url;

    /**
     * Versión del software encntrad con la métrica
     */
    private String version;

    /**
     * Necesidad satisfecha con el software encontrado con la métrica
     */
    private String necesidad;

    /**
     * Porcentaje de aproximación del software encontrado con la métrica
     */
    private int porcentaje;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del escolaridad
     */
    public Metrica() {
        this.nombre = "";
        this.descripcion = "";
        this.licencia = "";
        this.url = "";
        this.version = "";
        this.necesidad = "";
        this.porcentaje = 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el nombre del software encontrado con la métrica
     *
     * @return El nombre del software encontrado con la métrica
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre del software encontrado con la métrica
     *
     * @param nombre Nuevo nombre del software encontrado con la métrica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Trae la descripción del software encontrado con la métrica
     *
     * @return Descripción del software encontrado con la métrica
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Cambia la descripción del software encontrado con la métrica
     *
     * @param descripcion Nueva descripción del software encontrado con la
     * métrica
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Trae el tipo de licencia que tiene el software encontrado con la métrica
     *
     * @return Tipo de licencia que tiene el software encontrado con la métrica
     */
    public String getLicencia() {
        return this.licencia;
    }

    /**
     * Cambia el tipo de licencia que tiene el software encontrado con la
     * métrica
     *
     * @param licencia Tipo de licencia que tiene el software encontrado con la
     * métrica
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * Trae la url de descarga del software encontrado con la métrica
     *
     * @return Url de descarga del software encontrado con la métrica
     */
    public String getUrl() {
        return url;
    }

    /**
     * Cambia la url de descarga del software encontrado con la métrica
     *
     * @param url Nueva url de descarga del software encontrado con la métrica
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Trae la versión del software encntrad con la métrica
     *
     * @return Versión del software encntrad con la métrica
     */
    public String getVersion() {
        return version;
    }

    /**
     * Cambia la versión del software encntrad con la métrica
     *
     * @param version Nueva versión del software encntrad con la métrica
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Trae la cecesidad satisfecha con el software encontrado con la métrica
     *
     * @return Necesidad satisfecha con el software encontrado con la métrica
     */
    public String getNecesidad() {
        return necesidad;
    }

    /**
     * Cambia la necesidad satisfecha con el software encontrado con la métrica
     *
     * @param necesidad Nueva necesidad satisfecha con el software encontrado
     * con la métrica
     */
    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }

    /**
     * Trae el porcentaje de aproximación del software encontrado con la métrica
     *
     * @return Porcentaje de aproximación del software encontrado con la métrica
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * Cambia el porcentaje de aproximación del software encontrado con la
     * métrica
     *
     * @param porcentaje Nuevo porcentaje de aproximación del software
     * encontrado con la métrica
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
        return "{\"nombre\": \"" + this.nombre + "\","
                + "\"descripcion\": \"" + this.descripcion + "\","
                + "\"licencia\": \"" + this.licencia + "\","
                + "\"url\": \"" + this.url + "\","
                + "\"version\": \"" + this.version + "\","
                + "\"necesidad\": \"" + this.necesidad + "\","
                + "\"porcentaje\": " + this.porcentaje
                + "}";
    }
    //</editor-fold>
}
