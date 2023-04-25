public class Teste{
    public static void main(String[] args) {

        FilaFifo fila = new FilaFifo();
        fila.enqueue(80);
        fila.enqueue(30);

        System.out.println(fila.rear());
        System.out.println(fila.front());
        System.out.println(fila.size());
        System.out.println(fila.isEmpty());

        fila.dequeue();
        System.out.println(fila.rear());
    }
}
