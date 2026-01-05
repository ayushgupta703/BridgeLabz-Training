package Collections.List_Interface;

import java.util.*;

public class ReverseList {
    public static <T> List<T> reverseArrayList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static <T> List<T> reverseLinkedList(LinkedList<T> list) {
        List<T> reversed = new LinkedList<>();
        Iterator<T> itr = list.descendingIterator();
        while (itr.hasNext()) {
            reversed.add(itr.next());
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reverseArrayList(arrayList));

        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkedList));
    }
}
