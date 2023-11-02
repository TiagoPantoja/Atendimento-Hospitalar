import java.util.Queue;
import java.util.LinkedList;

public class FilaDeEspera {
    private Queue<Paciente> filaDeEspera = new LinkedList<>();

    public void adicionaPaciente(Paciente paciente) {
        filaDeEspera.add(paciente);
    }

    public Paciente proximoPaciente() {
        return filaDeEspera.poll();
    }

    public boolean estaVazia() {
        return filaDeEspera.isEmpty();
    }
}
