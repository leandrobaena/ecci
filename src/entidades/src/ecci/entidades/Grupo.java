package ecci.entidades;



/**
 *
 * @author
 */
public class Grupo {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del grupo
     */
    private int id;

    /**
     * Nombre del grupo
     */
    private String nombre;

    /**
     * Si el grupo está o no activo
     */
    private boolean activo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del grupo
     */
    public Grupo() {
        this.id = 0;
        this.nombre = "";
        this.activo = false;
    }

    /**
     * Constructor
     * @param id Identificador del grupo
     */
    public Grupo(int id) {
        this.id = id;
        this.nombre = "";
        this.activo = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del grupo
     *
     * @return Identificador del grupo
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del grupo
     *
     * @param id Nuevo identificador del grupo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre del grupo
     *
     * @return Nombre del grupo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre del grupo
     *
     * @param nombre Nuevo nombre del grupo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Trae si el grupo está o no activo
     *
     * @return Si el grupo está o no activo
     */
    public boolean isActivo() {
        return this.activo;
    }

    /**
     * Cambia si el grupo está o no activo
     *
     * @param activo Si el grupo está o no activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
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
                + "\"activo\": " + (this.activo ? "true" : "false")
                + "}";
    }
    //</editor-fold>
}
