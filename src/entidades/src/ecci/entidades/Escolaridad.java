package ecci.entidades;



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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del escolaridad
     */
    public Escolaridad() {
        this.id = 0;
        this.nombre = "";
    }

    /**
     * Constructor
     */
    public Escolaridad(int id) {
        this.id = id;
        this.nombre = "";
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
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"nombre\": \"" + this.nombre + "\""
                + "}";
    }
    //</editor-fold>
}
