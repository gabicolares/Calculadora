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
    private Node<E> head;
    private Node<E> tail;

    public StackLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    public void push(E element) {
        Node<E> aux = new Node<>(element);
        Node<E> ant =  head;

        if (count == 0) {
            head = aux;
        }
        head = aux;
        head.next = ant;
        
        count++;
    }

    public E pop() {
        if (count == 0) {
            throw new EmptyStackException();
        }
        E num = head.element;
        head = head.next;
        
        return num;
        
    }

    public E top() {
        if (count == 0)
            throw new EmptyStackException();

        return head.element;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public  void clear() {
        head = null;
        tail = null;
        count = 0;
    }

}
