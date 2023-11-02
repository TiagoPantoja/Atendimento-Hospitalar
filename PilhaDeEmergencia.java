import java.util.Stack;

public class PilhaDeEmergencia {
    private Stack<Paciente> pilhaDeEmergencia = new Stack<>();

    public void adicionaPaciente(Paciente paciente) {
        pilhaDeEmergencia.push(paciente);
    }

    public Paciente proximoPaciente() {
        return pilhaDeEmergencia.pop();
    }

    public boolean estaVazia() {
        return pilhaDeEmergencia.isEmpty();
    }
}
