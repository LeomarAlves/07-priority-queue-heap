import entidades.Paciente;

import heap.FilaComPrioridadeHeap;

/**
 * Classe principal para execução do sistema de triagem do Hospital São Binário.
 * <p>
 * Esta classe simula o fluxo de entrada de 6 pacientes de teste, exibe o comportamento
 * interno da árvore binária (Heap) passo a passo e descarrega a fila gerando a ordem de chamada.
 * </p>
 *  @author Leomar Alves Marcelino
 * @version 1.0
 */
public class Main {

    /**
     * Ponto de entrada principal do programa.
     *  @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        FilaComPrioridadeHeap<Paciente> filaDeTriagem = new FilaComPrioridadeHeap<>(10);

        Paciente p1 = new Paciente("Carlos", 1, 45, false);
        Paciente p2 = new Paciente("Maria", 5, 5, false);
        Paciente p3 = new Paciente("João", 3, 20, false);
        Paciente p4 = new Paciente("Beatriz", 3, 35, true);
        Paciente p5 = new Paciente("Pedro", 5, 2, false);
        Paciente p6 = new Paciente("Helena", 2, 45, true);

        System.out.println("=== REGISTRANDO CHEGADA DOS PACIENTES ===\n");

        Paciente[] pacientes = {p1, p2, p3, p4, p5, p6};

        for (Paciente p : pacientes) {
            filaDeTriagem.enfileirar(p);
            System.out.println("Inserido: " + p.getNome());
            System.out.println("Estado do Heap: " + filaDeTriagem.toString() + "\n");
        }

        System.out.println("=== ORDEM DE ATENDIMENTO (DESENFILEIRANDO) ===\n");

        int contador = 1;
        while (!filaDeTriagem.estaVazia()) {
            Paciente atendido = filaDeTriagem.desenfileirar();
            System.out.println(contador + ". " + atendido.getNome()
                    + " (Urgência: " + atendido.getNivelUrgencia()
                    + ", Espera: " + atendido.getTempoEsperaMinutos()
                    + "m, Vuln: " + atendido.isGrupoVulneravel() + ")");
            contador++;
        }
    }
}