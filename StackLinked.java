import java.util.EmptyStackException;


public class StackLinked<E> {

    private class Node <T> {
        public T element;
        public Node<T> next;
        public Node(T e) {
            element = e;
            next = null;
        }
    }
    // Atributos da classe
    private int count;
    private Node<E> topo;

    public StackLinked() {
        count = 0;
        topo = null;
    }

    /**
     * Adiciona um elemento ao topo da pilha
     * @param element elemento a ser adicionado
     */
    public void push(E element) {
        Node<E> aux = new Node<>(element);
        Node<E> ant =  topo;

        if (count == 0) {
            topo = aux;
        }
        topo = aux;
        topo.next = ant;
        
        count++;
    }

    /**
     * Retorna e remove o elemento do topo da pilha
     * @return o elemento do topo da pilha
     */
    public E pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        E num = topo.element;
        topo = topo.next;
        count--;
        
        return num;
        
    }

    /**
     * Retorna o elemento do topo da pilha
     * @return o elemento do topo da pilha
     */
    public E top() {
        if (count == 0)
            throw new EmptyStackException();

        return topo.element;
    }

    /**
     * Retorna o tamanho da pilha
     * @return o tamanho
     */
    public int size() {
        return count;
    }

    /**
     * Verifica se a pilha está vazia
     * @return true se estiver fazia e false se tiver elementos
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Limpa a pilha e a deixa sem elementos
     */
    public  void clear() {
        topo = null;
        count = 0;
    }

}
