package Task1;

class A {
    public static int a = 0;
}

class B extends A {
    public static int a = 5;
}

public class T1 {
    public static void main(String[] args) {
        A a = new B();
        a.a++;
        System.out.println(A.a);
        System.out.println(B.a);
    }
}

//Output: 1 5
//variabila a este statica, deci avem doua variabile statice separate - A.a si B.a.
//am incrementat pe a din clasa A, pentru ca referinta e de tip A => 0 + 1 = 1
//apoi se afiseaza 5 pentru ca ramane valoarea variabilei statice a din B, care nu e modificata

