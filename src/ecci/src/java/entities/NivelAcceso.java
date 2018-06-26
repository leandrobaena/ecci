package entities;

/**
 *
 * @author
 */
public class NivelAcceso {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del nivel de acceso
     */
    private int id;

    /**
     * Nombre del nivel de acceso
     */
    private String nombre;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del nivel de acceso
     */
    public NivelAcceso() {
        this.id = 0;
        this.nombre = "";
    }

    /**
     * Constructor
     */
    public NivelAcceso(int id) {
        this.id = id;
        this.nombre = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del nivel de acceso
     *
     * @return Identificador del nivel de acceso
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del nivel de acceso
     *
     * @param id Nuevo identificador del nivel de acceso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre del nivel de acceso
     *
     * @return Nombre del nivel de acceso
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre del nivel de acceso
     *
     * @param nombre Nuevo nombre del nivel de acceso
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>
}
