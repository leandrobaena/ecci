package entities;

/**
 *
 * @author
 */
public class Escolaridad {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del escolaridad
     */
    private int id;

    /**
     * Nombre del escolaridad
     */
    private String nombre;

    /**
     * Si el escolaridad está o no activo
     */
    private boolean activo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del escolaridad
     */
    public Escolaridad() {
        this.id = 0;
        this.nombre = "";
        this.activo = false;
    }

    /**
     * Constructor
     */
    public Escolaridad(int id) {
        this.id = id;
        this.nombre = "";
        this.activo = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del escolaridad
     *
     * @return Identificador del escolaridad
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del escolaridad
     *
     * @param id Nuevo identificador del escolaridad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre del escolaridad
     *
     * @return Nombre del escolaridad
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre del escolaridad
     *
     * @param nombre Nuevo nombre del escolaridad
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
