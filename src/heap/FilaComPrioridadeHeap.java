package heap;

import estatica.FilaEstatica;

/**
 * Implementação de uma Fila de Prioridade utilizando a estrutura de um Heap Binário Máximo.
 * Herda a infraestrutura de armazenamento estático da classe {@link FilaEstatica}.
 * <p>
 * Os elementos são organizados em uma árvore binária compacta representada em array,
 * onde a raiz (índice 0) armazena permanentemente o elemento de maior prioridade.
 * </p>
 *  @param <T> O tipo de elemento armazenado na fila.
 * @author Leomar Alves Marcelino
 * @version 1.0
 */
public class FilaComPrioridadeHeap<T> extends FilaEstatica<T> {

    /**
     * Constrói uma fila com prioridade baseada em heap com uma capacidade inicial fixa.
     * @param capacidade O tamanho máximo permitido para o array interno da fila.
     */
    public FilaComPrioridadeHeap(int capacidade) {
        super(capacidade);
    }

    /**
     * Enfileira um novo elemento na estrutura do Heap.
     * O elemento é inserido na última posição livre e rearranjado usando o algoritmo Sobe Heap.
     *  @param elemento O objeto a ser inserido na fila.
     * @throws RuntimeException Se a fila estiver cheia.
     */
    @Override
    public void enfileirar(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("A fila está cheia.");
        }

        elementos[tamanho] = elemento;
        tamanho++;

        sobeHeap(tamanho - 1);
    }

    /**
     * Remove e retorna o elemento de maior prioridade (localizado na raiz do Heap).
     * O último elemento substitui a raiz temporariamente e é rearranjado usando o algoritmo Desce Heap.
     *  @return O elemento com maior nível de prioridade clínica.
     * @throws RuntimeException Se a fila estiver vazia.
     */
    @Override
    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia.");
        }

        T elementoRemovido = elementos[0];

        elementos[0] = elementos[tamanho - 1];
        elementos[tamanho - 1] = null;
        tamanho--;

        if (!estaVazia()) {
            desceHeap(0);
        }

        return elementoRemovido;
    }

    /**
     * Realiza a subida do elemento no Heap (Up-Heap / Bubble-Up) para restaurar a propriedade do Heap Máximo.
     * Realiza o cast dinâmico para {@link Comparable} para efetuar as comparações de prioridade.
     * @param indice O índice inicial do elemento que deve subir na árvore.
     */
    @SuppressWarnings("unchecked")
    private void sobeHeap(int indice) {
        int indicePai = (indice - 1) / 2;

        while (indice > 0) {
            Comparable<T> atual = (Comparable<T>) elementos[indice];

            if (atual.compareTo(elementos[indicePai]) > 0) {
                trocar(indice, indicePai);
                indice = indicePai;
                indicePai = (indice - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     * Realiza a descida do elemento no Heap (Down-Heap / Bubble-Down) para restaurar a propriedade do Heap Máximo.
     * Compara o nó atual com seus dois filhos (esquerdo e direito) e realiza as trocas necessárias.
     *  @param indice O índice inicial do elemento que deve descer na árvore.
     */
    @SuppressWarnings("unchecked")
    private void desceHeap(int indice) {
        int maior = indice;
        int filhoEsquerdo = 2 * indice + 1;
        int filhoDireito = 2 * indice + 2;

        if (filhoEsquerdo < tamanho) {
            Comparable<T> esquerdo = (Comparable<T>) elementos[filhoEsquerdo];
            if (esquerdo.compareTo(elementos[maior]) > 0) {
                maior = filhoEsquerdo;
            }
        }

        if (filhoDireito < tamanho) {
            Comparable<T> direito = (Comparable<T>) elementos[filhoDireito];
            if (direito.compareTo(elementos[maior]) > 0) {
                maior = filhoDireito;
            }
        }

        if (maior != indice) {
            trocar(indice, maior);
            desceHeap(maior);
        }
    }

    /**
     * Auxilia na troca de posição de dois elementos dentro do array interno.
     *  @param i Índice do primeiro elemento.
     * @param j Índice do segundo elemento.
     */
    private void trocar(int i, int j) {
        T temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }

    /**
     * Retorna o estado interno do array do heap para fins de debug e testes.
     *  @return Uma string contendo a sequência linear do Heap.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) {
                sb.append(" | ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}