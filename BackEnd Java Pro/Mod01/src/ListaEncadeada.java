public class ListaEncadeada {

    // Nó interno para armazenar os elementos da lista encadeada
    private static class Node {
        int valor;
        Node proximo;

        public Node(int value) {
            this.valor = value;
            this.proximo = null;
        }
    }

    private Node head; // Cabeça da lista encadeada
    private int tamanho;  // Tamanho da lista encadeada

    // Construtor da lista encadeada
    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    // Método push(): adiciona um nó ao fim da lista
    public void push(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.proximo != null) {
                currentNode = currentNode.proximo;
            }
            currentNode.proximo = newNode;
        }
        tamanho++;
    }

    // Método pop(): remove e retorna o nó no fim da lista
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista encadeada vazia");
        }

        int value;
        if (head.proximo == null) {
            value = head.valor;
            head = null;
        } else {
            Node currentNode = head;
            while (currentNode.proximo.proximo != null) {
                currentNode = currentNode.proximo;
            }
            value = currentNode.proximo.valor;
            currentNode.proximo = null;
        }
        tamanho--;
        return value;
    }

    // Método insert(): adiciona um nó na posição da lista indicada via parâmetro
    public void insert(int index, int valor) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }

        Node newNode = new Node(valor);

        if (index == 0) {
            newNode.proximo = head;
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.proximo;
            }
            newNode.proximo = currentNode.proximo;
            currentNode.proximo = newNode;
        }
        tamanho++;
    }

    // Método remove(): remove um nó na posição da lista indicada via parâmetro
    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }

        if (index == 0) {
            head = head.proximo;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.proximo;
            }
            currentNode.proximo = currentNode.proximo.proximo;
        }
        tamanho--;
    }

    // Método elementAt(): retorna o elemento que está no índice da lista indicado via parâmetro
    public int elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.proximo;
        }

        return currentNode.valor;
    }

    // Método size(): retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Método isEmpty(): retorna true se a lista estiver vazia, false caso contrário
    public boolean isEmpty() {
        return head == null;
    }

    // Método printList(): imprime uma representação em texto da lista
    public void printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista Encadeada: [");

        Node currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.valor);
            if (currentNode.proximo != null) {
                sb.append(", ");
            }
            currentNode = currentNode.proximo;
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
