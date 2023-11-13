import java.util.Scanner;

public class Main {
    static class PilhaDinamica {
        static class Nodo {
            char elemento;
            Nodo proximo;

            Nodo(char elemento) {
                this.elemento = elemento;
                this.proximo = null;
            }
        }

        private Nodo topo;
        private int nElementos;

        PilhaDinamica() {
            topo = null;
            nElementos = 0;
        }

        boolean estaVazia() {
            return nElementos == 0;
        }

        int tamanho() {
            return nElementos;
        }

        void empilha(char elemento) {
            Nodo novo = new Nodo(elemento);
            novo.proximo = topo;
            topo = novo;
            nElementos++;
        }

        char desempilha() {
            if (estaVazia()) {
                System.out.println("Pilha vazia. Não é possível desempilhar.");
                return '\0';
            }

            char elementoDesempilhado = topo.elemento;
            topo = topo.proximo;
            nElementos--;
            return elementoDesempilhado;
        }

        char[] toCharArray() {
            char[] array = new char[nElementos];
            Nodo atual = topo;
            int i = 0;

            while (atual != null) {
                array[i] = atual.elemento;
                atual = atual.proximo;
                i++;
            }

            return array;
        }
    }

    public static int contaDiamante(String caracteres) {
        PilhaDinamica p = new PilhaDinamica();
        int count = 0;

        for (char c : caracteres.toCharArray()) {
            if (c == '<') {
                p.empilha(c);
            } else if (c == '>' && !p.estaVazia()) {
                p.desempilha();
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            int contador = contaDiamante(input);
            System.out.println(contador);
        }
    }
}
