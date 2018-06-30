package ecci.entidades;



/**
 *
 * @author
 */
public class Profesion {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador de la profesión
     */
    private int id;

    /**
     * Nombre de la profesión
     */
    private String nombre;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto de la profesión
     */
    public Profesion() {
        this.id = 0;
        this.nombre = "";
    }

    /**
     * Crea una profesión con un identificador determinado
     */
    public Profesion(int id) {
        this.id = id;
        this.nombre = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la profesión
     *
     * @return Identificador de la profesión
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador de la profesión
     *
     * @param id Nuevo identificador de la profesión
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre de la profesión
     *
     * @return Nombre de la profesión
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre de la profesión
     *
     * @param nombre Nuevo nombre de la profesión
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>
}
