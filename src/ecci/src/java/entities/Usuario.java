package entities;

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
     * Contraseña de acceso del usuario
     */
    private String contrasenia;

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
        this.contrasenia = "";
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
        this.contrasenia = "";
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
     * Trae la contraseña del usuario
     *
     * @return Contraseña del usuario
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * Cambia la contrasenia del usuario
     *
     * @param contrasenia Nueva contrasenia del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
    //</editor-fold>
}
