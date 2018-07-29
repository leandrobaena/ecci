package ecci.entidades;

/**
 *
 * @author
 */
public class Permiso {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del permiso
     */
    private int id;

    /**
     * Grupo al que se le asigna el permiso
     */
    private Grupo grupo;

    /**
     * Nivel de acceso que se le asigna el permiso
     */
    private NivelAcceso nivelAcceso;

    /**
     * Módulo al que se le da permiso
     */
    private Modulo modulo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del módulo
     */
    public Permiso() {
        this.id = 0;
        this.grupo = new Grupo();
        this.nivelAcceso = new NivelAcceso();
        this.modulo = new Modulo();
    }

    /**
     * Crea un permiso conun identificador determinado
     */
    public Permiso(int id) {
        this.id = id;
        this.grupo = new Grupo();
        this.nivelAcceso = new NivelAcceso();
        this.modulo = new Modulo();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del permiso
     *
     * @return Identificador del permiso
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del permio
     *
     * @param id Nuevo identificador del permiso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el grupo al que se le da permiso
     *
     * @return Grupo al que se le da permiso
     */
    public Grupo getGrupo() {
        return this.grupo;
    }

    /**
     * Cambia el grupo al que se le da permiso
     *
     * @param grupo Nuevo grupo al que se la permiso
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * Trae el nivel de acceso dado en el permiso
     *
     * @return Nivel de acceso dado en el permiso
     */
    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    /**
     * Cambia el nivel de acceso dado en el permiso
     *
     * @param nivelAcceso Nuevo nivel de acceso dado en el permiso
     */
    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    /**
     * Trae el módulo al que se le da permiso
     *
     * @return Módulo al que se le da permiso
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * Cambia el módulo al que se le da permiso
     *
     * @param modulo Nuevo módulo al que se le da permiso
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"grupo\": " + this.grupo + ","
                + "\"nivelAcceso\": " + this.nivelAcceso + ","
                + "\"modulo\": " + this.modulo
                + "}";
    }
    //</editor-fold>
}
