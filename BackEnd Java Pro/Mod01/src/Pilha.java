public class Pilha {

    // Nó interno para armazenar os elementos da pilha
    private static class No {
        int valor;
        No proximoValor;

        public No(int valor) {
            this.valor = valor;
            this.proximoValor = null;
        }
    }

    private No topo; // Nó de topo da pilha
    private int tamanhoPilha; // Tamanho da pilha

    // Construtor da pilha
    public Pilha() {
        topo = null;
        tamanhoPilha = 0;
    }

    // Método push(): adiciona um inteiro no topo da pilha
    public void push(int valor) {
        No novoNo = new No(valor);
        novoNo.proximoValor = topo;
        topo = novoNo;
        tamanhoPilha++;
    }

    // Método pop(): remove e retorna o valor do topo da pilha
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }

        int valor = topo.valor;
        topo = topo.proximoValor;
        tamanhoPilha--;
        return valor;
    }

    // Método top(): retorna o valor do topo da pilha sem removê-lo
    public int top() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }

        return topo.valor;
    }

    // Método isEmpty(): retorna true se a pilha estiver vazia, false caso contrário
    public boolean isEmpty() {
        return topo == null;
    }

    // Método size(): retorna o número de elementos da pilha
    public int size() {
        return tamanhoPilha;
    }

}
