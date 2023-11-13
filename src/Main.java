import java.util.Scanner;

public class Main {

    public static class FilaEstatica {
        private int vetor[];
        private int inicio;
        private int ultimo;
        private int nElementos;

        public FilaEstatica(int capacidade) {
            this.vetor = new int[capacidade];
            this.inicio = 0;
            this.ultimo = 0;
            this.nElementos = 0;
        }

        public boolean estaVazia() {
            return this.nElementos == 0;
        }

        public boolean estaCheia() {
            return this.nElementos == this.vetor.length;
        }

        public int tamanho() {
            return this.nElementos;
        }

        public void enfileira(int elemento) {
            if (this.estaCheia()) {
                System.out.println("Fila cheia! Não é possível enfileirar.");
                return;
            }

            this.vetor[this.ultimo] = elemento;
            this.ultimo = (this.ultimo + 1) % this.vetor.length;
            this.nElementos++;
        }

        public Integer desenfileira() {
            if (this.estaVazia()) {
                System.out.println("Fila vazia! Não é possível desenfileirar.");
                return null;
            }

            int removido = this.vetor[this.inicio];
            this.inicio = (this.inicio + 1) % this.vetor.length;
            this.nElementos--;

            return removido;
        }

        public Integer espia() {
            if (this.estaVazia()) {
                System.out.println("Fila vazia! Não é possível espiar.");
                return null;
            }

            return this.vetor[this.inicio];
        }

        public static int calculaDias(int n, int m, FilaEstatica fila) {
            int dias = 0;
            while (n < m) {
                int media = 0;
                for (int i = 0; i < fila.tamanho(); i++) {
                    media += fila.vetor[i];
                }
                media = (int) Math.ceil((double) media / fila.tamanho());

                fila.desenfileira();
                fila.enfileira(media);

                n += media;
                dias++;
            }
            return dias;
        }

        public static void calculaAssociacao() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            FilaEstatica fila = new FilaEstatica(30);

            for (int i = 0; i < 30; i++) {
                int d = sc.nextInt();
                fila.enfileira(d);
            }

            int dias = calculaDias(n, m, fila);

            System.out.println(dias);
        }


        }
    public static void main(String[] args) {
        FilaEstatica.calculaAssociacao();
    }
}