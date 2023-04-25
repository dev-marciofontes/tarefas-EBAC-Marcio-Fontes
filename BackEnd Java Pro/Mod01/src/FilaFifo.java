public class FilaFifo {

    // Nó interno para armazenar os elementos da fila
    private static class Node {
        int valor;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Node frente; // Nó da frente da fila
    private Node traseira;  // Nó do fim da fila
    private int tamanho;   // Tamanho da fila

    // Construtor da fila
    public FilaFifo() {
        frente = null;
        traseira = null;
        tamanho = 0;
    }

    // Método enqueue(): adiciona um inteiro à fila
    public void enqueue(int valor) {
        Node newNode = new Node(valor);

        if (traseira != null) {
            traseira.proximo = newNode;
        }

        traseira = newNode;

        if (frente == null) {
            frente = traseira;
        }

        tamanho++;
    }

    // Método dequeue(): remove e retorna um inteiro da fila
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        }

        int value = frente.valor;
        frente = frente.proximo;

        if (frente == null) {
            traseira = null;
        }

        tamanho--;
        return value;
    }

    // Método rear(): retorna o inteiro que está no fim da fila
    public int rear() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        }

        return traseira.valor;
    }

    // Método front(): retorna o inteiro que está na frente da fila
    public int front() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
        }

        return frente.valor;
    }

    // Método size(): retorna o tamanho da fila
    public int size() {
        return tamanho;
    }

    // Método isEmpty(): retorna true se a fila estiver vazia, false caso contrário
    public boolean isEmpty() {
        return frente == null;
    }


}


