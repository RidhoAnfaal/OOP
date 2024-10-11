package Jobsheet7;

public class Segitiga {
    @SuppressWarnings("unused")
    private int sudut;

    public int totalSudut(int sudutA) {
        return 180 - sudutA;
    }

    public int totalSudut(int sudutA, int sudutB) {
        return 180 - (sudutA + sudutB);
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        return Math.sqrt((sisiA * sisiA) + (sisiB * sisiB));
    }

    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();
        System.out.println("Total Sudut (1 parameter): " + segitiga.totalSudut(82));
        System.out.println("Total Sudut (2 parameters): " + segitiga.totalSudut(45, 55));
        System.out.println("Keliling (3 parameters): " + segitiga.keliling(7, 7, 7));
        System.out.println("Keliling (2 parameters): " + segitiga.keliling(2, 3));
    }
}
