package Collections.Set_Interface;

import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Original Set: " + set);
        System.out.println("Sorted List: " + convertAndSort(set));
    }
}
