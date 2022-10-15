public class App {
    public static void main(String args[]) {
        StackLinkedList<String> test = new StackLinkedList<>();

        test.push("Primeiro Elemento Adicionado");
        test.push("Segundo Elemento Adicionado");
        test.push("Terceiro Elemento Adicionado");
        test.push("Quarto Elemento Adicionado");
        test.push("Quinto Elemento Adicionado");

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        

    }
}