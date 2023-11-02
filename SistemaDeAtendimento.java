public class SistemaDeAtendimento {
    private FilaDeEspera filaDeEspera = new FilaDeEspera();
    private PilhaDeEmergencia pilhaCriticos = new PilhaDeEmergencia();
    private PilhaDeEmergencia pilhaGraves = new PilhaDeEmergencia();
    private PilhaDeEmergencia pilhaModerados = new PilhaDeEmergencia();

    private int pacientesAtendidosCriticos = 0;
    private int pacientesAtendidosGraves = 0;
    private int pacientesAtendidosModerados = 0;
    private int tempoTotalEspera = 0;
    private int totalPacientesAtendidos = 0;

    public void adicionaPaciente(Paciente paciente) {
        if (paciente.getEstadoUrgencia() == EstadoUrgencia.CRÍTICO) {
            pilhaCriticos.adicionaPaciente(paciente);
            pacientesAtendidosCriticos++;
        } else if (paciente.getEstadoUrgencia() == EstadoUrgencia.GRAVE) {
            pilhaGraves.adicionaPaciente(paciente);
            pacientesAtendidosGraves++;
        } else if (paciente.getEstadoUrgencia() == EstadoUrgencia.MODERADO) {
            pilhaModerados.adicionaPaciente(paciente);
            pacientesAtendidosModerados++;
        } else {
            filaDeEspera.adicionaPaciente(paciente);
        }
    }
    public Paciente atendeProximoPaciente() {
        if (!pilhaCriticos.estaVazia()) {
            Paciente paciente = pilhaCriticos.proximoPaciente();
            pacientesAtendidosCriticos++;
            tempoTotalEspera += paciente.getTempoEspera();
            totalPacientesAtendidos++;
            return paciente;
        } else if (!pilhaGraves.estaVazia()) {
            Paciente paciente = pilhaGraves.proximoPaciente();
            pacientesAtendidosGraves++;
            tempoTotalEspera += paciente.getTempoEspera();
            totalPacientesAtendidos++;
            return paciente;
        } else if (!pilhaModerados.estaVazia()) {
            Paciente paciente = pilhaModerados.proximoPaciente();
            pacientesAtendidosModerados++;
            tempoTotalEspera += paciente.getTempoEspera();
            totalPacientesAtendidos++;
            return paciente;
        } else if (!filaDeEspera.estaVazia()) {
            Paciente paciente = filaDeEspera.proximoPaciente();
            tempoTotalEspera += paciente.getTempoEspera();
            totalPacientesAtendidos++;
            return paciente;
        } else {
            return null;
        }
    }

    public int pacientesAtendidosCriticos() {
        return pacientesAtendidosCriticos;
    }

    public int pacientesAtendidosGraves() {
        return pacientesAtendidosGraves;
    }

    public int pacientesAtendidosModerados() {
        return pacientesAtendidosModerados;
    }

    public double tempoMedioDeEspera() {
        if (totalPacientesAtendidos == 0) {
            return 0;
        } else {
            return tempoTotalEspera / totalPacientesAtendidos;
        }
    }
}