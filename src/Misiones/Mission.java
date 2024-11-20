package Misiones;

public class Mission {
    private String descripcion;
    private boolean completada;
    private int recompensa;

    public Mission(String descripcion, boolean completada, int recompensa) {
        this.descripcion = descripcion;
        this.completada = completada;
        this.recompensa = recompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void completar() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return descripcion + " - " + (completada ? "Completada" : "Pendiente");
    }
}
