package ecci.entidades;

/**
 *
 * @author
 */
public class Usuario {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del usuario
     */
    private int id;

    /**
     * Login del usuario
     */
    private String login;

    /**
     * Nombres del usuario
     */
    private String nombres;

    /**
     * Apellidos del usuario
     */
    private String apellidos;

    /**
     * Si el usuario está o no activo
     */
    private boolean activo;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto del usuario
     */
    public Usuario() {
        this.id = 0;
        this.login = "";
        this.nombres = "";
        this.apellidos = "";
        this.activo = false;
    }

    /**
     * Constructor
     */
    public Usuario(int id) {
        this.id = id;
        this.login = "";
        this.nombres = "";
        this.apellidos = "";
        this.activo = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del usuario
     *
     * @return Identificador del usuario
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador del usuario
     *
     * @param id Nuevo identificador del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el login del usuario
     *
     * @return Login del usuario
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Cambia el login del usuario
     *
     * @param login Nuevo login del usuario
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Trae los nombres del usuario
     *
     * @return Nombres del usuario
     */
    public String getNombres() {
        return this.nombres;
    }

    /**
     * Cambia los nombres del usuario
     *
     * @param nombres Nuevos nombres del usuario
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Trae los apellidos del usuario
     *
     * @return Apellidos del usuario
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Cambia los apellidos del usuario
     *
     * @param apellidos Nuevos apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Trae si el usuario está o no activo
     *
     * @return Si el usuario está o no activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Cambia si el usuario está o no activo
     *
     * @param activo Si el usuario está o no activo
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
                + "\"login\": \"" + this.login + "\","
                + "\"nombres\": \"" + this.nombres + "\","
                + "\"apellidos\": \"" + this.apellidos + "\","
                + "\"activo\": " + (this.activo ? "true" : "false")
                + "}";
    }
    //</editor-fold>
}
