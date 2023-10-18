public class Estudante {
    private int id;
    private String matricula;

    public Estudante(int id, String matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Estudante [id=" + id + ", matricula=" + matricula + "]";
    }
}
