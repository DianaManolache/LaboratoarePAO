package Task3;

class F {
    public int a = 0;
}

public class T3 {
    public static void main(String[] args) {
        F f = new F();
        bar(f);
        System.out.println(f.a);
        System.out.println(foo());
    }

    private static void bar(F f) {
        try {
            f.a = 1;
        } finally {
            f.a = 2;
        }
    }

    private static int foo() {
        try {
            return 0;
        } finally {
            return 3;
        }
    }
}

//afiseaza 2 si 3 pentru ca in bar, try seteaza la 1 dar finally il schimba la 2
//iar 3 pentru ca blocul finally din metoda foo suprascrie valoarea returnata din blocul try