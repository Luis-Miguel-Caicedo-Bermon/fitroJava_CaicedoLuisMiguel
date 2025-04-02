package modelo;

public class Mision {
    private int id;
    private String descripcion;
    private String rango;
    private double recompensa;

    public Mision() {
    }

    public Mision(int id, String descripcion, String rango, double recompensa) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", rango='" + rango + '\'' +
                ", recompensa=" + recompensa +
                '}';
    }
}
