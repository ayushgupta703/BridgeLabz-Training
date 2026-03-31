package functional_interfaces;

class Prototype implements Cloneable {
    int value = 100;

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneableExample {
    public static void main(String[] args) throws Exception {
        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype) p1.clone();
        System.out.println(p2.value);
    }
}
