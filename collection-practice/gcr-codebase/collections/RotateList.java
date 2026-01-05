package Collections.List_Interface;

import java.util.*;

public class RotateList {
    public static <T> List<T> rotate(List<T> list, int k) {
        int n = list.size();
        List<T> rotated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rotated.add(list.get((i + k) % n));
        }
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;

        System.out.println("Original List: " + list);
        System.out.println("Rotated by " + k + ": " + rotate(list, k));
    }
}
