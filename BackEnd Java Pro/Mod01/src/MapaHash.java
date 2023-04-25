// JUSTIFICATIVA
/*
A função hash que eu escolhi utilizar foi a função de divisão, onde a chave é dividida pelo tamanho do mapa (10 neste caso) e o resto da divisão é usado como índice no array.
Escolhi essa função por ser simples de implementar e eficiente para um tamanho pequeno e fixo de mapa.
No entanto, depois de muito pesquisar eu vi que para aplicações reais e tamanhos maiores de mapa, eu teria que escolher funções hash mais avançadas e adaptáveis para poder reduzir colisões e melhorar a performance.
 */
public class MapaHash {
    private static final int TAMANHO = 10;
    private Entrada[] tabela;

    // Construtor
    public MapaHash() {
        tabela = new Entrada[TAMANHO];
    }

    // Adiciona o par chave/valor ao mapa
    public void put(int chave, int valor) {
        int indice = hash(chave);
        Entrada novaEntrada = new Entrada(chave, valor);

        if (tabela[indice] == null) {
            tabela[indice] = novaEntrada;
        } else {
            Entrada atual = tabela[indice];
            while (atual.proxima != null) {
                if (atual.chave == chave) {
                    atual.valor = valor;
                    return;
                }
                atual = atual.proxima;
            }

            if (atual.chave == chave) {
                atual.valor = valor;
            } else {
                atual.proxima = novaEntrada;
            }
        }
    }

    // Retorna o valor associado à chave passada via parâmetro
    public int get(int chave) {
        int indice = hash(chave);
        Entrada atual = tabela[indice];

        while (atual != null) {
            if (atual.chave == chave) {
                return atual.valor;
            }
            atual = atual.proxima;
        }

        return -1; // Chave não encontrada
    }

    // Remove o valor do topo da pilha e o retorna ao chamador
    public void delete(int chave) {
        int indice = hash(chave);

        if (tabela[indice] == null) {
            return; // Chave não encontrada
        }

        if (tabela[indice].chave == chave) {
            tabela[indice] = tabela[indice].proxima;
            return;
        }

        Entrada atual = tabela[indice];
        while (atual.proxima != null) {
            if (atual.proxima.chave == chave) {
                atual.proxima = atual.proxima.proxima;
                return;
            }
            atual = atual.proxima;
        }
    }

    // Remove todos os elementos do mapa
    public void clear() {
        tabela = new Entrada[TAMANHO];
    }

    // Função hash
    private int hash(int chave) {
        return chave % TAMANHO;
    }

    // Classe interna para representar uma entrada no mapa de hash
    private static class Entrada {
        int chave;
        int valor;
        Entrada proxima;

        public Entrada(int chave, int valor) {
            this.chave = chave;
            this.valor = valor;
            this.proxima = null;
        }
    }
}
