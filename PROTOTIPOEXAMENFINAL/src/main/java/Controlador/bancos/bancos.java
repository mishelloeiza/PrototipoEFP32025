package Controlador.banco;

// MISHEL LOEIZA 9959-23-3457
// Nombres de los getters, setters y variables igual al nombre en base de datos
// Nombre del archivo Java igual que la tabla
// Se usó encapsulate field para get y set

public class banco {

    private int id_banco;
    private String idTipo_bodega;
    private String nombre;
    private String direccion;
    private String status;

    // Constructor vacío
    public banco() {
    }

    // Constructor con campos
    public banco(int id_banco, String idTipo_bodega, String nombre, String direccion, String status) {
        this.id_banco = id_banco;
        this.idTipo_bodega = idTipo_bodega;
        this.nombre = nombre;
        this.direccion = direccion;
        this.status = status;
    }

    @Override
    public String toString() {
        return "banco{" +
                "id_banco=" + id_banco +
                ", idTipo_bodega='" + idTipo_bodega + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getIdTipo_bodega() {
        return idTipo_bodega;
    }

    public void setIdTipo_bodega(String idTipo_bodega) {
        this.idTipo_bodega = idTipo_bodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
