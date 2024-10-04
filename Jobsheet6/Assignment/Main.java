package Jobsheet6.Assignment;

public class Main {
    public static void main(String[] args) {
        DaftarGaji daftarGaji = new DaftarGaji(2);

        Dosen dosen1 = new Dosen("123", "Dr. Ridho", "Jl. Idjen");
        Dosen dosen2 = new Dosen("321", "Dr. Ratio", "Jl. Semeru");
        dosen1.setSKS(12);
        dosen2.setSKS(11);

        daftarGaji.addPegawai(dosen1);
        daftarGaji.addPegawai(dosen2);
        daftarGaji.printSemuaGaji();
    }
}