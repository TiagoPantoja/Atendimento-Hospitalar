public class Paciente {
    private String nome;
    private int idade;
    private EstadoUrgencia estadoUrgencia;
    private int tempoEspera;

    public Paciente(String nome, int idade, EstadoUrgencia estadoUrgencia, int tempoEspera) {
        this.nome = nome;
        this.idade = idade;
        this.estadoUrgencia = estadoUrgencia;
        this.tempoEspera = tempoEspera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public EstadoUrgencia getEstadoUrgencia() {
        return estadoUrgencia;
    }

    public void setEstadoUrgencia(EstadoUrgencia estadoUrgencia) {
        this.estadoUrgencia = estadoUrgencia;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public String toString() {
        return "Paciente: {" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estadoUrgencia='" + estadoUrgencia + '\'' +
                ", tempoEspera=" + tempoEspera +
                '}';
    }
}
