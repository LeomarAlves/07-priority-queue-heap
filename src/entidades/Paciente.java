package entidades;

/**
 * Representa a entidade de um Paciente no sistema de triagem do Hospital São Binário.
 * <p>
 * A prioridade de atendimento é determinada por três critérios em cascata:
 * 1. Nível de urgência (maior primeiro)
 * 2. Tempo de espera em minutos (maior primeiro)
 * 3. Pertencimento ao grupo vulnerável (true primeiro)
 * </p>
 * * @author Leomar Alves Marcelino
 * @version 1.0
 */
public class Paciente implements Comparable<Paciente> {

    /** Nome completo do paciente. */
    private String nome;

    /** Nível de urgência clínica variando de 1 (Azul) a 5 (Vermelho). */
    private int nivelUrgencia;

    /*TESTE*/

    /** Quantidade de minutos que o paciente está aguardando na fila. */
    private int tempoEsperaMinutos;

    /** Indica se o paciente pertence ao grupo vulnerável (menor de 12 anos ou maior de 65 anos). */
    private boolean grupoVulneravel;

    /**
     * Construtor completo para a criação de um paciente na triagem.
     * * @param nome                 Nome do paciente.
     * @param nivelUrgencia        Nível de urgência (1 a 5).
     * @param tempoEsperaMinutos   Tempo de espera em minutos.
     * @param grupoVulneravel      Se pertence ou não ao grupo vulnerável.
     */
    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    /** @return O nome do paciente. */
    public String getNome() { return nome; }

    /** @return O nível de urgência clínica (1 a 5). */
    public int getNivelUrgencia() { return nivelUrgencia; }

    /** @return O tempo de espera em minutos. */
    public int getTempoEsperaMinutos() { return tempoEsperaMinutos; }

    /** @return true se o paciente for vulnerável, false caso contrário. */
    public boolean isGrupoVulneravel() { return grupoVulneravel; }

    /**
     * Compara este paciente com outro para determinar a ordem de prioridade no Heap.
     * Implementa os critérios em cascata definidos pelo protocolo do hospital.
     * * @param outro O outro paciente a ser comparado.
     * @return Um número inteiro negativo, zero ou positivo se este paciente for,
     * respectivamente, menos prioritário, igual ou mais prioritário que o outro.
     */
    @Override
    public int compareTo(Paciente outro) {
        // 1. Nível de urgência (maior primeiro)
        int comparacaoUrgencia = Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
        if (comparacaoUrgencia != 0) {
            return comparacaoUrgencia;
        }

        // 2. Tempo de espera (maior primeiro)
        int comparacaoTempo = Integer.compare(this.tempoEsperaMinutos, outro.tempoEsperaMinutos);
        if (comparacaoTempo != 0) {
            return comparacaoTempo;
        }

        // 3. Grupo vulnerável (true primeiro)
        return Boolean.compare(this.grupoVulneravel, outro.grupoVulneravel);
    }

    /**
     * Retorna uma representação textual formatada do paciente.
     * * @return String contendo os dados clínicos do paciente.
     */
    @Override
    public String toString() {
        return nome + " (Urg: " + nivelUrgencia + ", Esp: " + tempoEsperaMinutos + "m, Vuln: " + grupoVulneravel + ")";
    }
}