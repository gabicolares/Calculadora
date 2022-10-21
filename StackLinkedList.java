import java.util.EmptyStackException;


public class StackLinkedList<E> {

    private class Node <T> {
        public T element;
        public Node<T> next;
        public Node(T e) {
            element = e;
            next = null;
        }
    }
    // Atributos da classe Fila (Queue)
    private int count;
    private Node<E> topo;

    public StackLinkedList() {
        count = 0;
        topo = null;
    }

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

    public E pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        E num = topo.element;
        topo = topo.next;
        count--;
        
        return num;
        
    }

    public E top() {
        if (count == 0)
            throw new EmptyStackException();

        return topo.element;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public  void clear() {
        topo = null;
        count = 0;
    }

}
