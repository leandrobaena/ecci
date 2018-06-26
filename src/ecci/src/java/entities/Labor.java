package entities;

/**
 *
 * @author
 */
public class Labor {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador de la labor
     */
    private int id;

    /**
     * Nombre de la labor
     */
    private String nombre;

    /**
     * Si el escolaridad está o no activo
     */
    private boolean activo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto de la labor
     */
    public Labor() {
        this.id = 0;
        this.nombre = "";
        this.activo = false;
    }

    /**
     * Constructor
     */
    public Labor(int id) {
        this.id = id;
        this.nombre = "";
        this.activo = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la labor
     *
     * @return Identificador de la labor
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador de la labor
     *
     * @param id Nuevo identificador de la labor
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre de la labor
     *
     * @return Nombre de la labor
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre de la labor
     *
     * @param nombre Nuevo nombre de la labor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Trae si el escolaridad está o no activo
     *
     * @return Si el escolaridad está o no activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Cambia si el escolaridad está o no activo
     *
     * @param activo Si el escolaridad está o no activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    //</editor-fold>
}
