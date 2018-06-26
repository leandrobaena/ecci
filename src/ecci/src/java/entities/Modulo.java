package entities;

/**
 *
 * @author
 */
public class Modulo {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del módulo
     */
    private int id;

    /**
     * Nombre del módulo
     */
    private String nombre;

    /**
     * Si el módulo está o no activo
     */
    private boolean activo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del módulo
     */
    public Modulo() {
        this.id = 0;
        this.nombre = "";
        this.activo = false;
    }

    /**
     * Constructor
     */
    public Modulo(int id) {
        this.id = id;
        this.nombre = "";
        this.activo = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del módulo
     *
     * @return Identificador del módulo
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del módulo
     *
     * @param id Nuevo identificador del módulo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre del módulo
     *
     * @return Nombre del módulo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre del módulo
     *
     * @param nombre Nuevo nombre del módulo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Trae si el módulo está o no activo
     *
     * @return Si el módulo está o no activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Cambia si el módulo está o no activo
     *
     * @param activo Si el módulo está o no activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    //</editor-fold>
}
