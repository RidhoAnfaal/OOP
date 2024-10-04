package Jobsheet6.Assignment;

public class DaftarGaji {
    private Pegawai[] listPegawai;
    private int idx = 0;

    public DaftarGaji(int jumlahPegawai) {
        listPegawai = new Pegawai[jumlahPegawai];
    }

    public void addPegawai(Pegawai p) {
        if (idx < listPegawai.length) {
            listPegawai[idx] = p;
            idx++;
        }
    }

    public void printSemuaGaji() {
        System.out.println("=== Data Pegawai ===");
        for (int i = 0; i < idx; i++) {
            System.out.println("Nama: " + listPegawai[i].getNama());
            System.out.println("Gaji: Rp." + listPegawai[i].getGaji());
            System.out.println("---------------------");
        }
    }
}