package Jobsheet6.Assignment;

public class Main {
    public static void main(String[] args) {
        DaftarGaji daftarGaji = new DaftarGaji(2);

        Dosen dosen1 = new Dosen("123", "Dr. Ridho", "Jl. Idjen");
        dosen1.setSKS(12);

        daftarGaji.addPegawai(dosen1);

        daftarGaji.printSemuaGaji();
    }
}