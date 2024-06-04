package Task2;

class C {
    public C() {
        System.out.println("C");
    }

    public C(int x) {
        System.out.println("C " + x);
    }
}

class D extends C {
    public D() {
        super(1);
        System.out.println("D");
    }

    public D(int x) {
        System.out.println("D " + x);
    }
}

class E extends D {
    public E() {
        super(1);
        System.out.println("E");
    }
}

public class T2 {
    public static void main(String[] args) {
        new E();
    }
}

//se afiseaza C, D 1 si E
//pleaca din new E, apeleaza super(1) si merge la D, unde apeleaza mai intai constructorul implicit pt C (adica super())
//il afiseaza pe C, se intoarce la D si apeleaza functia cu D concatenat cu 1
//si se intoarce la E si il afiseaza