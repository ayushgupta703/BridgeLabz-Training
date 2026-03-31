package Collections.Queue_Interface;

import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head = 0;
    private int count = 0;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void add(int value) {
        buffer[head] = value;
        head = (head + 1) % size;
        if (count < size) {
            count++;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        int idx = head;
        for (int i = 0; i < count; i++) {
            result.add(buffer[idx]);
            idx = (idx + 1) % size;
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        System.out.println("Buffer: " + cb.getBuffer());
        cb.add(4);
        System.out.println("Buffer after adding 4: " + cb.getBuffer());
    }
}
