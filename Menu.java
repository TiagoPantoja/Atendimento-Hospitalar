import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        SistemaDeAtendimento sistemaDeAtendimento = new SistemaDeAtendimento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Atendimento Hospitalar");
            System.out.println("(1) Adicionar Paciente");
            System.out.println("(2) Atender Paciente");
            System.out.println("(3) Exibir Estatísticas");
            System.out.println("(4) Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do paciente: ");
                    String nome = scanner.next();
                    System.out.println("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.println("Estado de urgência: Crítico, Grave ou Moderado");
                    String estadoUrgenciaStr = scanner.next();
                    EstadoUrgencia estadoUrgencia = null;

                    if (estadoUrgenciaStr.equalsIgnoreCase("Crítico")) {
                        estadoUrgencia = EstadoUrgencia.CRÍTICO;
                    } else if (estadoUrgenciaStr.equalsIgnoreCase("Grave")) {
                        estadoUrgencia = EstadoUrgencia.GRAVE;
                    } else if (estadoUrgenciaStr.equalsIgnoreCase("Moderado")) {
                        estadoUrgencia = EstadoUrgencia.MODERADO;
                    } else {
                        System.out.println("Estado de urgência inválido");
                        break;
                    }

                    System.out.println("Tempo de espera: ");
                    int tempoEspera = scanner.nextInt();
                    Paciente paciente = new Paciente(nome, idade, estadoUrgencia, tempoEspera);
                    sistemaDeAtendimento.adicionaPaciente(paciente);
                    break;

                case 2:
                    Paciente pacienteAtendido = sistemaDeAtendimento.atendeProximoPaciente();
                    if (pacienteAtendido != null) {
                        System.out.println("Paciente atendido: " + pacienteAtendido);
                    } else {
                        System.out.println("Não há pacientes");
                    }
                    break;

                case 3:
                    System.out.println("Estatísticas: ");
                    System.out.println("Pacientes Estado Crítico: " + sistemaDeAtendimento.pacientesAtendidosCriticos());
                    System.out.println("Pacientes Estado Grave: " + sistemaDeAtendimento.pacientesAtendidosGraves());
                    System.out.println("Pacientes Estado Moderado: " + sistemaDeAtendimento.pacientesAtendidosModerados());
                    System.out.println("Tempo Médio de Espera: " + sistemaDeAtendimento.tempoMedioDeEspera());
                    break;

                case 4:
                    System.out.println("Saindo");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
