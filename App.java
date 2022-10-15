public class App {
    public static void main(String args[]) {
        StackLinkedList<Integer> test = new StackLinkedList<>();

        test.push(10);
        test.push(2);
        test.push(9);
        test.push(22);
        test.push(3);

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        

    }
}