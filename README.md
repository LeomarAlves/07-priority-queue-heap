# Fila de Prioridade com Heap

Este projeto implementa uma **Fila de Prioridade** utilizando a estrutura de dados **Heap** (especificamente um Max-Heap), aplicada a um sistema de triagem hospitalar. A implementação garante que elementos com maior prioridade sejam atendidos primeiro.

## 📌 Descrição

O sistema simula o atendimento de pacientes baseado em critérios de urgência. A prioridade é definida pela implementação da interface `Comparable` na classe `Paciente`, levando em conta:
1. **Nível de Urgência**: Maior valor indica maior prioridade.
2. **Tempo de Espera**: Em caso de empate na urgência, quem espera há mais tempo tem prioridade.
3. **Grupo de Vulnerabilidade**: Critério de desempate final.

### Estrutura do Projeto

*   `src/entidades/`: Contém as classes de modelo (`Pessoa`, `Paciente`).
*   `src/estatica/`: Implementações de filas estáticas tradicionais.
*   `src/heap/`: Implementação da Fila de Prioridade utilizando a estrutura de Heap.
*   `src/Main.java`: Ponto de entrada para demonstração da funcionalidade.

## 🚀 Requisitos

*   **Java JDK 11** ou superior.
*   Um terminal ou IDE (IntelliJ IDEA, Eclipse, VS Code).

## 🛠️ Compilação e Execução

### Via Terminal

1.  **Navegue até a pasta raiz do projeto:**
    ```bash
    cd 07-priority-queue-heap
    ```

2.  **Compile os arquivos `.java`:**
    ```bash
    javac -d out src/**/*.java src/*.java
    ```

3.  **Execute a classe principal:**
    ```bash
    java -cp out Main
    ```

## 📊 Funcionamento do Heap

A `FilaComPrioridadeHeap` utiliza um array para representar uma árvore binária quase completa, onde:
- **Enfileirar (`sobeHeap`)**: O novo elemento é adicionado ao final e "sobe" na árvore até que a propriedade do Max-Heap seja restaurada.
- **Desenfileirar (`desceHeap`)**: O elemento do topo (raiz/maior prioridade) é removido, o último elemento ocupa seu lugar e "desce" na árvore para manter a integridade do Heap.

## 📝 Exemplo de Saída

Ao executar o `Main.java`, você verá a inserção dos pacientes e a subsequente ordem de atendimento:

```text
=== REGISTRANDO CHEGADA DOS PACIENTES ===
Inserido: Carlos
Estado do Heap: [ PacienteCarlos (Urg: 1, Esp: 45, Vuln: false) ]
...

=== ORDEM DE ATENDIMENTO (DESENFILEIRANDO) ===
1. Maria (Urgência: 5, Espera: 5m, Vuln: false)
2. Pedro (Urgência: 5, Espera: 2m, Vuln: false)
3. Beatriz (Urgência: 3, Espera: 35m, Vuln: true)
...
```
