package lab2.Problema1;
public class Main {
    public static void main(String args[]) {
        Paralelogram paralelogram = new Paralelogram(4, 5, 4, 5, 60, 120, 60, 120);
        System.out.println(paralelogram.Arie());

        Romb romb = new Romb(4, 4, 4, 4, 60, 120, 60, 120, 4, 4);
        System.out.println(romb.Arie());

        Dreptunghi dreptunghi = new Dreptunghi(4, 5, 4, 5, 90, 90, 90, 90);
        System.out.println(dreptunghi.Arie());

        Patrat patrat = new Patrat(4, 4, 4, 4, 90, 90,90,90);
        System.out.println(patrat.Arie());
    }
}
