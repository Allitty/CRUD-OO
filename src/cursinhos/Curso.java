package cursinhos;

public class Curso {
    private int id;
    private String nome;
    private String prof;
    private String desc;
    private double valor;

    public Curso(int id, String nome, String prof, String desc, double valor) {
        this.id = id;
        this.nome = nome;
        this.prof = prof;
        this.desc = desc;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + prof + "," + desc + "," + valor;
    }
}

